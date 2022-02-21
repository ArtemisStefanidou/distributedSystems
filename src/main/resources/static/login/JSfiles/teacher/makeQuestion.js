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

//check the input from the user before request leave
function validateForm() {

    //get the values of the elements to use them below
    const image = document.getElementById('image').value;
    const txt = document.getElementById('txt').value;
    const option1 = document.getElementById('option1').value;
    const option2 = document.getElementById('option2').value;

    if (txt == '') {

        alert("You can not create a question with empty text. Please fill out the text");
        return false;

    }

    if (option1 == '' && option2 == '') {

        alert("For create a question you  must give two options.So please field out the option 1 and the option 2 and if you want you can fill and the other options");
        return false;

    }

    return true;
}



document.getElementById("addQuestion").addEventListener("click", (event) => {

    if(!validateForm()){
        return false;
    }else{
        const accessToken = localStorage.getItem("accessToken");
        const email = localStorage.getItem("email");

        const image = document.getElementById('image').value;
        const text = document.getElementById('txt').value;
        const option1 = document.getElementById('option1').value;
        const option2 = document.getElementById('option2').value;
        const option3 = document.getElementById('option3').value;
        const option4 = document.getElementById('option4').value;
        const teacher_email = email;
//subject
        const subject = document.getElementById('subjects').value;
        const questionPost = new QuestionPost(image,text, option1, option2, option3, option4, teacher_email,subject);

        const xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost:8080/teacher/question", true);
        xhr.setRequestHeader("Authorization", accessToken);
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
    }

});
document.getElementById("updateQuestion").addEventListener("click", (event) => {

    const accessToken = localStorage.getItem("accessToken");
    const email = localStorage.getItem("email");

    // Update a user

    const image = document.getElementById('image').value;
    //text unique
    const text = document.getElementById('txt').value;
    const option1 = document.getElementById('option1').value;
    const option2 = document.getElementById('option2').value;
    const option3 = document.getElementById('option3').value;
    const option4 = document.getElementById('option4').value;
    const teacher_email = email;
    const subject_question = document.getElementById('subjects').value;

    var questionNew = {};
    questionNew.question_image = image;
    questionNew.question_text = text;
    questionNew.question_option1 = option1;
    questionNew.question_option2 = option2;
    questionNew.question_option3 = option3;
    questionNew.question_option4 = option4;
    questionNew.email_teacher = teacher_email;
    questionNew.subject_question = subject_question;

    var question = JSON.stringify(questionNew);

    var xhr = new XMLHttpRequest();
    xhr.open("PUT", "http://localhost:8080/teacher/question/", true);
    xhr.setRequestHeader("Authorization", accessToken);
    xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhr.onload = function () {

        if (xhr.readyState == 4 && xhr.status == "200") {
            var text = xhr.responseText;
            alert(text);
        } else {
            alert("Failed Update.Problem with Server");
        }
    }
    xhr.send(question);

});


document.getElementById("logOut").addEventListener("click",    (event) => {
    accessToken=null;
    localStorage.setItem("accessToken", accessToken);

    refreshToken=null;
    localStorage.setItem("refreshToken", refreshToken);

    role='';
    localStorage.setItem("role", role);

    email='';
    localStorage.setItem("email", email);

    window.location.href = "http://localhost:8080/login/menu";

});