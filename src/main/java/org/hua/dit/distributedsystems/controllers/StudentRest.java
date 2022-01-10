package org.hua.dit.distributedsystems.controllers;

import org.hua.dit.distributedsystems.models.post.ClassPost;
import org.hua.dit.distributedsystems.models.post.GradePost;
import org.hua.dit.distributedsystems.models.post.QuestionPost;
import org.hua.dit.distributedsystems.models.post.SubjectPost;
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

    public void findquizPost(@RequestBody QuestionPost questionPost, ClassPost classPost, SubjectPost subjectPost) {

        //todo
        System.out.println("Question:"+questionPost.getQuestion_id() + "ClassName:" +classPost.getClass_name() +"ClassID:"+classPost.getClass_id()
                +"Subject Name"+subjectPost.getSubject_name() + "Subject ID" +subjectPost.getSubject_id());

    }

    //  /doQuiz/info (get) emfanish me bash tis plhrofories


    //  /doQuiz/info/quiz (get) epilogh quiz
    //  /findquiz/quizanswers (post) kataxwrhsh apanthsewn sto quiz
    @PostMapping(value="guizanswers" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void guizanswers(@RequestBody GradePost gradePost) {

        //todo edw gurnaw apla ton bathmo sto question thelei ftiaksimo
        System.out.println(gradePost.getGrade_of_question());

    }

    //  /doQuiz/info/quiz/grade (get) emfanish bathmou

    // /myGrades (get) emfanish bathologiwn se ola ta quiz pou exei kanei
}
