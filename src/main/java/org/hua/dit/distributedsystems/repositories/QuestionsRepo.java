package org.hua.dit.distributedsystems.repositories;

import org.hua.dit.distributedsystems.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionsRepo extends JpaRepository<Question, Long> {
}
