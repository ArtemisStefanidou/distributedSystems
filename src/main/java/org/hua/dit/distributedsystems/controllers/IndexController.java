package org.hua.dit.distributedsystems.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IndexController {

    @GetMapping("index")
    public String login() {
        return "login";
    }

    @GetMapping("menuTeacher")
    public String menuTeacher() {
        return "menuTeacher";
    }

    @GetMapping("menuStudent")
    public String menuStudent() {
        return "menuStudent";
    }

    @GetMapping("menuTeacher/classMenu")
    public String classMenu() {
        return "classMenu";
    }

    @GetMapping("menuTeacher/subjectMenu")
    public String chapterMenu() {
        return "subjectMenu";
    }

    @GetMapping("menuTeacher/questionMenu")
    public String questionMenu() {
        return "questionMenu";
    }

    @GetMapping("menuTeacher/studentManageMenu")
    public String studentManageMenu() {
        return "studentManageMenu";
    }
}
