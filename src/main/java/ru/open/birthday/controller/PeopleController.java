package ru.open.birthday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.open.birthday.entity.People;
import ru.open.birthday.service.PeopleService;

import java.util.List;

@Controller
@RequestMapping("people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("")
    public String getPeoplePage(Model model){
        List<People> all = peopleService.findAll();
        model.addAttribute("peopleList", all);
        return "people/people";
    }
}
