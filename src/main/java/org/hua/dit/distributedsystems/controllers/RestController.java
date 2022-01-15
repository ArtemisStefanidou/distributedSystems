package org.hua.dit.distributedsystems.controllers;

import org.hua.dit.distributedsystems.models.Class;
import org.hua.dit.distributedsystems.models.Subject;
import org.hua.dit.distributedsystems.repositories.ClassRepo;
import org.hua.dit.distributedsystems.repositories.SubjectRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {


    private final ClassRepo classRepo;
    private final SubjectRepo subjectRepo;

    public RestController(ClassRepo classRepo, SubjectRepo subjectRepo) {
        this.classRepo = classRepo;
        this.subjectRepo = subjectRepo;
    }

    // /getClass --> get the classes for drop down list in html (get)
    @GetMapping("classList/")
    List<Class> allClass() {
        return classRepo.findAll();
    }

    // /getClass --> get the classes for drop down list in html (get)
    @GetMapping("subjectList/")
    List<Subject> allSubject() {
        return subjectRepo.findAll();
    }



    // delete Question --> /question (delete)
    @DeleteMapping("class/{id}")
    public void deleteClass(@PathVariable Long id) {
        //repository.deleteById(id);
    }




    // delete Question --> /question (delete)
    @DeleteMapping("subject/{id}")
    public void deleteSubject(@PathVariable Long id) {
        //repository.deleteById(id);
    }



//    @PostMapping(value="/question" , consumes = {
//            MediaType.APPLICATION_JSON_VALUE
//    })
//
//    public void questionPost(@RequestBody QuestionPost questionPost) {
//
//        System.out.println(questionPost.getQuestion_image()+","+questionPost.getQuestion_text()+","+questionPost.getQuestion_option1()+","+questionPost.getQuestion_option2()+","+questionPost.getQuestion_option3()+","+questionPost.getQuestion_script());
//        return;
//    }


    // delete Question --> /question (delete)
    @DeleteMapping("question/{id}")
    void deleteQuestion(@PathVariable Long id) {
        //repository.deleteById(id);
    }


}
