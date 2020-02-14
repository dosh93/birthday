package ru.open.birthday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/delete/{id}")
    public String deletePeople(@PathVariable Integer id){
        peopleService.delete(peopleService.findById(id));
        return "redirect:/people";
    }
}
