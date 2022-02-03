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
import java.util.List;
import java.util.Map;

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
    public void saveQuizResults(String student, Map<Long, Integer> grades) {
        User st = userRepo.findByEmail(student);

        for (Map.Entry<Long, Integer> entry : grades.entrySet()) {
            System.out.println(entry.getKey() + "/" + entry.getValue());

            Question question = questionsRepo.getById(entry.getKey());

            Grade grade = new Grade(null, entry.getValue(), st, question);

            gradeRepo.save(grade);
        }


    }

    @Override
    public List<Grade> getStudentAllGrades(String studentEmail) {
        User student = userRepo.findByEmail(studentEmail);
        return gradeRepo.findByStudent(student);
    }

}
