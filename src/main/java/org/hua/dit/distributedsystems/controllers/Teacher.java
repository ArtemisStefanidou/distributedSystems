package org.hua.dit.distributedsystems.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/teacher/menu")
public class Teacher {

    @GetMapping("/")
    public String menuTeacher() {
        return "/teacher/menuTeacher";
    }

    @GetMapping("/class")
    public String classMenu() {
        return "/teacher/classMenu";
    }

    @GetMapping("/subject")
    public String chapterMenu() {
        return "/teacher/subjectMenu";
    }

    @GetMapping("/question")
    public String questionMenu() {
        return "/teacher/questionMenu";
    }

    @GetMapping("/studentManage")
    public String studentManageMenu() {
        return "/teacher/studentManageMenu";
    }
}
