package org.hua.dit.distributedsystems.repositories;

import org.hua.dit.distributedsystems.models.Class;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRepo extends JpaRepository<Class, Long> {
}