package com.abc.demo.config.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class DemoController {
    
    @GetMapping(value = "/")
    public String demo() {
        return "login Success";
    }
    
    //進入login
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("username",request.getUserPrincipal().getName());
        return "index";
    }
}
