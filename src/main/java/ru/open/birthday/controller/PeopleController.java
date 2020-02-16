package ru.open.birthday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.open.birthday.entity.People;
import ru.open.birthday.service.PeopleService;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/add-people")
    public String addPeoplePage(Model model){
        People people = new People();
        model.addAttribute("people", people);
        return "people/add_people";
    }

    @PostMapping("/add-people")
    public String addPeople(@Valid People people, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            return "people/add_people";
        }
        peopleService.createPeople(people);
        return "redirect:/people";
    }
}
