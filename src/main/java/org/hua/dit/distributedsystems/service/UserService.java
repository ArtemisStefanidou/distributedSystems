package org.hua.dit.distributedsystems.service;

import org.hua.dit.distributedsystems.models.Role;
import org.hua.dit.distributedsystems.models.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String email, String roleName);
    User getUser(String username);
    List<User> getUsers();
}