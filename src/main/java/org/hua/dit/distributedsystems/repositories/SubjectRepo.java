package org.hua.dit.distributedsystems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.security.auth.Subject;

@Repository
public interface SubjectRepo extends JpaRepository<Subject, Long> {
}
