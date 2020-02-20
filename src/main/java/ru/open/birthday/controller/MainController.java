package ru.open.birthday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.open.birthday.service.DepositedMoneyService;
import ru.open.birthday.service.PeopleService;

@Controller
public class MainController {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private DepositedMoneyService depositedMoneyService;

    @GetMapping("")
    public String viewMainPage(Model model){
        peopleService.findAll();
    }
}
