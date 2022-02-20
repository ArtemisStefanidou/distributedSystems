package org.hua.dit.distributedsystems.controllers;

import org.hua.dit.distributedsystems.models.Grade;
import org.hua.dit.distributedsystems.models.Question;
import org.hua.dit.distributedsystems.models.post.*;
import org.hua.dit.distributedsystems.repositories.GradeRepo;
import org.hua.dit.distributedsystems.repositories.QuestionsRepo;
import org.hua.dit.distributedsystems.service.QuestionService;
import org.hua.dit.distributedsystems.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/student/")
public class StudentRest {
    //ENERGEIES MATHHTH
    private final UserService userService;
    private final QuestionService questionService;

    public StudentRest(GradeRepo gradeRepo, QuestionsRepo questionsRepo, UserService userService, QuestionService questionService) {
        //arxikopoihseis


        this.userService = userService;
        this.questionService = questionService;
    }

//    //  /doQuiz/ (get) emfanish quiz me bash tis plhrofories (random)
//    @GetMapping("doQuiz/{combination}")
//    List<Question> getQuiz(@PathVariable QuizPost combination) {
//
//        String emailTeacher = combination.getEmail();
//        String subject = combination.getSubject();
//
//        return questionService.getSubjectQuestions(emailTeacher,subject);
//
//    }

    //  /doQuiz/ (get) emfanish quiz me bash tis plhrofories (random)
    @GetMapping("doQuiz/{items}")
    List<QuestionGet> getQuiz(@PathVariable String items) {


        int j = 0;
        String[] strings = items.split(",");
        String emailTeacher = userService.getUser(strings[0]).getTeacher();
        List<CorrectAnswer> correctList = new ArrayList<>();
        List<QuestionGet> questionsGet = new ArrayList<>();
        List<Question> questions = questionService.getSubjectQuestions(emailTeacher,strings[1]);
        for (int i=0 ; i<questions.size();i++) {

            correctList = new ArrayList<>();
            CorrectAnswer correct = new CorrectAnswer(questions.get(i).getOption1(), "true");
            correctList.add(correct);
            CorrectAnswer false1 = new CorrectAnswer(questions.get(i).getOption2(), "false");
            correctList.add(false1);
            CorrectAnswer false2 = new CorrectAnswer(questions.get(i).getOption3(), "false");
            correctList.add(false2);
            CorrectAnswer false3 = new CorrectAnswer(questions.get(i).getOption4(), "false");
            correctList.add(false3);


            QuestionGet question = new QuestionGet(questions.get(i).getImage(), questions.get(i).getText(), correctList);

            questionsGet.add(question);

        }

//        int k = 0;
//        List<CorrectAnswer> correctAnswerList = null;
//        while(correctList.size()!=0){
//            for(int i = 0;i<4;i++){
//                correctAnswerList = new ArrayList<>();
//                correctAnswerList.add(correctList.get(i));
//                correctList.remove(i);
//
//            }
//            questionsGet.get(k).setAnswers(correctAnswerList);
//            k++;
//        }
        return questionsGet ;

    }




    //  /quizanswers (post) kataxwrhsh apanthsewn sto quiz
    @PostMapping(value="quizAnswers" , consumes = {
            MediaType.APPLICATION_JSON_VALUE
    })

    public void quizAnswers(@RequestBody GradePost gradePost) {

        HashMap<Long,String> map=new HashMap<Long,String>();//Creating HashMap
        map.put(8L,gradePost.getGrade_of_question());  //Put elements in Map
        questionService.saveQuizResults(gradePost.getUser(),map);

    }

//     /myGrades (get) emfanish bathologiwn se ola ta quiz pou exei kanei
   @GetMapping("answerList/{email}")
    List<Grade> all(@PathVariable String email) {
       return questionService.getStudentAllGrades(email);
   }
}