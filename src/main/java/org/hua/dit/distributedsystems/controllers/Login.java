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
        return "login/findQuiz";
    }

    @GetMapping("/student/grades")
    public String myGrades() {
        return "login/myGrades";
    }

    @GetMapping("teacher/menu")
    public String menuTeacher() {
        return "/login/menuTeacher";
    }

    @GetMapping("teacher/class")
    public String classMenu() {
        return "/login/classMenu";
    }

    @GetMapping("teacher/subject")
    public String chapterMenu() {
        return "/login/subjectMenu";
    }

    @GetMapping("teacher/question")
    public String questionMenu() {
        return "/login/questionMenu";
    }

    @GetMapping("teacher/studentManage")
    public String studentManageMenu() {
        return "/login/studentManageMenu";
    }






}
