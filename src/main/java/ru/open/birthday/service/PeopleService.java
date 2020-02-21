package ru.open.birthday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.open.birthday.entity.People;
import ru.open.birthday.helper.DateHelper;
import ru.open.birthday.repository.PeopleRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PeopleService {
    @Autowired
    private final PeopleRepository peopleRepository;

    @Autowired
    private final ConfigService configService;

    public PeopleService(PeopleRepository peopleRepository, ConfigService configService) {
        this.peopleRepository = peopleRepository;
        this.configService = configService;
    }

    @Transactional
    public void createPeople(People people){
        peopleRepository.save(people);
    }

    @Transactional
    public List<People> findAll(){
        return peopleRepository.findAll();
    }

    @Transactional
    public Integer getMaxId(){
        return peopleRepository.getMaxId();
    }

    @Transactional
    public People findById(Integer id){
        return peopleRepository.findById(id).get();
    }

    @Transactional
    public void delete(People people){
        peopleRepository.delete(people);
    }

    @Transactional
    public List<People> searchPeople(String query){
        return peopleRepository.findAllByNameContainingOrderByName(query);
    }

    public void setDaysCount(List<People> all) {
        Integer dayAfter = Integer.parseInt(configService.getValueByKey("dayAfter"));
        for (People people: all) {
            Long daysBeforeBirthday = DateHelper.getDaysBeforeBirthday(people.getBirthday());
            if (daysBeforeBirthday + dayAfter > DateHelper.getCountDayCurrentYear()){
                people.setCountDays(daysBeforeBirthday - DateHelper.getCountDayCurrentYear());
            }else {
                people.setCountDays(daysBeforeBirthday);
            }
        }
    }

    public List<People> getListPeopleByFilter(Boolean sortBirthday, String name){
        List<People> peopleList = new ArrayList<>();
        if (sortBirthday){
            Integer dayTo = Integer.parseInt(configService.getValueByKey("dayTo"));
            Integer dayAfter = Integer.parseInt(configService.getValueByKey("dayAfter"));
            peopleList = searchPeople(name);
            setDaysCount(peopleList);
            List<People> peopleListCurr = new ArrayList<>(peopleList);
            for (People people: peopleListCurr) {
                if (!(people.getCountDays() <= dayTo) || !((people.getCountDays() *  -1) <= dayAfter)) peopleList.remove(people);
            }
            peopleList.sort(new Comparator<People>() {
                @Override
                public int compare(People o1, People o2) {
                    return (int) (o1.getCountDays() - o2.getCountDays());
                }
            });
        } else {
            peopleList = searchPeople(name);
            setDaysCount(peopleList);
        }
        return peopleList;
    }
}
