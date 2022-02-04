package org.hua.dit.distributedsystems.service;

import org.hua.dit.distributedsystems.models.Role;
import org.hua.dit.distributedsystems.models.Subject;
import org.hua.dit.distributedsystems.models.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    /** Διαφράφει έναν χρήστη
     *
     * @param userId το ID του χρηστη που θέλουμε να διαγραψουμε
     */
    void deleteUser(Long userId);


    /** Αποθηκεύουμε έναν νέο χρήστη στην βάση μας
     *
     * @param user τον χρήστη που θέλουμε να αποθηκεύσουμε
     */
    User saveUser(User user);


    /** Αποθηκεύει έναν νέο ρόλο στην βάση
     *
     * @param role o ρόλος που θέλουμε να αποθηκεύτεί
     * @return Role
     */
    Role saveRole(Role role);


    /** Δίνει έναν ήδη υπάρχον ρόλο σε έναν χρήστη
     *
     * @param email το μέιλ του χρήστη
     * @param roleName ένα string με το όνομα του ρόλου
     */
    void addRoleToUser(String email, String roleName);


    /** Βρίσκει έναν χρήστη στην βάση
     *
     * @param email το μέιλ του χρήστη που ψάχνουμε
     * @return User επιστρέφει τον χρήστη
     */
    User getUser(String email);


    /** επιστρέφει όλους τους χρήστες από την βάση
     *
     * @return List<User> επιστέφει μια λίστα με χρήστες
     */
    List<User> getUsers();


    /** Επιστρέφει όλους τους μαθητές ενός συγκεκριμένου καθηγητή
     *
     * @param teacherName το μέιλ του καθηγητή
     * @return List<User> επιστρέφει μια λίστα με χρήστες (μαθητές)
     */
    List<User> getStudents(String teacherName);


    /** Κάνει εγγραφή έναν μαθητή στα μαθήματα ενός καθηγητή
     *
     * @param teacherName το μέιλ του καθηγητή που θέλει να αναλάβει τον νέο μαθητή
     * @param studentName το μέιλ του μαθητή που θα κάνει εγγραφή στα μαθήματα του καθηγητή
     */
    void addTeacherToStudent(String teacherName, String studentName);


    /** Βάζει ένα νέο κεφάλαιο σε έναν καθηγητή
     *
     * @param subject το νέο κεφάλαιο
     * @param email το μέιλ του καθηγητή
     */
    void addSubjectToTeacher(Subject subject, String email);

    Optional<User> updateUser(Long id, User newStudent);
}
