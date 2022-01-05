package org.hua.dit.distributedsystems.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRpo extends JpaRepository<Class, Long> {
}
