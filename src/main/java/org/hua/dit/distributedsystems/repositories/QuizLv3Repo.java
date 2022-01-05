package org.hua.dit.distributedsystems.repositories;

import org.hua.dit.distributedsystems.models.QuizLvl1;
import org.hua.dit.distributedsystems.models.QuizLvl3;
import org.hua.dit.distributedsystems.models.ids.Quiz1Id;
import org.hua.dit.distributedsystems.models.ids.Quiz3Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizLv3Repo extends JpaRepository<QuizLvl3, Quiz3Id> {
}
