package org.hua.dit.distributedsystems.repositories;

import org.hua.dit.distributedsystems.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {
}
