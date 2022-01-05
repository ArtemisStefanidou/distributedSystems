package org.hua.dit.distributedsystems.repositories;

import org.hua.dit.distributedsystems.models.QuizLvl1;
import org.hua.dit.distributedsystems.models.QuizLvl2;
import org.hua.dit.distributedsystems.models.ids.Quiz1Id;
import org.hua.dit.distributedsystems.models.ids.Quiz2Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizLv2Repo extends JpaRepository<QuizLvl2, Quiz2Id> {
}
