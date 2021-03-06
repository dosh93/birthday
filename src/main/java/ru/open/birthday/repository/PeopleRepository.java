package ru.open.birthday.repository;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.open.birthday.entity.People;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Integer> {

    List<People> findAllByNameContainingOrderByName(String query);

    @Query(value = "SELECT MAX(id) FROM People p")
    Integer getMaxId();

    List<People> findAllByNameContainingOrderByName(String name, Pageable pageable);
}
