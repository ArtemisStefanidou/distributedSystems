package org.hua.dit.distributedsystems.controllers;

import org.hua.dit.distributedsystems.models.Grade;
import org.hua.dit.distributedsystems.models.Question;
import org.hua.dit.distributedsystems.models.post.GradePost;
import org.hua.dit.distributedsystems.repositories.GradeRepo;
import org.hua.dit.distributedsystems.repositories.QuestionsRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/student/")
public class StudentRest {
    //ENERGEIES MATHHTH
    private final GradeRepo gradeRepo;
    private final QuestionsRepo questionsRepo;

    public StudentRest(GradeRepo gradeRepo, QuestionsRepo questionsRepo) {
        //arxikopoihseis

        this.gradeRepo = gradeRepo;
        this.questionsRepo = questionsRepo;

    }

/*    //  /doQuiz/ (get) emfanish quiz me bash tis plhrofories (random)
    @GetMapping("doQuiz/{combination}")
    List<Question> getQuiz(@PathVariable int teacher) {
        return questionsRepo.findByTeacher(teacher);
        //.orElseThrow(() -> new EmployeeNotFoundException(id));
    }*/


    //  /quizanswers (post) kataxwrhsh apanthsewn sto quiz
    @PostMapping(value="quizAnswers" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void guizanswers(@RequestBody GradePost gradePost) {

        //todo edw gurnaw apla ton bathmo sto question thelei ftiaksimo
        System.out.println(gradePost.getGrade_of_question()+","+gradePost.getGrade_question_id()+","+ gradePost.getUser());

    }

//     /myGrades (get) emfanish bathologiwn se ola ta quiz pou exei kanei
/*    @GetMapping("answerList/{user}")
    List<Grade> all(@PathVariable Long user) {
        return gradeRepo.findByUser(user);}*/
}