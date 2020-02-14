package ru.open.birthday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.open.birthday.repository.DepositedMoneyRepository;

@Service
public class DepositedMoneyService {

    @Autowired
    private final DepositedMoneyRepository depositedMoneyRepository;

    public DepositedMoneyService(DepositedMoneyRepository depositedMoneyRepository) {
        this.depositedMoneyRepository = depositedMoneyRepository;
    }
}
