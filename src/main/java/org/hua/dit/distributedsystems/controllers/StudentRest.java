package org.hua.dit.distributedsystems.controllers;

import org.hua.dit.distributedsystems.models.Grade;
import org.hua.dit.distributedsystems.models.QuizLvl1;
import org.hua.dit.distributedsystems.models.post.GradePost;
import org.hua.dit.distributedsystems.repositories.GradeRepo;
import org.hua.dit.distributedsystems.repositories.QuizLv1Repo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student/")
public class StudentRest {
    //ENERGEIES MATHHTH
    private final GradeRepo gradeRepo;
    private final QuizLv1Repo lv1Repo;

    public StudentRest(GradeRepo gradeRepo, QuizLv1Repo lv1Repo) {
        //arxikopoihseis

        this.gradeRepo = gradeRepo;
        this.lv1Repo = lv1Repo;
    }

    //  /doQuiz/ (get) emfanish quiz me bash tis plhrofories (random)
    @GetMapping("doQuiz/{name}")
    QuizLvl1 getQuiz(@PathVariable String name) {

        return lv1Repo.findByName(name);
        //.orElseThrow(() -> new EmployeeNotFoundException(id));
    }



    //  /quizanswers (post) kataxwrhsh apanthsewn sto quiz
    @PostMapping(value="quizAnswers" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void guizanswers(@RequestBody GradePost gradePost) {

        //todo edw gurnaw apla ton bathmo sto question thelei ftiaksimo
        System.out.println(gradePost.getGrade_of_question()+","+gradePost.getGrade_question_id()+","+ gradePost.getGrade_user_id());

    }

    // /myGrades (get) emfanish bathologiwn se ola ta quiz pou exei kanei
    @GetMapping("gradesList")
    List<Grade> all() {
        return gradeRepo.findAll(); //πρεπει ο βασιλης να φτιαξει ενα find με τους roles
    }
}
