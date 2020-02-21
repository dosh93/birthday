package ru.open.birthday.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.open.birthday.entity.Config;
import ru.open.birthday.service.ConfigService;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("config")
public class ConfigController {

    @Autowired
    private final ConfigService configService;

    public ConfigController(ConfigService configService) {
        this.configService = configService;
    }

    @GetMapping("update")
    public String updatePage(Model model){
        List<Config> configList = configService.getAll();
        model.addAttribute("configList", configList);
        return "config/update";
    }

    @PostMapping("update")
    public String update(@RequestParam Map<String,String> allRequestParams){
        for (Map.Entry<String, String> entry : allRequestParams.entrySet()) {
            Config config = configService.getByKey(entry.getKey());
            config.setValue(entry.getValue());
            configService.save(config);
        }
        return "redirect:/";
    }

}
