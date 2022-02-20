package org.hua.dit.distributedsystems.controllers;

import org.hua.dit.distributedsystems.models.Grade;
import org.hua.dit.distributedsystems.models.Question;
import org.hua.dit.distributedsystems.models.Role;
import org.hua.dit.distributedsystems.models.User;
import org.hua.dit.distributedsystems.models.post.QuestionPost;
import org.hua.dit.distributedsystems.models.post.UserPost;
import org.hua.dit.distributedsystems.repositories.*;
import org.hua.dit.distributedsystems.service.QuestionService;
import org.hua.dit.distributedsystems.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher/")
public class TeacherRest {
    //ENERGEIES KATHIGHTH

    private final UserRepo studentRepo;
    private final SubjectRepo subjectRepo;
    private final QuestionsRepo questionRepo;

    private final UserService userService;
    private final QuestionService questionService;


    public TeacherRest(UserRepo userRepo, UserRepo studentRepo, SubjectRepo subjectRepo, QuestionsRepo questionRepo, RoleRepo roleRepo, UserService userService, QuestionService questionService) {

        this.studentRepo = studentRepo;
        this.subjectRepo = subjectRepo;
        this.questionRepo = questionRepo;

        this.userService = userService;
        this.questionService = questionService;
    }


    // createQuestion --> /question (post)
    @PostMapping(value="question" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void collaborativePost(@RequestBody QuestionPost questionPost) {

       questionService.saveQuestion(questionPost.getQuestion_image(),questionPost.getQuestion_text(),questionPost.getQuestion_option1(),questionPost.getQuestion_option2(),questionPost.getQuestion_option3(),questionPost.getQuestion_option4(),questionPost.getTeacher(),questionPost.getSubject_question());

    }

    // /updateQuestion --> form for update the Question (put)
    @PutMapping("question/{q}")
    Optional<Question> replaceQuestion(@PathVariable QuestionPost q) {

//        Long id = questionService.getQuestion(q.getQuestion_text()).getId();

        return questionService.updateQuestion(new Question(null,
                q.getQuestion_image(),
                q.getQuestion_text(),
                q.getQuestion_option1(),
                q.getQuestion_option2(),
                q.getQuestion_option3(),
                q.getQuestion_option4(),
                "", null));




//        return questionRepo.findById(id)
//                .map(updateQuestion -> {
//                    //the id will be random from the system
//                    updateQuestion.setImage(newQuestion.getImage());
//                    updateQuestion.setOption1(newQuestion.getOption1());
//                    updateQuestion.setOption2(newQuestion.getOption2());
//                    updateQuestion.setOption3(newQuestion.getOption3());
//                    updateQuestion.setOption4(newQuestion.getOption4());
//                    updateQuestion.setText(newQuestion.getText());
//                    System.out.println(updateQuestion);
//                    return questionRepo.save(updateQuestion);
//                });
    }

    // /deleteQuestion --> pop up for confirmation to delete the Question (delete)
    @DeleteMapping("question/{id}")
    void deleteQuestion(@PathVariable Long id) {
        questionRepo.deleteById(id);
        System.out.println("here");
    }

    // /questionList --> get teacher's question (get)
    @GetMapping("questionList/{teacherEmail}")
    List<Question> getList(@PathVariable String teacherEmail) {

        List<Question> questions = questionService.getTeacherQuestions(teacherEmail);
        for (Question q: questions){
            q.setImage("");
        }
        return questions;
        //.orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    // createUser --> /user (post)
    @PostMapping(value="user" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void userPost(@RequestBody UserPost userPost) {

        User user = new User(null, userPost.getUser_email(), userPost.getUser_phone_number(),
                userPost.getUser_password(),userPost.getUser_fullname(), new ArrayList<>(), userPost.getTeacher(), null);
        //add user
        userService.saveUser(user);
        //add role
        String email_user = userPost.getUser_email();
        String role = userPost.getUser_role();
//        userService.addRoleToUser(email_user,role);
        userService.addRoleToUser(email_user, "student");


    }



    // /deleteStudent --> pop up for confirmation to delete the Student (delete)
    //kathe mathiths mporei na exei mono ena kathighth
    @DeleteMapping("/student/{id}")
    void deleteStudent(@PathVariable int id) {

        userService.deleteUser((long) id);

    }

    //update student
    @PutMapping("student/{teacherEmail}")
    Optional<User> replaceStudent(@RequestBody UserPost newStudent, @PathVariable String teacherEmail) {

        // bale to id tou student mesa sthn klash newStudent kai apla dwse to email tou ka8hghth 3exwrista
        // pera apo to id tou student oti allo baleis 8a ginei allagh (akomh kai o kwdikos)
        // oti afhseis keno den ginetai (an den ginetai uparxei problhma ☠️☠️)

        System.out.println(newStudent);

        User updateUser = new User(null, newStudent.getUser_email(), newStudent.getUser_phone_number(), newStudent.getUser_password(), newStudent.getUser_fullname(),null,newStudent.getTeacher(),null);
        try {
            userService.updateUser(teacherEmail,updateUser);

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    // /getStudentsList --> (get)
    @GetMapping("studentsList/{emailTeacher}")
    List<User> all(@PathVariable String emailTeacher) {

//        int i=0;
        User teacher = userService.getUser(emailTeacher);
//        List<User> usersList = userService.getStudents(teacher.getEmail());
//        for (i=0; i<usersList.size();i++){
//            System.out.println(userService.getStudents(teacher.getEmail()).get(i).getFullName());
//        }
        return userService.getStudents(teacher.getEmail());

    }


    // /getDetails --> get details for a student (get)
    @GetMapping("studentInfo/{studentEmail}")
    List<Grade> infoStudent(@PathVariable String studentEmail) {

        List<Grade> grades = questionService.getStudentAllGrades(studentEmail);
        return grades;

    }
}
