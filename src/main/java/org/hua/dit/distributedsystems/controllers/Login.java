package org.hua.dit.distributedsystems.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class Login {

    @GetMapping("/menu")
    public String login() {
        return "/login/login";
    }

    @GetMapping("/student/menu")
    public String menuStudent() {
        return "login/menuStudent";
    }

    @GetMapping("/student/quiz")
    public String findQuiz() {
        return "student/findQuiz";
    }

    @GetMapping("/student/grades")
    public String myGrades() {
        return "student/myGrades";
    }


}
