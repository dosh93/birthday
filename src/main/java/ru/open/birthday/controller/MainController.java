package ru.open.birthday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.open.birthday.entity.DepositedMoney;
import ru.open.birthday.entity.People;
import ru.open.birthday.service.DepositedMoneyService;
import ru.open.birthday.service.PeopleService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PeopleService peopleService;

    @Autowired
    private DepositedMoneyService depositedMoneyService;


    @GetMapping("")
    public String homePage(Model model){
        List<People> all = peopleService.getListPeopleByFilter(true, "");
        List<People> who = peopleService.findAll();
        model.addAttribute("isGive", true);
        model.addAttribute("peopleList", all);
        model.addAttribute("peopleListWho", who);
        return "home";
    }

    @GetMapping("/search-people")
    public String peopleSearch(@RequestParam String query, @RequestParam boolean birthday,
                               @RequestParam(required = false) List<Integer> givePeople,
                               Model model){
        List<People> people = peopleService.getListPeopleByFilter(birthday, query);
        if (givePeople != null) peopleService.setIsGive(people, givePeople);
        if(birthday) model.addAttribute("isGive", true);
        model.addAttribute("peopleList", people);
        return "main/peopleList";
    }

    @GetMapping("/getOptionPeople")
    public String getOptionPeople(@RequestParam String query, Model model){
        List<People> peopleList = peopleService.findAllByNameContainingOrderByName(query, PageRequest.of(0, 2));
        model.addAttribute("peopleListWho", peopleList);
        return "main/optionalPeople";
    }

    @GetMapping("/sendMoneyAll")
    public String sendMoneyAll(@RequestParam Integer who, @RequestParam Double money,
                               @RequestParam(required = false) List<Integer> givePeople, Model model){
        Double allMoney = 0.0;
        People whoPeople = peopleService.findById(who);
        for (Integer idPeople: givePeople) {
            DepositedMoney depositedMoney = new DepositedMoney();
            depositedMoney.setMoney(money);
            depositedMoney.setWho(whoPeople);
            depositedMoney.setWhom(peopleService.findById(idPeople));
            depositedMoney.setId(depositedMoneyService.getNextId());
            depositedMoneyService.save(depositedMoney);
            allMoney += money;
        }

        model.addAttribute("successesMessage", "УСПЕХ! " + whoPeople.getName() + " должен сдать " + allMoney + " рублей.");
        return "main/successesMessage";
    }

}
