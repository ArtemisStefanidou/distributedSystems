package org.hua.dit.distributedsystems.controllers;

import org.hua.dit.distributedsystems.models.post.ClassPost;
import org.hua.dit.distributedsystems.models.post.QuestionPost;
import org.hua.dit.distributedsystems.models.post.SubjectPost;
import org.hua.dit.distributedsystems.models.post.UserPost;
import org.hua.dit.distributedsystems.repositories.ClassRepo;
import org.hua.dit.distributedsystems.repositories.UserRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teacher/")
public class TeacherRest {
    //ENERGEIES KATHIGHTH

    private final ClassRepo classRepo;
    private final UserRepo userRepo;

    public TeacherRest(ClassRepo classRepo, UserRepo userRepo) {
        this.classRepo = classRepo;
        this.userRepo = userRepo;
    }

    // createClass --> /class (post)
    @PostMapping(value="class" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void classPost(@RequestBody ClassPost classPost) {

        //todo
        System.out.println(classPost.getClass_id()+","+classPost.getClass_name());

    }


    // /updateClass --> form for update the class (post)

    // /deleteClass --> pop up for confirmation to delete the class (delete)

    @DeleteMapping("/class/{id}")
    void deleteEmployee(@PathVariable Long id) {
        classRepo.deleteById(id);
        System.out.println("here");
    }
    // createSubject --> /subject (post)
    @PostMapping(value="subject" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public void classPost(@RequestBody SubjectPost subjectPost) {

        System.out.println(subjectPost.getSubject_class()+","+subjectPost.getSubject_id()+","+subjectPost.getSubject_name());
        return;

    }

    // /updateSubject --> form for update the Subject (patch)

    // /deleteSubject --> pop up for confirmation to delete the Subject (delete)

    // createQuestion --> /question (post)
    @PostMapping(value="question" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void collaborativePost(@RequestBody QuestionPost questionPost) {

        System.out.println(questionPost.getQuestion_image()+","+questionPost.getQuestion_text()+","+questionPost.getQuestion_option1()+","+questionPost.getQuestion_option2()+","+questionPost.getQuestion_option3()+","+questionPost.getQuestion_script());
        return;
    }

    // /updateQuestion --> form for update the Question (patch)

    // /deleteQuestion --> pop up for confirmation to delete the Question (delete)

    // createUser --> /user (post)
    @PostMapping(value="user" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void userPost(@RequestBody UserPost userPost) {

        //todo
        System.out.println(userPost.getUser_email()+","+userPost.getUser_role()+","+userPost.getUser_fullname()+","+userPost.getUser_teacher()+","+userPost.getUser_id()+","+userPost.getUser_password()+","+userPost.getUser_phone_number());
    }

    // /deleteStudent --> pop up for confirmation to delete the Student (delete)

    // /getStudentsList --> (get)

    // /getDetails --> get details for a student (get)
}
