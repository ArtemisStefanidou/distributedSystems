package org.hua.dit.distributedsystems.service;

import org.hua.dit.distributedsystems.models.Grade;
import org.hua.dit.distributedsystems.models.Question;
import org.hua.dit.distributedsystems.models.Subject;
import org.hua.dit.distributedsystems.models.User;

import java.util.List;
import java.util.Map;

public interface QuestionService {

    /**
     *
     * @param
     * @return
     */
    Subject saveSubject(Subject subject);

    /**
     *
     * @param
     * @return
     */
    void saveQuizResults(String student, Map<Long, Integer> grades);

    /**
     *
     * @param
     * @return
     */
    List<Grade> getStudentAllGrades(String studentName);

    /**
     *
     * @param
     * @return
     */
    void saveQuestion(String image, String text, String opt1, String opt2, String opt3, String opt4
            , String teacherEmail, String subject);

    /**
     * Επιστρέφει όλες τις ερωτήσεις που έχει αποθηκευμένες ο καθηγητής
     * για αυτό το κεφάλαιο
     *
     * @param  teacherEmail  Το email του καθηγητή
     * @param  subject το όνομα του κεφαλαίου
     * @return      Μια λίστα με ερωτήσεις
     */
    List<Question> getSubjectQuestions(String teacherEmail, String subject);

    Question getQuestion(String text);


}
