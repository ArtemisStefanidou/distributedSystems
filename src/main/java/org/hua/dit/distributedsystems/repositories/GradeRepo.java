package org.hua.dit.distributedsystems.repositories;

import org.hua.dit.distributedsystems.models.Grade;
import org.hua.dit.distributedsystems.models.ids.GradeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GradeRepo extends JpaRepository<Grade, GradeId> {
   // List<Grade> findById(Long grade_user_id);
}
