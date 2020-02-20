package ru.open.birthday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.open.birthday.entity.People;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Integer> {

    List<People> findAllByNameContaining(String query);

}
