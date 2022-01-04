# distributedSystems
a team project for Distributed Systems Class HUA
# distributedSystems
a team project for Distributed Systems Class HUA
-----------------------------------------------------------------------

online doc https://docs.google.com/document/d/1xtqQCBkSEX6O3Z0vvs7zvSIu-oAtml-82NfRlfJ3N_0/edit#bookmark=id.jda1zjvxvsia

Οδηγίες εργασιών

https://docs.google.com/document/d/e/2PACX-1vSnSUfpPwum1Pt-48ttv7J5-vsQ5yYst9rufVGh96o8yFXkpXbE3xOdZPlN3trG3sHniWhD2ZAIm7fI/pub

Θέματα Εργασιών

https://docs.google.com/document/d/e/2PACX-1vReZn87dLrV-lEkipsHImlP2IcJOJLxk27cP1TZi0qSVJ4Rf6C7XmlKwqUR2ZxmImyRgmJ2UyACo5Ps/pub

Αναθέσεις Εργασιών

https://docs.google.com/spreadsheets/d/e/2PACX-1vT_mJFeT_xZjE6BTzqigJF4_jN2dddTgTPeIBm-LkgEbQKHithdiQol38gsP5OJLILtrP703hlZyH7N/pubhtml?gid=647520828&single=true
----------------------------------------------------------------------

Θα έχουμε ένα σύστημα στο οποίο:

Ο Μαθητής θα μπορεί:<br />
   &emsp; 1.Να κάνει εγγραφή στο σύστημα (με email, κωδικό, αριθμό τηλεφώνου,ονοματεπώνυμο, τάξη) <br />
   &emsp; 2.Να συνδέεται στο σύστημα(με email και κωδικό)<br />
   &emsp; 3.Να επιλέγει τάξη γυμνασίου στην οποία θέλει να εξασκηθεί <br />
   &emsp; 4.Να επιλέγει quiz ερωτήσεων, τα οποία χωρίζονται ανά κεφάλαιο <br />
   &emsp; 5.Να βλέπει ιστορικό με τα ποσοστά των quiz ανά κεφάλαιο <br />


Ο Καθηγητής θα μπορεί:<br />
   &emsp; 1.Να κάνει εγγραφή στο σύστημα ( email, κωδικό , αριθμό τηλεφώνου, ονοματεπώνυμο) <br />
   &emsp; 2.Να συνδέεται στο σύστημα (με email και κωδικό...στην επιλογή "Συνδέσου ως  Καθηγητής") <br />
   &emsp; 3.Να δημιουργήσει φακέλους για να ξεχωρίζει τις τάξεις του γυμνασίου <br />
   &emsp; 4.Να δημιουργήσει ένα quiz (με κατάλληηλο όνομα για να εκφράζεται το κεφάλαιο) <br />
   &emsp; 5.Να διαγράψει ένα quiz <br />
   &emsp; 6.Να τροποποιήσει ένα quiz <br />
   &emsp; 7.Να εμφανίσει ανα μαθητή το ιστορικό επίδοσης ανα τύπου quiz <br /> 

Μερικές λειτουργίες ακόμα είναι πως: <br />
   &emsp; 1.θα παρέχεται επιλογή στους χρήστες "Ξεχάσατε τον Κωδικό σας" και θα επιστρέφεται κατάλληλο μήνυμα επαλήθευσεις και ανάκτησης κωδικού <br />


Παραδοχές<br />
&emsp; 1. Ο καθηγητής θα μπορεί να μπαίνει σαν μαθητής για να δοκιμάζει<br />
&emsp; 2. Κάθε μαθητής και κάθε καθηγητής μπορεί να έχει μόνο έναν συνδυασμό στοιχείων για να συνδεθεί<br />
&emsp; 3. Το σύστημα θα εμφανίζει τυχαία τις ερωτήσεις των quiz οι οποίες ανα κεφάλαιο θα έχουν χωρίστει σε 3 επίπεδα ( LVL1 LVL2 LVL3) .<br />
    &emsp;&emsp;Δηλαδή το quiz θα αποτελείται από 30 ερωτήσεις,  10 τύπου LVL1 , 10 τύπου LVL2  και 10 τύπου LVL3<br />
&emsp; 4.Ένας μαθητής θα μπορεί να κάνει όσες φορές θέλει ένα quiz , και ένα quiz θα μπορεί να γίνεται από πολλούς μαθητές<br />
&emsp; 5.Ένα κεφάλαιο θα μπορεί να έχει πολλές ερωτήσεις, όμως μια ερώτηση θα αντιστοιχίζεται σε μόνο ένα κεφάλαιο<br />
&emsp; 6.Ο μαθητής μπορεί να επιλέξει να κάνει quiz ανεξάρτητα με την τάξη στην οποία βρίσκεται <br />
&emsp; 7. Για να επιλέξει ο μαθητής κάποιο quiz πρέπει πρώτα να έχει επιλέξει την τάξη που θέλει<br />
&emsp; 8.για να δημιουργήσει ο καθηγητής quiz θα πρέπει πρώτα να χει δηλώσει σε ποια τάξη ανήκει <br />

create table question(
                         question_id INT NOT NULL AUTO_INCREMENT,
                         question_image VARCHAR(100),
                         question_text VARCHAR(100) NOT NULL,
                         question_option1 VARCHAR(100) NOT NULL,
                         question_option2 VARCHAR(100) NOT NULL,
                         question_option3 VARCHAR(100),
                         question_option4 VARCHAR(100),
                         question_script VARCHAR(100),
                         PRIMARY KEY ( question_id )
);

create table subject(
                        subject_id INT NOT NULL AUTO_INCREMENT,
                        subject_name VARCHAR(50) NOT NULL,
                        subject_class VARCHAR(50) ,
                        PRIMARY KEY ( subject_id )
);

create table quiz_lv1(
                         subject_lv1_id INT NOT NULL,
                         question_lv1_id INT NOT NULL,
                         PRIMARY KEY ( subject_lv1_id , question_lv1_id),
                         FOREIGN KEY (subject_lv1_id) REFERENCES subject(subject_id),
                         FOREIGN KEY (question_lv1_id) REFERENCES question(question_id)
);

create table quiz_lv2(
                         subject_lv2_id INT NOT NULL,
                         question_lv2_id INT NOT NULL,
                         PRIMARY KEY ( subject_lv2_id , question_lv2_id),
                         FOREIGN KEY (subject_lv2_id) REFERENCES subject(subject_id),
                         FOREIGN KEY (question_lv2_id) REFERENCES question(question_id)
);

create table quiz_lv3(
                         subject_lv3_id INT NOT NULL,
                         question_lv3_id INT NOT NULL,
                         PRIMARY KEY ( subject_lv3_id , question_lv3_id),
                         FOREIGN KEY (subject_lv3_id) REFERENCES subject(subject_id),
                         FOREIGN KEY (question_lv3_id) REFERENCES question(question_id)
);

create table user(
                     user_id INT NOT NULL AUTO_INCREMENT,
                     user_email VARCHAR(50) NOT NULL,
                     user_phone_number INT NOT NULL,
                     user_password VARCHAR(50) NOT NULL,
                     user_fullname VARCHAR(50) NOT NULL,
                     user_role VARCHAR(50) NOT NULL,
                     user_teacher VARCHAR(50),
                     PRIMARY KEY (user_id)
);

create table grade(
                      grade_of_question INT NOT NULL,
                      grade_question_id INT NOT NULL,
                      grade_user_id INT NOT NULL,
                      FOREIGN KEY (grade_question_id) REFERENCES question(question_id),
                      FOREIGN KEY (grade_user_id) REFERENCES user(user_id),
                      PRIMARY KEY (grade_question_id,grade_user_id)
);
