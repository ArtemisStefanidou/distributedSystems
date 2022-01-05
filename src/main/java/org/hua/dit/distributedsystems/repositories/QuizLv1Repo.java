package org.hua.dit.distributedsystems.repositories;

import org.hua.dit.distributedsystems.models.QuizLvl1;
import org.hua.dit.distributedsystems.models.ids.Quiz1Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizLv1Repo extends JpaRepository<QuizLvl1, Quiz1Id> {
}
