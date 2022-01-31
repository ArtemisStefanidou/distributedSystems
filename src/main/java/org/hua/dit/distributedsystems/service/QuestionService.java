package org.hua.dit.distributedsystems.service;

import org.hua.dit.distributedsystems.models.Grade;
import org.hua.dit.distributedsystems.models.Question;
import org.hua.dit.distributedsystems.models.Subject;
import org.hua.dit.distributedsystems.models.User;

import java.util.List;
import java.util.Map;

public interface QuestionService {

    Subject saveSubject(Subject subject);

    void saveQuizResults(String student, Map<Long, Integer> grades);

    List<Grade> getStudentAllGrades(String studentName);

}
