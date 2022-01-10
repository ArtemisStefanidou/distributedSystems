package org.hua.dit.distributedsystems.controllers;

import org.hua.dit.distributedsystems.models.post.ClassPost;
import org.hua.dit.distributedsystems.models.post.QuestionPost;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student/")
public class StudentRest {
    //ENERGEIES MATHHTH

    public StudentRest() {
        //arxikopoihseis

    }


    //  findQuiz (post)-->/findquiz kataxwrhsh plhroforiwn
    @PostMapping(value="quiz" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void findquizPost(@RequestBody QuestionPost questionPost) {

        //todo
        System.out.println(""+questionPost.getQuestion_id());

    }

    //  /doQuiz/info (get) emfanish me bash tis plhrofories
    //  /doQuiz/info/quiz (get) epilogh quiz
    //  /doQuiz/info/quiz (post) kataxwrhsh apanthsewn sto quiz
    //  /doQuiz/info/quiz/grade (get) emfanish batmou

    // /myGrades (get) emfanish bathologiwn se ola ta quiz pou exei kanei
}
