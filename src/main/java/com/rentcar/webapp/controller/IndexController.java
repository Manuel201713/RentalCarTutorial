package com.rentcar.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController
{
    @RequestMapping(value="index")
    public String getWelcome(Model model)
    {
        model.addAttribute("intestazione", "Benvenuti nel sito Rental Car");
        model.addAttribute("saluti", "Accedi per usufruire dei nostri servizi");

        return "index";
    }

    @GetMapping
    public String getWelcome2(Model model)
    {
        model.addAttribute("intestazione", "Benvenuti nel sito Rental Car");
        model.addAttribute("saluti", "Accedi per usufruire dei nostri servizi");

        return "index";
    }
}
