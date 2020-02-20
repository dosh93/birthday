package ru.open.birthday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.open.birthday.entity.People;
import ru.open.birthday.service.PeopleService;

import java.util.Comparator;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping("")
    public String homePage(Model model){
        List<People> all = peopleService.findAllByCountDaysParam(3, 3);
        peopleService.setDaysCount(all);
        all.sort(new Comparator<People>() {
            @Override
            public int compare(People o1, People o2) {
                return (int) (o1.getCountDays() - o2.getCountDays());
            }
        });
        model.addAttribute("peopleList", all);
        return "home";
    }

    @GetMapping("/search-people")
    public String peopleSearch(@RequestParam String query, Model model){
        List<People> people = null;
        if (query.equals("")) people = peopleService.findAll();
        else people= peopleService.searchPeople(query);
        model.addAttribute("peopleList", people);
        return "main/peopleList";
    }
}
