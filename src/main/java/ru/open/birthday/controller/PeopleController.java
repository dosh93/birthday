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
        List<People> all = peopleService.getListPeopleByFilter(false, "");
        model.addAttribute("peopleList", all);
        return "people/people";
    }

    @PostMapping("/delete/{id}")
    public String  deletePeople(@PathVariable Integer id){
        peopleService.delete(peopleService.findById(id));
        return "redirect:/people";
    }

    @GetMapping("/add-people")
    public String addPeoplePage(Model model){
        People people = new People();
        model.addAttribute("people", people);
        model.addAttribute("path", "/people/add-people");
        return "people/add_people";
    }

    @PostMapping("/add-people")
    public String addPeople(@Valid People people, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            model.addAttribute("path", "/people/add-people");
            return "people/add_people";
        }
        people.setId(peopleService.getMaxId() + 1);
        peopleService.createPeople(people);
        return "redirect:/people";
    }

    @GetMapping("/{id}/edit")
    public String editPeoplePage(@PathVariable Integer id, Model model){
        People people = peopleService.findById(id);
        model.addAttribute("people", people);
        model.addAttribute("path", "/people/" + id + "/edit");
        return "people/add_people";
    }

    @PostMapping("/{id}/edit")
    public String editPeople(@PathVariable Integer id, @Valid People people, BindingResult bindingResult, Model model){
        people.setId(id);
        if (bindingResult.hasErrors()){
            Map<String, String> errors = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errors);
            model.addAttribute("path", "/people/" + id + "/edit");
            return "people/add_people";
        }
        peopleService.createPeople(people);
        return "redirect:/people";
    }
}
