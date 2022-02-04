package org.hua.dit.distributedsystems.service;

import org.hua.dit.distributedsystems.models.Grade;
import org.hua.dit.distributedsystems.models.Question;
import org.hua.dit.distributedsystems.models.Subject;
import org.hua.dit.distributedsystems.models.User;

import java.util.List;
import java.util.Map;

public interface QuestionService {

    /** Αποθηκεύει ένα νέο κεφάλαιο
     *
     * @param subject το αντικείμενο του νέου κεφαλαίου
     * @return Subject
     */
    Subject saveSubject(Subject subject);


    /** Αποθηκεύει τα αποτελέσματα του κουίζ που έκανε ο μαθητής
     *
     * @param student το μέιλ του μαθητή που έκανε το κουίζ
     * @param grades ένα Map<Long, Integer> όπου Long = ID της ερώτησης και Integer=βαθμός από το 1-10 του μαθητή
     */
    void saveQuizResults(String student, Map<Long, Integer> grades);


    /** Όλα τα αποτελέσματα ενός μαθητή
     *
     * @param studentName το μέιλ του μαθητή
     * @return List<Grade> μία λίστα με βαθμούς (υπάρχουν και τα ID της κάθε ερώτησης μέσα)
     */
    List<Grade> getStudentAllGrades(String studentName);


    /** Αποθηκεύει μια νέα ερώτηση στη βάση
     *
     */
    void saveQuestion(String image, String text, String opt1, String opt2,String opt3,String opt4, String script
            , String teacherEmail, int difficultyLvl, String subject);


    /**
     * Επιστρέφει όλες τις ερωτήσεις που έχει αποθηκευμένες ο καθηγητής
     * για αυτό το κεφάλαιο
     *
     * @param  teacherEmail  Το email του καθηγητή
     * @param  subject το όνομα του κεφαλαίου
     * @return      Μια λίστα με ερωτήσεις
     */
    List<Question> getSubjectQuestions(String teacherEmail, String subject);


    /** todo
     *
     * @param
     * @return
     */
    Question updateQuestion(Long questionId, String image, String text, String opt1, String opt2, String opt3
            , String opt4, String script, int difficulty);
}
