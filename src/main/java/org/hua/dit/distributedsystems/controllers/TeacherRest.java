package org.hua.dit.distributedsystems.controllers;

import org.hua.dit.distributedsystems.models.Class;
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
import java.util.Map;
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

    public void classPost(@RequestBody ClassPost classPost) {

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

    // /updateClass --> form for update the class (patch)
    @PatchMapping("class/{id}")
    public void patchClass(@PathVariable long id, @RequestBody Map<String, Object> changes) {

        //Fetch the data from the database
        Class aClass = classRepo.findById(id).get();

        //Map the persistent data to the REST dto
        //This is done to enforce REST validation groups
        ClassPost classModel = new ClassPost();

        //apply the changes to the REST model.
        changes.forEach(
                (change, value) -> {
                    switch (change) {
                        case "id":
                            classModel.setClass_id((Long) value);
                            System.out.println(classModel.getClass_id());
                            break;
                        case "description":
                            classModel.setClass_name((String) value);
                            System.out.println(classModel.getClass_name());
                            break;
                    }
                }
        );
    }

//    @PutMapping("/employees/{id}")
//    Employee replaceEmployee(@RequestBody Employee newEmployee, @PathVariable Long id) {
//
//        return repository.findById(id)
//                .map(employee -> {
//                    employee.setName(newEmployee.getName());
//                    employee.setRole(newEmployee.getRole());
//                    return repository.save(employee);
//                })
//                .orElseGet(() -> {
//                    newEmployee.setId(id);
//                    return repository.save(newEmployee);
//                });
//    }


    // /deleteClass --> pop up for confirmation to delete the class (delete)
    @DeleteMapping("class/{id}")
    void deleteClass(@PathVariable Long id) {
        classRepo.deleteById(id);
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
    @DeleteMapping("subject/{id}")
    void deleteSubject(@PathVariable Long id) {
        subjectRepo.deleteById(id);
    }

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
