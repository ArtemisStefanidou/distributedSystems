package org.hua.dit.distributedsystems.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student/")
public class Student {

    @GetMapping("menu")
    public String menuStudent() {
        return "login/menuStudent";
    }

    @GetMapping("quiz")
    public String findQuiz() {
        return "student/findQuiz";
    }

    @GetMapping("grades")
    public String myGrades() {
        return "student/myGrades";
    }

}
