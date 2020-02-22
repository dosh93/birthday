package ru.open.birthday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.open.birthday.entity.DepositedMoney;

public interface DepositedMoneyRepository extends JpaRepository<DepositedMoney, Integer> {

    @Query(value = "SELECT MAX(id) FROM DepositedMoney d")
    Integer getMaxId();
}
