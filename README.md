# distributedSystems
a team project for Distributed Systems Class HUA
# distributedSystems
a team project for Distributed Systems Class HUA
-----------------------------------------------------------------------
 
**online doc**<br /> https://docs.google.com/document/d/1jAbl3qfcJdOLAeb-BAcrI_uYFsfwyqYo3WkrFhEoOtY/edit 
<br />**online PowerPoint**<br /> https://docs.google.com/presentation/d/1jU4LQRuBOY4fQS3JBUZmy0_nuLKXkK0uoA3Wjedy1dg/edit </br>
**draw-diagramms** <br/> https://app.diagrams.net/#HArtemisStefanidou%2FdistributedSystems%2Fmain%2Fprwtoparadoteo.drawio 
</br>

<br />
Οδηγίες εργασιών
<br />
https://docs.google.com/document/d/e/2PACX-1vSnSUfpPwum1Pt-48ttv7J5-vsQ5yYst9rufVGh96o8yFXkpXbE3xOdZPlN3trG3sHniWhD2ZAIm7fI/pub
<br />

Θέματα Εργασιών
<br />
https://docs.google.com/document/d/e/2PACX-1vReZn87dLrV-lEkipsHImlP2IcJOJLxk27cP1TZi0qSVJ4Rf6C7XmlKwqUR2ZxmImyRgmJ2UyACo5Ps/pub
<br />
Αναθέσεις Εργασιών<br />
https://docs.google.com/spreadsheets/d/e/2PACX-1vT_mJFeT_xZjE6BTzqigJF4_jN2dddTgTPeIBm-LkgEbQKHithdiQol38gsP5OJLILtrP703hlZyH7N/pubhtml?gid=647520828&single=true

<br /><br />

-----------------------------------Βήματα εγκατάστασης-----------------------------------<br />
&emsp;1.Πατήστε το κουμπί για download σε zip<br />
&emsp;2.Κάντε unzip το αρχείο και <br />
&emsp;3.Ανοίξτε το με κάποιο IDE, προτεινόμενο : intellij<br />
<br /><br />
-----------------------------Περιγραφή Συστήματος-----------------------------------------


    Είναι  μια μικρή εφαρμογή για να μπορεί ο καθηγητής να έχει τον δικό του χώρο και να φτιάχνει δικά του quiz με
    τα οποία να κάνει πιο ευχάριστο το μάθημα αλλά ταυτόχρονα οι μαθητές του να μαθαίνουν καλύτερα τα όσα κάνουν στην τάξη
    Θα έχουμε ένα σύστημα στο οποίο:
    
    Ο Μαθητής θα μπορεί:
     1.Να συνδέεται στο σύστημα(με email και κωδικό)
     2.Να επιλέγει Οι απαντήσεις μου και να βλέπει τις ερωτήσεις που έχει ήδη απαντήση και το πώς τα πήγε 
     3.Να επιλέγει quiz ερωτήσεων, τα οποία χωρίζονται ανά κεφάλαιο 
     4.Να κάνει αποσύνδεση απο το σύστημα 

    
    Ο Καθηγητής θα μπορεί:
     1.Να κάνει εγγραφή στο σύστημα ( email, κωδικό , αριθμό τηλεφώνου, ονοματεπώνυμο) 
     2.Να συνδέεται στο σύστημα (με email και κωδικό) 
     3.Να δημιουργήσει μια ερώτηση γράφοντας ένα κείμενο για εκφώνηση, 4 πιθανές απαντήσεις , το κεφάλαιο που ανήκει η ερώτηση και αν επιθυμεί μια φωτογραφία 
     4.Να διαγράψει μια ερώτηση 
     5.Να τροποποιήσει μια ερώτηση 
     6.Να εμφανίσει ανα μαθητή το ιστορικό επίδοσης ανα ερώτηση 
     7.Να δημιουργήσει έναν μαθητή βάζοντας email, ονοματεπώνυμο, κωδικό πρόσβασης και κινητό  
     8.Να επεξεργαστεί και να αλλάξει τα δεδομένα των  μαθητών του 
     9.Να διαγράψει κάποιον  μαθητή του
     10.Να δει τις ερωτήσεις που έχει φτιάξει
     11.Να εμφανίσει όλους τους μαθητές του και να δει τις επιδόσεις τους

    
    Παραδοχές
     1. Κάθε μαθητής και κάθε καθηγητής μπορεί να έχει μόνο έναν συνδυασμό στοιχείων για να συνδεθεί
     2. Το σύστημα θα εμφανίζει με τυχαία σειρά τις ερωτήσεις και τις απαντήσεις των quiz 
     3. Ένας μαθητής θα μπορεί να κάνει όσες φορές θέλει ένα τύπο quiz (ανα κεφάλαιο) , και ένας τύπος quiz θα μπορεί να γίνεται απο πολλούς μαθητές
     4. Ο μαθητής μπορεί να επιλέξει να κάνει quiz ανεξάρτητα με την τάξη στην οποία βρίσκεται εφόσον επιλέγει με βάση το κεφάλαιο
     5. Θεωρούμε πως το email παραμένει σταθερό 
     6. Θεωρούμε και ότι η κάθε ερώτηση είναι μοναδική ανα καθηγητή (επομένως μπορούμε και να αναζητήσουμε με αυτήν την εκφώνηση) 


<br /><br />
-----------------------------Σύνδεση στην βάση μας μέσω intellij-----------------------------------------<br />
Για την σύνδεση στην βάση μας, μετα το download του προγραμματος μας θα πρέπει:<br/>
&emsp; 1.Να πατήσεετε στο menu πάνω δεξιά με τις database<br/>
&emsp; 2.Να πατήσετε το σύμβολο του "+" για την προσθήκη μιας βάσης<br/>
&emsp; 3.Πατήστε στο Data Source/MySQL  <br />
&emsp; 4.Βάλτε τα στοιχεία   <br />
  &emsp; &emsp;Endpoint<br />
  &emsp; &emsp; &emsp;distributedsystemsdatabase.chtaqpwno8ds.eu-central-1.rds.amazonaws.com <br />
  &emsp; &emsp;Port<br />
 &emsp; &emsp;  &emsp;3306 <br />
 &emsp;  &emsp;admin <br /> &emsp;&emsp; &emsp; den3ereistonkwdiko<br/>
&emsp; 5.Και πατήστε Apply και μετά Οκ <br />
