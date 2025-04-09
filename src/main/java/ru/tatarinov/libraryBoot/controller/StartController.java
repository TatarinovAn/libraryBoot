package ru.tatarinov.libraryBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StartController {
    @GetMapping()
    public String index() {
        return "index";
    }


    @GetMapping("/home")
    public String home() {
        return "redirect:/";
    }
}
