package org.hua.dit.distributedsystems.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.hua.dit.distributedsystems.models.Role;
import org.hua.dit.distributedsystems.models.Subject;
import org.hua.dit.distributedsystems.models.User;
import org.hua.dit.distributedsystems.repositories.RoleRepo;
import org.hua.dit.distributedsystems.repositories.UserRepo;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {

    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;


    @Override
    public void deleteUser(Long idStudent){
        userRepo.deleteById(idStudent);
    }

    @Override
    public void updateUser(String teacherEmail, User newStudent) throws Exception {

        User studentInDb = userRepo.findByEmail(newStudent.getEmail());

        if(!Objects.equals(studentInDb.getTeacher(), teacherEmail)) {
            throw new Exception("Wrong student");
        }

        if(newStudent.getPhoneNumber() != 0) {
            studentInDb.setPhoneNumber(newStudent.getPhoneNumber());
        }

        if(!Objects.equals(newStudent.getFullName(), "")) {
            studentInDb.setFullName(newStudent.getFullName());
        }

        if(!Objects.equals(newStudent.getTeacher(), "")) {
            studentInDb.setTeacher(newStudent.getTeacher());
        }

        if (newStudent.getPassword().equals("")){
            System.out.println("----------------------");
            return;
        }

        studentInDb.setPassword(passwordEncoder.encode(newStudent.getPassword()));

    }

    @Override
    public User saveUser(User user) {
        log.info("Encoding password...");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new user {} to the database", user.getFullName());
        return userRepo.save(user);
    }

    @Override
    public User saveUser(User user, String emailTeacher) {
        log.info("Encoding password...");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Saving new user {} to the database", user.getFullName());

        userRepo.save(user);
        Role role = roleRepo.findByName("student");

        user.getRoles().add(role);
        return user;
       // return userRepo.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Saving new role {} to the database", role.getName());
        return roleRepo.save(role);
    }

    @Override
    public void addRoleToUser(String email, String roleName) {
        User user = userRepo.findByEmail(email);
        log.info("Adding role {} to user {}", roleName, user.getFullName());
        Role role = roleRepo.findByName(roleName);

        user.getRoles().add(role);
    }

    @Override
    public User getUser(String email) {
        log.info("Fetching user {}", email);
        return userRepo.findByEmail(email) ;
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching all users");
        return userRepo.findAll();
    }

    @Override
    public List<User> getStudents(String teacherName) {
        return userRepo.findByTeacher(teacherName);
    }

    @Override
    public void addTeacherToStudent(String teacherName, String studentName) {
        User teacher = userRepo.findByEmail(teacherName);
        User student = userRepo.findByEmail(studentName);

        student.setTeacher(teacherName);
    }

    @Override
    public void addSubjectToTeacher(Subject subject, String email) {
        User user = userRepo.findByEmail(email);

        if(user.getRoles().iterator().next().equals(email)){
            System.out.println(email+ "  Yesssss");
            return;
        }

        user.getSubjects().add(subject);

    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email);

        if(user == null) {
            log.error("User not found");
            throw new UsernameNotFoundException("User not found");
        } else {
            log.info("User found :{}", email);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }
}