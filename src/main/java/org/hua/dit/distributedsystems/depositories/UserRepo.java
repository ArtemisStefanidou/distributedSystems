package org.hua.dit.distributedsystems.depositories;

import org.hua.dit.distributedsystems.models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Integer> {



}
