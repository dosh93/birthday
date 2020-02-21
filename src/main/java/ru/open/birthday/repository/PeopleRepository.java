package ru.open.birthday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.open.birthday.entity.People;

import java.util.List;

public interface PeopleRepository extends JpaRepository<People, Integer> {

    List<People> findAllByNameContainingOrderByName(String query);

    @Query(value = "select * from people p where make_date(cast(extract(year from current_date) as integer), " +
            "cast(extract(month from p.birthday) as integer), cast(extract(day from p.birthday) as integer)) - current_date <= :dayTo " +
            "and make_date(cast(extract(year from current_date) as integer), cast(extract(month from  p.birthday) as integer)," +
            " cast(extract(day from  p.birthday) as integer)) - current_date >= -:dayAfter and p.name like :names",nativeQuery = true)
    List<People> peoplesBirthday(Integer dayTo, Integer dayAfter, String names);

    @Query(value = "SELECT MAX(id) FROM People p")
    Integer getMaxId();


}
