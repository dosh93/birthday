package ru.open.birthday.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.open.birthday.entity.DepositedMoney;

public interface DepositedMoneyRepository extends JpaRepository<DepositedMoney, Integer> {

}
