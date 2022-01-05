package org.hua.dit.distributedsystems.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/index")
    public String view() {
        return "index";
    }

    @GetMapping("/menuTeacher")
    public String menuTeacher() {
        return "menuTeacher";
    }

    @GetMapping("/menuStudent")
    public String menuStudent() {
        return "menuStudent";
    }
}
