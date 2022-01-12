package org.hua.dit.distributedsystems.controllers;

import org.hua.dit.distributedsystems.models.Class;
import org.hua.dit.distributedsystems.models.Question;
import org.hua.dit.distributedsystems.models.Subject;
import org.hua.dit.distributedsystems.models.User;
import org.hua.dit.distributedsystems.models.post.ClassPost;
import org.hua.dit.distributedsystems.models.post.QuestionPost;
import org.hua.dit.distributedsystems.models.post.SubjectPost;
import org.hua.dit.distributedsystems.models.post.UserPost;
import org.hua.dit.distributedsystems.repositories.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/teacher/")
public class TeacherRest {
    //ENERGEIES KATHIGHTH

    private final ClassRepo classRepo;
    private final UserRepo studentRepo;
    private final SubjectRepo subjectRepo;
    private final QuestionsRepo questionRepo;


    public TeacherRest(ClassRepo classRepo, UserRepo userRepo, UserRepo studentRepo, SubjectRepo subjectRepo, QuestionsRepo questionRepo, RoleRepo roleRepo) {
        this.classRepo = classRepo;
        this.studentRepo = studentRepo;
        this.subjectRepo = subjectRepo;
        this.questionRepo = questionRepo;
    }

    // createClass --> /class (post)
    @PostMapping(value="class" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

     void classPost(@RequestBody ClassPost classPost) {

        //todo
        System.out.println(classPost.getClass_id()+","+classPost.getClass_name());

    }

    @PostMapping(path = "class",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClassPost> create(@RequestBody ClassPost classPost) {
        ClassPost postClass = new ClassPost();
        //ClassPost postClass = classRepo.save(classRepo); // prepei o bill na ftiaxei to service tou class
        if (postClass == null) {
            System.out.println("todo");
            //throw new ServerException() ;
            return null;
        } else {
            return new ResponseEntity<>(postClass, HttpStatus.CREATED);
        }
    }


    //update class
    @PutMapping("class/{id}")
    Optional<Class> replaceEmployee(@RequestBody Class newClass, @PathVariable Long id) {

        return classRepo.findById(id)
                .map(updateClass -> {
                    //the id will be random from the system
                    updateClass.setClass_name(newClass.getClass_name());
                    System.out.println(updateClass);
                    return classRepo.save(updateClass);
                });

   }


    // /deleteClass --> pop up for confirmation to delete the class (delete)
    @DeleteMapping("class/{id}")
    void deleteClass(@PathVariable Long id) {
        classRepo.deleteById(id);
    }

    // /getClass --> get the classes for drop down list in html (get)
    @GetMapping("classList/")
     List<Class> allClass() {
        return classRepo.findAll();
    }


    // createSubject --> /subject (post)
    @PostMapping(value="subject" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })
    public void classPost(@RequestBody SubjectPost subjectPost) {

        System.out.println(subjectPost.getSubject_class()+","+subjectPost.getSubject_id()+","+subjectPost.getSubject_name());
        return;

    }

    // /updateSubject --> form for update the Subject (put)
    @PutMapping("subject/{id}")
    Optional<Subject> replaceSubject(@RequestBody Subject newSubject, @PathVariable Long id) {

        return subjectRepo.findById(id)
                .map(updateSubject -> {
                    //the id will be random from the system
                    updateSubject.setSubject_class(newSubject.getSubject_class());
                    updateSubject.setSubject_name(newSubject.getSubject_name());
                    System.out.println(updateSubject);
                    return subjectRepo.save(updateSubject);
                });

    }


    // /deleteSubject --> pop up for confirmation to delete the Subject (delete)
    @DeleteMapping("subject/{id}")
    void deleteSubject(@PathVariable Long id) {
        subjectRepo.deleteById(id);
    }

    // /getClass --> get the classes for drop down list in html (get)
    @GetMapping("subjectList/")
    List<Subject> allSubject() {
        return subjectRepo.findAll();
    }

    // createQuestion --> /question (post)
    @PostMapping(value="question" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void collaborativePost(@RequestBody QuestionPost questionPost) {

        System.out.println(questionPost.getQuestion_image()+","+questionPost.getQuestion_text()+","+questionPost.getQuestion_option1()+","+questionPost.getQuestion_option2()+","+questionPost.getQuestion_option3()+","+questionPost.getQuestion_script());
        return;
    }

    // /updateQuestion --> form for update the Question (put)
    @PutMapping("question/{id}")
    Optional<Question> replaceQuestion(@RequestBody Question newQuestion, @PathVariable Long id) {

        return questionRepo.findById(id)
                .map(updateQuestion -> {
                    //the id will be random from the system
                    updateQuestion.setImage(newQuestion.getImage());
                    updateQuestion.setOption1(newQuestion.getOption1());
                    updateQuestion.setOption2(newQuestion.getOption2());
                    updateQuestion.setOption3(newQuestion.getOption3());
                    updateQuestion.setOption4(newQuestion.getOption4());
                    updateQuestion.setText(newQuestion.getText());
                    updateQuestion.setScript(newQuestion.getScript());
                    System.out.println(updateQuestion);
                    return questionRepo.save(updateQuestion);
                });

    }

    // /deleteQuestion --> pop up for confirmation to delete the Question (delete)
    @DeleteMapping("question/{id}")
    void deleteQuestion(@PathVariable Long id) {
        questionRepo.deleteById(id);
        System.out.println("here");
    }

    // createUser --> /user (post)
    @PostMapping(value="user" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void userPost(@RequestBody UserPost userPost) {

        //todo
        System.out.println(userPost.getUser_email()+","+userPost.getUser_role()+","+userPost.getUser_fullname()+","+userPost.getUser_teacher()+","+userPost.getUser_id()+","+userPost.getUser_password()+","+userPost.getUser_phone_number());
    }

    // /deleteStudent --> pop up for confirmation to delete the Student (delete)
    //kathe mathiths mporei na exei mono ena kathighth
    @DeleteMapping("/student/{id}")
    void deleteStudent(@PathVariable Long id) {
        studentRepo.deleteById(id);
        System.out.println("here");
    }

    //update student
    @PutMapping("student/{id}")
    Optional<User> replaceStudent(@RequestBody User newStudent, @PathVariable Long id) {

        return studentRepo.findById(id)
                .map(updateStudent -> {
                    //the id will be random from the system
                    updateStudent.setEmail(newStudent.getEmail());
                    updateStudent.setFullName(newStudent.getFullName());
                    updateStudent.setPassword(newStudent.getPassword());//na pernaei apo to security
                    updateStudent.setPhoneNumber(newStudent.getPhoneNumber());
                    //o rolos paramenei o idios den mporei na ton allajei o teacher opvs kai to teacher name
                    //an thelei na mhn ton exei mathhth pia kai na ton exei kapoios allow kathhghths tote apla ton diagrafei apo ayton
                    System.out.println(updateStudent);
                    return studentRepo.save(updateStudent);
                });

    }

    // /getStudentsList --> (get)
    @GetMapping("studentsList/")
    List<User> all() {
        return studentRepo.findAll(); //πρεπει ο βασιλης να φτιαξει ενα find με τους roles
    }


    // /getDetails --> get details for a student (get)
    @GetMapping("student/{id}")
    Optional<User> one(@PathVariable Long id) {

        return studentRepo.findById(id);
                //.orElseThrow(() -> new EmployeeNotFoundException(id));
    }
}
