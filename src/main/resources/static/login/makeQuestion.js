class QuestionPost {
    constructor(question_image, question_text, question_option1, question_option2, question_option3, question_option4,
                email_teacher,subject_question) {
        this.question_image = question_image;
        this.question_text = question_text;
        this.question_option1 = question_option1;
        this.question_option2 = question_option2;
        this.question_option3 = question_option3;
        this.question_option4 = question_option4;
        this.email_teacher = email_teacher;
        this.subject_question = subject_question;


    }
}

document.getElementById("addQuestion").addEventListener("click", (event) => {

    const image = document.getElementById('image').value;
    const text = document.getElementById('txt').value;
    const option1 = document.getElementById('option1').value;
    const option2 = document.getElementById('option2').value;
    const option3 = document.getElementById('option3').value;
    const option4 = document.getElementById('option4').value;
    const teacher_email = "artemis@gmail.com";//πρέπει να το παίρνει από το token
//subject
    const subject = "Εξισώσεις";
    const questionPost = new QuestionPost(image,text, option1, option2, option3, option4, teacher_email,subject);

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/teacher/question", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(questionPost));
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {
                alert("Successful Addition");
            } else {
                alert("Something went wrong");
            }
        }
    };
});
document.getElementById("updateQuestion").addEventListener("click", (event) => {

    // Update a user

    const image = document.getElementById('image').value;
    //text unique
    const text = document.getElementById('txt').value;
    const option1 = document.getElementById('option1').value;
    const option2 = document.getElementById('option2').value;
    const option3 = document.getElementById('option3').value;
    const option4 = document.getElementById('option4').value;
    const teacher_email = "artemis@gmail.com";//πρέπει να το παίρνει από το token
//subject
//subject
    const subject_question = "Εξισώσεις";

    var questionNew = {};
    questionNew.image = image;
    questionNew.text = text;
    questionNew.option1 = option1;
    questionNew.option2 = option2;
    questionNew.option3 = option3;
    questionNew.option4 = option4;
    questionNew.email_teacher = teacher_email;
    questionNew.subject_question = subject_question;

    var question = JSON.stringify(questionNew);

    var xhr = new XMLHttpRequest();
    xhr.open("PUT", "http://localhost:8080/teacher/question/"+text, true);
    xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhr.onload = function () {
        var text = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {
            console.table(text);
        } else {
            console.error(text);
        }
    }
    xhr.send(question);

});