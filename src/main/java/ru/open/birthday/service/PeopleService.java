package ru.open.birthday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.open.birthday.entity.People;
import ru.open.birthday.repository.PeopleRepository;

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

}
