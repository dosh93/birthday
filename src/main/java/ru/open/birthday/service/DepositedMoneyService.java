package ru.open.birthday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.open.birthday.entity.DepositedMoney;
import ru.open.birthday.repository.DepositedMoneyRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class DepositedMoneyService {

    @Autowired
    private final DepositedMoneyRepository depositedMoneyRepository;

    public DepositedMoneyService(DepositedMoneyRepository depositedMoneyRepository) {
        this.depositedMoneyRepository = depositedMoneyRepository;
    }

    @Transactional
    public Integer getMaxId(){
        return depositedMoneyRepository.getMaxId();
    }


    @Transactional
    public void save(DepositedMoney depositedMoney){
        depositedMoneyRepository.save(depositedMoney);
    }

    public Integer getNextId() {
        List<DepositedMoney> depositedMoneyList = depositedMoneyRepository.findAll();
        if (depositedMoneyList.size() == 0) return 1;

        return depositedMoneyRepository.getMaxId() + 1;
    }
}
