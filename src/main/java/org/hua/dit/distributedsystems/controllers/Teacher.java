package org.hua.dit.distributedsystems.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/teacher/")
public class Teacher {

    @GetMapping("menu")
    public String menuTeacher() {
        return "menuTeacher";
    }

    @GetMapping("menu/class")
    public String classMenu() {
        return "classMenu";
    }

    @GetMapping("menu/subject")
    public String chapterMenu() {
        return "subjectMenu";
    }

    @GetMapping("menu/question")
    public String questionMenu() {
        return "questionMenu";
    }

    @GetMapping("menu/studentManage")
    public String studentManageMenu() {
        return "studentManageMenu";
    }
}
