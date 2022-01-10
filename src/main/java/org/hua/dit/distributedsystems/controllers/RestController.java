package org.hua.dit.distributedsystems.controllers;

import org.hua.dit.distributedsystems.models.post.ClassPost;
import org.hua.dit.distributedsystems.models.post.QuestionPost;
import org.hua.dit.distributedsystems.models.post.SubjectPost;
import org.hua.dit.distributedsystems.models.post.UserPost;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/")
public class RestController {


    //API














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
