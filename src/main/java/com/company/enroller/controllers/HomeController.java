package com.company.enroller.controllers;

import com.company.enroller.model.Meeting;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping("/")
    public String  getMeetings() {
        return "redirect:/meetings";
    }
}
