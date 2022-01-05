package org.hua.dit.distributedsystems.repositories;

import org.hua.dit.distributedsystems.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

}
