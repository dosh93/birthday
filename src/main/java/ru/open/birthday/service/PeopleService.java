package ru.open.birthday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.open.birthday.entity.People;
import ru.open.birthday.repository.PeopleRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class PeopleService {
    @Autowired
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
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
    public People findById(Integer id){
        return peopleRepository.findById(id).get();
    }

    @Transactional
    public void delete(People people){
        peopleRepository.delete(people);
    }

    @Transactional
    public List<People> searchPeople(String query){
        return peopleRepository.findAllByNameContaining(query);
    }

    @Transactional
    public List<People> findAllByCountDaysParam(Integer dayTo, Integer dayAfter){
        return peopleRepository.peoplesBirthday( dayTo,  dayAfter);
    }

    public void setDaysCount(List<People> all) {
        for (People people: all) {
            Date date = people.getBirthday();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("ddMMyyyy");
            Date birthdayCurrentYear = null;
            Date currentDate = null;
            Calendar birthday =  Calendar.getInstance();
            birthday.setTime(date);
            Calendar current = Calendar.getInstance();
            String year = String.valueOf(current.get(Calendar.YEAR));
            String month = String.valueOf(birthday.get(Calendar.MONTH) + 1).length() == 1 ?  "0" + (birthday.get(Calendar.MONTH) + 1) : String.valueOf(birthday.get(Calendar.MONTH) + 1);
            String day = String.valueOf(birthday.get(Calendar.DAY_OF_MONTH)).length() == 1 ?  "0" + birthday.get(Calendar.DAY_OF_MONTH) : String.valueOf(birthday.get(Calendar.DAY_OF_MONTH));
            String birthdayCurrentYearString = day + month + year;

            try {
                birthdayCurrentYear = simpleDateFormat.parse(birthdayCurrentYearString);
            } catch (ParseException e) {
                people.setCountDays(null);
            }

            month = String.valueOf(current.get(Calendar.MONTH) + 1).length() == 1 ?  "0" + (current.get(Calendar.MONTH) + 1) : String.valueOf(current.get(Calendar.MONTH) + 1);
            day = String.valueOf(current.get(Calendar.DAY_OF_MONTH)).length() == 1 ?  "0" + current.get(Calendar.DAY_OF_MONTH) : String.valueOf(current.get(Calendar.DAY_OF_MONTH));

            try {
                currentDate = simpleDateFormat.parse(day + month + year);
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Long dayToBirthday = (birthdayCurrentYear.getTime() - currentDate.getTime())/1000/60/60/24;
            people.setCountDays(dayToBirthday);
        }
    }
}
