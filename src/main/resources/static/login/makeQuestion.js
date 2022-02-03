class QuestionPost {
    constructor(question_image, question_text, question_option1, question_option2, question_option3, question_option4,question_teacher_email) {
        this.question_image = question_image;
        this.question_text = question_text;
        this.question_option1 = question_option1;
        this.question_option2 = question_option2;
        this.question_option3 = question_option3;
        this.question_option4 = question_option4;
        this.question_teacher_email = question_teacher_email;


    }
}

document.getElementById("makeQuestion").addEventListener("click", (event) => {

    const image = document.getElementById('image').value;
    const text = document.getElementById('txt').value;
    const option1 = document.getElementById('option1').value;
    const option2 = document.getElementById('option2').value;
    const option3 = document.getElementById('option3').value;
    const option4 = document.getElementById('option4').value;
    const teacher_email = "artemis@gmail.com";//πρέπει να το παίρνει από το token

    const questionPost = new QuestionPost(image,text, option1, option2, option3, option4, teacher_email);

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/teacher/question", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(questionPost));
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {

            }
        }
    };
});