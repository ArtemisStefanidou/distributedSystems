package org.hua.dit.distributedsystems.service;

import org.hua.dit.distributedsystems.models.Role;
import org.hua.dit.distributedsystems.models.Subject;
import org.hua.dit.distributedsystems.models.User;

import java.util.List;

public interface UserService {

    void deleteUser(Long userId);
    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String email, String roleName);
    User getUser(String email);
    List<User> getUsers();

    List<User> getStudents(String teacherName);

    void addTeacherToStudent(String teacherName, String studentName);

    int addSubjectToTeacher(Subject subject, String email);
}
