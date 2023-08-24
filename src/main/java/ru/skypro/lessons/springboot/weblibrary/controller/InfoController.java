package ru.skypro.lessons.springboot.weblibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.weblibrary.service.EmployeeService;

@RestController
@Profile("test")
@RequestMapping("/appInfo")
public class InfoController {

    @Value("dev")
    public String appEnv;

    @GetMapping
    public String GetString() {
       return appEnv;
    }
}
