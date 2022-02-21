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
        return "login/student/menuStudent";
    }

    @GetMapping("/student/findQuiz")
    public String findQuiz() {
        return "login/student/findQuiz";
    }

    @GetMapping("/student/quiz")
    public String Quiz() {
        return "login/student/quiz";
    }

    @GetMapping("teacher/menu")
    public String menuTeacher() {
        return "/login/teacher/menuTeacher";
    }

    @GetMapping("teacher/makeQuestion")
    public String questionMenu() {
        return "/login/teacher/makeQuestion";
    }

    @GetMapping("teacher/createStudent")
    public String studentMenu() {
        return "/login/teacher/createStudent";
    }

    @GetMapping("teacher/aboutMe")
    public String teacherAboutMe() {
        return "/login/teacher/AboutTeacher";
    }




}