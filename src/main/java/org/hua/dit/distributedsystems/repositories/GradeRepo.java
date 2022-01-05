package org.hua.dit.distributedsystems.repositories;

import org.hua.dit.distributedsystems.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GradeRepo extends JpaRepository<Grade, Grade.GradeId> {
}
