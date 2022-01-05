package org.hua.dit.distributedsystems.controllers;

import org.hua.dit.distributedsystems.models.post.ClassPost;
import org.hua.dit.distributedsystems.models.post.QuestionPost;
import org.hua.dit.distributedsystems.models.post.SubjectPost;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@org.springframework.web.bind.annotation.RestController
public class RestController {


    //API


//    /home --> login page (post)
//    email password

//ENERGEIES KATHIGHTH

    // /menuTeacher --> central menu after the sign in from a teacher role=="teacher" (get)

    // /createClass --> form for create a class (post)

    // /updateClass --> form for update the class (post)

    // /deleteClass --> pop up for confirmation to delete the class (delete)

    // /menuClass

    // /createSubject --> form for create a subject (post)

    // /updateSubject --> form for update the Subject (patch)

    // /deleteSubject --> pop up for confirmation to delete the Subject (delete)

    // /menuChapter

    // /createQuestion --> form for create a Question (post)

    // /updateQuestion --> form for update the Question (patch)

    // /deleteQuestion --> pop up for confirmation to delete the Question (delete)

    // /menuQuestion

    // /question --> two endpoints but one for create (post) and the other for update (patch)

    // /menuStudentManage

    // /createStudent --> form for create a student (post)

    // /deleteStudent --> pop up for confirmation to delete the Student (delete)

    // /getStudentsList --> (get)

    // /getDetails --> get details for a student (get)

    //ENERGEIES MATHHTH

    // /signin (post)
    // /login (post)
    //  /doQuiz  (get) emfanish selidas epilogwn
    //  /doQuiz/info (post) kataxwrhsh plhroforiwn
    //  /doQuiz/info (get) emfanish me bash tis plhrofories
    //  /doQuiz/info/quiz (get) epilogh quiz
    //  /doQuiz/info/quiz (post) kataxwrhsh apanthsewn sto quiz
    //  /doQuiz/info/quiz/grade (get) emfanish batmou

    // /myGrades (get) emfanish bathologiwn se ola ta quiz pou exei kanei

































































































    // createClass --> /class (post)
    @PostMapping(value="/class" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void classPost(@RequestBody ClassPost classPost) {

        //todo
        System.out.println(classPost.getClass_id()+","+classPost.getClass_name());
    }

    // delete Question --> /question (delete)
    @DeleteMapping("/class/{id}")
    public void deleteClass(@PathVariable Long id) {
        //repository.deleteById(id);
    }


    // createSubject --> /subject (post)
    @PostMapping(value="/subject" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
        public void classPost(@RequestBody SubjectPost subjectPost) {

        System.out.println(subjectPost.getSubject_class()+","+subjectPost.getSubject_id()+","+subjectPost.getSubject_name());
        return;

        }

    // delete Question --> /question (delete)
    @DeleteMapping("/subject/{id}")
    public void deleteSubject(@PathVariable Long id) {
        //repository.deleteById(id);
    }


    // createQuestion --> /question (post)
    @PostMapping(value="/question" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void collaborativePost(@RequestBody QuestionPost questionPost) {

        System.out.println(questionPost.getQuestion_image()+","+questionPost.getQuestion_text()+","+questionPost.getQuestion_option1()+","+questionPost.getQuestion_option2()+","+questionPost.getQuestion_option3()+","+questionPost.getQuestion_script());
        return;
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
    @DeleteMapping("/question/{id}")
    void deleteQuestion(@PathVariable Long id) {
        //repository.deleteById(id);
    }
}
