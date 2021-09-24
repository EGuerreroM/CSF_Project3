package com.project3.ecommerce.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String getIndex(Model model){
        model.addAttribute("logoImage","logo1.png");
        return "Index";
    }
}
