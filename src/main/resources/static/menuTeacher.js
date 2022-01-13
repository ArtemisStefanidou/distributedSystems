class QuestionPost {
    constructor(question_image, question_text, question_option1, question_option2, question_option3, question_option4, question_script) {
        this.question_image = question_image;
        this.question_text = question_text;
        this.question_option1 = question_option1;
        this.question_option2 = question_option2;
        this.question_option3 = question_option3;
        this.question_option4 = question_option4;
        this.question_script = question_script;
    }
}

document.getElementById("colSubmit").addEventListener("click", (event) => {

    const questionPost = new QuestionPost('image', 'test', 'opt1', 'opt2', 'opt3', 'opt4' , 'script');

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