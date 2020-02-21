package ru.open.birthday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.open.birthday.entity.People;
import ru.open.birthday.service.PeopleService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PeopleService peopleService;


    @GetMapping("")
    public String homePage(Model model){
        List<People> all = peopleService.getListPeopleByFilter(true, "");
        model.addAttribute("peopleList", all);
        return "home";
    }

    @GetMapping("/search-people")
    public String peopleSearch(@RequestParam String query, @RequestParam boolean birthday, Model model){
        List<People> people = peopleService.getListPeopleByFilter(birthday, query);
        model.addAttribute("peopleList", people);
        return "main/peopleList";
    }
}
