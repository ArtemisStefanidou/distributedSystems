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

    @GetMapping("/student/quiz")
    public String findQuiz() {
        return "login/student/findQuiz";
    }

    @GetMapping("/student/grades")
    public String myGrades() {
        return "AboutTeacher";
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

    @GetMapping("teacher/studentManage")
    public String studentManageMenu() {
        return "/login/studentManageMenu";
    }

    @GetMapping("teacher/aboutMe")
    public String teacherAboutMe() {
        return "/login/teacher/AboutTeacher";
    }




}