package org.hua.dit.distributedsystems.repositories;

import org.hua.dit.distributedsystems.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionsRepo extends JpaRepository<Question, Long> {
    //no code needed to be written
    /*List<Question> findByTeacher(int question_teacher);*/

    List<Question> findByTeacher(Long teacher);

}
