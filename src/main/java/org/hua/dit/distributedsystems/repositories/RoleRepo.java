package org.hua.dit.distributedsystems.repositories;

import org.hua.dit.distributedsystems.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {

    Role findByName(String roleName);
}
