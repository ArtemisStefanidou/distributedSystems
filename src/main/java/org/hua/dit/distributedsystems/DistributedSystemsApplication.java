package org.hua.dit.distributedsystems;
import org.hua.dit.distributedsystems.models.*;
import org.hua.dit.distributedsystems.repositories.*;
import org.hua.dit.distributedsystems.service.QuestionService;
import org.hua.dit.distributedsystems.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DistributedSystemsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DistributedSystemsApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner commandLineRunner(UserService userService, QuestionService questionService) {
        return args -> {

            Role student = new Role(null, "student");
            userService.saveRole(student);

            Role teacher = new Role(null, "teacher");
            userService.saveRole(teacher);



            User bill = new User(null, "bill@gmail.com","1234" , "1234", "Bill"
                    , new ArrayList<>(), null, null);
            userService.saveUser(bill);

            User artemis = new User(null, "artemis@gmail.com", "1234", "5678"
                    , "Artemis", new ArrayList<>(), null, null);
            userService.saveUser(artemis);

            User meletis = new User(null, "meletis@gmail.com", "1234", "9012"
                    , "Meletis", new ArrayList<>(), null, null);
            userService.saveUser(meletis);



            userService.addRoleToUser("bill@gmail.com", "student");
            userService.addRoleToUser("artemis@gmail.com", "teacher");
            userService.addRoleToUser("meletis@gmail.com", "teacher");

            userService.addTeacherToStudent("meletis@gmail.com", "bill@gmail.com");

            //subjects create
            Subject prwtobathmies = new Subject(null, "Πρωτοβάθμιες Εξισώσεις",  null);
            Subject embada = new Subject(null, "Εμβαδά Σχημάτων",  null);

            //subjects add
            questionService.saveSubject(prwtobathmies);
            questionService.saveSubject(embada);

            //add ston kathigiti meleti
            userService.addSubjectToTeacher(prwtobathmies, meletis.getEmail());
            userService.addSubjectToTeacher(embada, meletis.getEmail());

            //make questions
                //no1
//            questionService.saveQuestion(
//                    null,
//                    "Η εξίσωση 0χ=0 είναι",
//                    "αόριστη",
//                    "αδύνατη",
//                    "έχει μοναδική λύση τον αριθμό 4",
//                    "έχει λύση μόνο τον αριθμό 2",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no2
//            questionService.saveQuestion(
//                    null,
//                    "Η εξίσωση 0χ=3 είναι",
//                    "αδύνατη",
//                    "αόριστη",
//                    "έχει μοναδική λύση τον αριθμό 3",
//                    "έχει άπειρες λύσεις",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no3
//            questionService.saveQuestion(
//                    null,
//                    "Η εξίσωση 2χ=6",
//                    "εχει μοναδική λύση την χ=3",
//                    "είναι αδύνατη",
//                    "είναι αόριστη",
//                    "έχει μοναδική λύση τον αριθμό 4",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//            //no4
//            questionService.saveQuestion(
//                    null,
//                    "Αόριστη λέμε την εξίσωση η οποία",
//                    "έχει άπειρες πραγματικές λύσεις",
//                    "δεν υπάρχει καμία τιμή που να επαληθεύσει την ισότητα",
//                    "έχει μια μοναδική λύση",
//                    "έχει δύο λύσεις μονο",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                 //no5
//            questionService.saveQuestion(
//                    null,
//                    "Αδύνατη  λέμε την εξίσωση η οποία",
//                    " δεν έχει καμία πραγματική λύση",
//                    "έχει άπειρες λύσεις",
//                    "έχει μια λύση",
//                    "έχει παραπάνω απο μια λύσεις",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no6
//            questionService.saveQuestion(
//                    null,
//                    "Το διπλάσιο ενός αριθμού εκφράζεται ως",
//                    " 2x",
//                    "χ+2",
//                    "x-2",
//                    "x/2",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no7
//            questionService.saveQuestion(
//                    null,
//                    "Το τριπλάσιο ενός αριθμού ελαττωμένο  κατα 22 εκφράζεται ως",
//                    "3χ - 22",
//                    " 2χ - 22",
//                    "χ - 22",
//                    "3χ +22",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no8
//            questionService.saveQuestion(
//                    null,
//                    " Η εξίσωση 5χ=15 έχει λύση",
//                    "χ=3",
//                    "χ=15",
//                    "χ= 2",
//                    "τίποτα απο τα άλλα",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no9
//            questionService.saveQuestion(
//                    null,
//                    " Η εξίσωση 4χ=8 εχει λύση",
//                    "χ=2",
//                    "χ=-2",
//                    "χ=4",
//                    "τίποτα απο τα άλλα",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no10
//            questionService.saveQuestion(
//                    null,
//                    "Η εξίσωση 3χ +6 =0 εχει λύση ",
//                    " χ=-3",
//                    "χ=3",
//                    "έχει άπειρες λύσεις",
//                    "τίποτα απο τα άλλα",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no11
//            questionService.saveQuestion(
//                    null,
//                    " Η εξίσωση 2χ -2(χ+1)=4",
//                    "αδυνατη",
//                    "αόριστη",
//                    "έχει μοναδική λύση τον αριθμό 2",
//                    "έχει λύση μόνο τον αριθμό 4",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no12
//            questionService.saveQuestion(
//                    null,
//                    "Η εξίσωση 4(χ-2)=4(χ-1)",
//                    "αδύνατη",
//                    "αοριστη",
//                    "έχει μοναδική λύση τον αριθμό -2",
//                    "έχει λύση μόνο τον αριθμό 3",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no13
//            questionService.saveQuestion(
//                    null,
//                    "Η εξίσωση 3χ -4(χ+2)= -8 ",
//                    "εχει μοναδική λύση την χ=0",
//                    "αδύνατη",
//                    "αόριστη",
//                    "έχει λύση μόνο τον αριθμό 4",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no14
//            questionService.saveQuestion(
//                    null,
//                    "Η εξίσωση 5χ-3χ +2χ -6χ +4(χ+5)=-1 ",
//                    "έχει μοναδική λύση την χ=2",
//                    "αδύνατη",
//                    "έχει λύση τον αριθμό 2",
//                    "έχει απειρες λύσεις",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no15
//            questionService.saveQuestion(
//                    null,
//                    "Το δωδεκαπλάσιο ενός αριθμού αυξημένο κατα 3",
//                    "12y +3",
//                    "12χ+3χ",
//                    "12y -3",
//                    "τίποτα απο τα παραπάνω",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no16
//            questionService.saveQuestion(
//                    null,
//                    "Το υποδεκαπλάσιο ενός αριθμού αυξημένο κατα 32 ισούται με 3",
//                    "υ/10 +32 =3",
//                    "θ/10 + 32",
//                    "10χ - 32 = 3",
//                    "τίποτα απο τα άλλα",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no17
//            questionService.saveQuestion(
//                    null,
//                    "Το εξαπλάσιο ενός αριθμού ελαττωμένο κατα 61 ισούται με 5",
//                    "6χ - 61 =5",
//                    "6χ + 61 =2",
//                    "6χ=61",
//                    "τίποτα απο τα άλλα",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no18
//            questionService.saveQuestion(
//                    null,
//                    "Το 3χ=2 εκφράζεται ως",
//                    "το τριπλάσιο ενός αριθμού ισούται με το 2 ",
//                    "το υποτριπλάσιο ενός αριθμού ισούται με 2",
//                    "το άθροισμα ενός αριθμού με το 2 ",
//                    "τίποτα απο τα άλλα",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no19
//            questionService.saveQuestion(
//                    null,
//                    "Το 3χ=2χ εκφράζεται ως",
//                    "το τριπλάσιο ενός αριθμού ισούται με το διπλάσιο του ίδιου αριθμού\n",
//                    "αδύνατη",
//                    "έχει μοναδική λύση τον αριθμό 2",
//                    "έχει λύση μόνο τον αριθμό 4",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no20
//            questionService.saveQuestion(
//                    null,
//                    "Αν προσθέσω και αφαιρεσω τον ιδιο αριθμό (γ) από έναν άλλον αριθμό (β) τότε προκύπτει  ",
//                    " ο αριθμός β ",
//                    "το 0",
//                    "το 1",
//                    "τίποτα απο τα άλλα",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no21
//            questionService.saveQuestion(
//                    null,
//                    "Η εξίσωση 2χ/5 - 3χ =0",
//                    "αόριστη",
//                    "αδύνατη",
//                    "έχει μοναδική λύση τον αριθμό 2",
//                    "έχει λύση μόνο τον αριθμό 4",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no22
//            questionService.saveQuestion(
//                    null,
//                    "Η εξίσωση 3(χ+1)/2 - 5(χ-1)=+1",
//                    " χ=1",
//                    "αδύνατη",
//                    "έχει μοναδική λύση τον αριθμό 6",
//                    "αόριστη",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no23
//            questionService.saveQuestion(
//                    null,
//                    "Η εξίσωση 55(χ-100) /50 =33χ +1",
//                    "τίποτα απο τα άλλα",
//                    "αδύνατη",
//                    "αόριστη",
//                    "έχει λύση μόνο τον αριθμό 5",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no24
//            questionService.saveQuestion(
//                    null,
//                    "Η εξίσωση 3(χ-1)/3 - 2(χ+1)/4 = (χ-5)/12",
//                    " χ=-3/5",
//                    "αδύνατη",
//                    "αόριστη",
//                    "τίποτα απο τα άλλα",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no25
//            questionService.saveQuestion(
//                    null,
//                    "Η εξίσωση  3(χ-1)/3 - 2(χ+1)/4 = (χ-5)/12 +3/5 +χ είναι ",
//                    "αόριστη",
//                    "αδύνατη",
//                    "έχει μοναδική λύση τον αριθμό 9",
//                    "έχει λύση μόνο τον αριθμό 4",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no26
//            questionService.saveQuestion(
//                    null,
//                    " Να βρεθούν δυο διαδοχικοί φυσικοί αριθμοί α και β που το άθροισμά τους να ισούται με το τριπλάσιο της διαφοράς τους. \n",
//                    "α=-2,α=1",
//                    "α=2, β=-3",
//                    "α=5,β=6",
//                    "Τίποτα απο αυτά",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no27
//            questionService.saveQuestion(
//                    null,
//                    "Το εξαπλάσιο του αθροίσματος ενός αριθμού με το διπλάσιο ενός άλλου",
//                    "6(χ+2y)",
//                    "6x +2y",
//                    "-6x +5",
//                    "x/6 +2y",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no28
//            questionService.saveQuestion(
//                    null,
//                    "Το υποδεκαπλάσιο ενός αριθμού μειωμένο κατα το διπλασιο του αθροίσματος του ίδιου του αριθμού με το πενταπλάσιο ενός άλλου\n",
//                    " κ/10 - 2(κ+ 5λ)",
//                    " κ/10 -2κ+5λ",
//                    "10κ -2(κ+2κ)",
//                    "κ/10 -2(κ +5κ)",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no29
//            questionService.saveQuestion(
//                    null,
//                    "Το εικοσαπλάσιο του υποτριπλάσιου του αθροίσματος ενός αριθμού με το διπλάσιο ενός άλλου μειωμένο κατα 3 ισούται με 4\n",
//                    "20* ⅓ *(χ+2y) -3 =4",
//                    "20x +2y =4 ",
//                    " 20x +⅓ (x+2y) -3 =4",
//                    "τίποτα απο αυτά",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//                //no30
//            questionService.saveQuestion(
//                    null,
//                    "Το τριπλάσιο ενος αριθμού αυξημένο κατα το γινόμενο του ίδιου του αριθμού με το πηλίκο του ίδιου του αριθμού με το 4 μειωμένο κατα 2 είναι μεγαλύτερο  του 65\n",
//                    "3χ+ χ*χ/4 -2 >65",
//                    "3χ +χ/4 =65",
//                    "2χ+χ+χ4=-65",
//                    "τίποτα απο αυτά",
//                    "meletis@gmail.com",
//                    prwtobathmies.getName());
//
                //no31
            questionService.saveQuestion(
                    "https://drive.google.com/uc?export=view&id=1G5GEcZYpco0dtVs7Dxf46TVgVi8tvHnk",
                    "Το εμβαδόν του τετραγώνου όπως φαίνεται στο σχήμα είναι",
                    "144",
                    "-2",
                    "9",
                    "8",
                    "meletis@gmail.com",
                    embada.getName());
//                //no32
//            questionService.saveQuestion(
//                    "https://drive.google.com/uc?export=view&id=1u6aTWxtni3e5NzH1riJctytzxWhhlR7N",
//                    "Το εμβαδόν του τριγώνου όπως φαίνεται στο σχήμα είναι",
//                    "16 τ.ε",
//                    "-12 τ.ε",
//                    "26 τ.ε",
//                    "τίποτα απο αυτά",
//                    "meletis@gmail.com",
//                    embada.getName());
////                //no33
//            questionService.saveQuestion(
//                    "https://drive.google.com/uc?export=view&id=1EHi6lwch_LUuRCh80Yk-0IUiOqp_ibN0",
//                    "Το εμβαδόν του ορθογωνίου όπως φαίνεται στο σχήμα είναι",
//                    "35 τ.ε",
//                    "-12 τ.ε",
//                    "25 τ.ε",
//                    "τίποτα από αυτά",
//                    "meletis@gmail.com",
//                    embada.getName());
                //no34
//            questionService.saveQuestion(
//                    "https://drive.google.com/uc?export=view&id=1WLkePFJh2_vphL7QUEg27W3a4AMqKdgi",
//                    "Για ποια τιμή του χ το παρακάτω τρίγωνο θα είναι ορθογώνιο;",
//                    "5",
//                    "2",
//                    "δεν μπορεί να είναι ορθογώνιο",
//                    "τίποτα απο αυτά",
//                    "meletis@gmail.com",
//                    embada.getName());
//                //no35
//            questionService.saveQuestion(
//                    "https://drive.google.com/uc?export=view&id=1WfmGr-XY9i31A8_AZ8pSTwiOYS-RKYA3",
//                    "Για ποια τιμή του χ το παρακάτω τρίγωνο θα είναι ορθογώνιο;",
//                    "4",
//                    "-4",
//                    "14",
//                    "τίποτα απο αυτά",
//                    "meletis@gmail.com",
//                    embada.getName());
                //no36
            questionService.saveQuestion(
                    "https://drive.google.com/uc?export=view&id=1WeDHsxvXXfvzaZY68oUuz-6ooh7y6oHv",
                    "Αν χ=5 να υπολογίσετε το εμβαδόν του σχήματος",
                    "40",
                    "-4",
                    "12",
                    "τίποτα απο αυτά",
                    "meletis@gmail.com",
                    embada.getName());
                //no37
            questionService.saveQuestion(
                    "https://drive.google.com/uc?export=view&id=1WeDHsxvXXfvzaZY68oUuz-6ooh7y6oHv",
                    "Αν χ=2 να υπολογίσετε το εμβαδόν του σχήματος",
                    "10",
                    "-2",
                    "16",
                    "τίποτα απο αυτά",
                    "meletis@gmail.com",
                    embada.getName());
                //no38
            questionService.saveQuestion(
                    "https://drive.google.com/uc?export=view&id=1WeDHsxvXXfvzaZY68oUuz-6ooh7y6oHv",
                    "Αν χ=10 να υπολογίσετε το εμβαδόν του σχήματος",
                    "130",
                    "-2",
                    "33",
                    "τίποτα απο αυτά",
                    "meletis@gmail.com",
                    embada.getName());
//                //no39
//            questionService.saveQuestion(
//                    "https://drive.google.com/uc?export=view&id=1QGT7rv35EHjWWTzcoyQvZlpdG2LvINUI",
//                    "Αν χ=8 να υπολογίσετε το εμβαδόν του σχήματος",
//                    "88",
//                    "-77",
//                    "808",
//                    "τίποτα απο αυτά",
//                    "meletis@gmail.com",
//                    embada.getName());
//                no40
//            questionService.saveQuestion(
//                    "https://drive.google.com/uc?export=view&id=1QGT7rv35EHjWWTzcoyQvZlpdG2LvINUI",
//                    "Αν χ=10 να υπολογίσετε το εμβαδόν του σχήματος",
//                    "130",
//                    "-55",
//                    "80",
//                    "τίποτα απο αυτά",
//                    "meletis@gmail.com",
//                    embada.getName());

            List<Question> questionList = questionService.getSubjectQuestions(
                    "meletis@gmail.com",
                    "Εμβαδά Σχημάτων");

//            for(Question q : questionList) {
//                System.out.println(q.getText());
//            }



            //List<User> artemisStudents = userService.getStudents("artemis@gmail.com");

       //     Map<Long, Integer> results = new HashMap<>();

     /*       results.put(questionService.)*/

     /*       questionService.saveQuizResults();*/

//            User aaa = new User(null, "aaa", 1234, "aaa", "aaa", new ArrayList<>(), )
            //todo


           // System.out.println(artemisStudents.get(0).getEmail());


        };
    }
}
