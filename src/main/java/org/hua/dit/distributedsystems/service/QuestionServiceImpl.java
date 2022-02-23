package org.hua.dit.distributedsystems.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hua.dit.distributedsystems.models.Grade;
import org.hua.dit.distributedsystems.models.Question;
import org.hua.dit.distributedsystems.models.Subject;
import org.hua.dit.distributedsystems.models.User;
import org.hua.dit.distributedsystems.repositories.GradeRepo;
import org.hua.dit.distributedsystems.repositories.QuestionsRepo;
import org.hua.dit.distributedsystems.repositories.SubjectRepo;
import org.hua.dit.distributedsystems.repositories.UserRepo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class QuestionServiceImpl implements QuestionService{

    private final SubjectRepo subjectRepo;
    private final UserRepo userRepo;
    private final QuestionsRepo questionsRepo;
    private final GradeRepo gradeRepo;

    @Override
    public Subject saveSubject(Subject subject) {
        return subjectRepo.save(subject);
    }

    @Override
    public void saveQuizResults(String student, String grade, String question) {
        User st = userRepo.findByEmail(student);
        Question q = questionsRepo.findByText(question);
        Grade g = new Grade(null, grade, st, q);
        gradeRepo.save(g);

    }

    @Override
    public List<Grade> getStudentAllGrades(String studentEmail) {
        User student = userRepo.findByEmail(studentEmail);
        return gradeRepo.findByStudent(student);
    }

    @Override
    public void saveQuestion(String image, String text, String opt1, String opt2, String opt3, String opt4
            , String teacherEmail, String subject) {

        User teacher = userRepo.findByEmail(teacherEmail);
        Subject sub = subjectRepo.findByName(subject);

        Question question = new Question(null, image, text, opt1, opt2, opt3, opt4, teacher.getEmail(), null);

        questionsRepo.save(question);
        sub.getQuestions().add(question);
    }

    @Override
    public List<Question> getSubjectQuestions(String teacherEmail, String subject) {

        User teacher = userRepo.findByEmail(teacherEmail);

        List<Subject> subjectList = (List<Subject>) teacher.getSubjects();

        Subject subject1 = new Subject();

        for(Subject s : subjectList) {
            if(subject.equals(s.getName()) ) {
                subject1 = s;
            }
        }

        subject1.getQuestions();

        return (List<Question>) subject1.getQuestions();
    }

    @Override
    public List<Question> getTeacherQuestions(String teacherEmail) {

        User teacher = userRepo.findByEmail(teacherEmail);

        List<Subject> subjectList = (List<Subject>) teacher.getSubjects();

        List<Question> questionList = new ArrayList<>();

        for(Subject s : subjectList) {
            for (Question q : s.getQuestions()) {
                questionList.add(q);
            }
        }

        return (List<Question>) questionList;
    }

    @Override
    public Question getQuestion(String text) {
        return questionsRepo.findByText(text);
    }

    public Optional<Question> updateQuestion(Question newQuestion) throws Exception {

        Question questionInDb = getQuestion(newQuestion.getText());

        if(!Objects.equals(questionInDb.getTeacher(), newQuestion.getTeacher())) {
            throw new Exception("Wrong question");
        }

        if(!newQuestion.getImage().equals("")) {
            questionInDb.setImage(newQuestion.getImage());
        }

        if (!newQuestion.getOption1().equals("")) {
            questionInDb.setOption1(newQuestion.getOption1());
        }

        if (!newQuestion.getOption2().equals("")) {
            questionInDb.setOption2(newQuestion.getOption2());
        }

        if (!newQuestion.getOption3().equals("")) {
            questionInDb.setOption3(newQuestion.getOption3());
        }

        if (!newQuestion.getOption4().equals("")) {
            questionInDb.setOption4(newQuestion.getOption4());
        }


        return null;
    }

    @Override
    public void deleteQuestion(Long id, String subjectName) {

        Subject subject = subjectRepo.findByName(subjectName);

        subject.getQuestions().removeIf(q -> q.getId() == id);

        questionsRepo.deleteById(id);
    }

}
