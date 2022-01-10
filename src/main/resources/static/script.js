
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

class SubjectPost {
    constructor(subject_id,subject_name,subject_class) {
        this.subject_id = subject_id;
        this.subject_name = subject_name;
        this.subject_class = subject_class;
    }
}

class ClassPost {
    constructor(class_id,class_name) {
        this.class_id = class_id;
        this.class_name = class_name;
    }
}
class UserPost {
    constructor(user_id,user_email,user_phone_number,user_password,user_fullname,user_role,user_teacher) {
        this.user_id = user_id;
        this.user_email = user_email;
        this.user_phone_number  = user_phone_number;
        this.user_password  = user_password;
        this.user_fullname = user_fullname ;
        this.user_role  = user_role;
        this.user_teacher =user_teacher ;
    }
}

document.getElementById("colSubmit").addEventListener("click", (event) => {

    const questionPost = new QuestionPost('image', 'test', 'opt1', 'opt2', 'opt3', 'opt4' , 'script');
    const classPost = new ClassPost(12,"DHMOTIKO");

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/question", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(questionPost));
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {

            }
        }
    };
});

document.getElementById("classSubmit").addEventListener("click", (event) => {

    const classPost = new ClassPost("12","DHMOTIKO");

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/teacher/class", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(classPost));
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {

            }
        }
    };
});

document.getElementById("subjectSubmit").addEventListener("click", (event) => {

    const subjectPost = new SubjectPost("12","dunameis","DHMOTIKO");

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/teacher/subject", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(subjectPost));
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {

            }
        }
    };
});

document.getElementById("userSubmit").addEventListener("click", (event) => {

    const userPost = new UserPost("12","meletis@gmail.com",1234567,1234,"meletis","teacher","none");

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/user", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(userPost));
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {

            }
        }
    };
});

document.getElementById("deleteClass").addEventListener("click", (event) => {

    let xhr = new XMLHttpRequest();
    let id = 1;
    xhr.open("DELETE", "http://localhost:8080/teacher/class/"+id, true);
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {

            }
        }
    };
});















// window.addEventListener('load',(event)=>{
//     document.getElementById('doquiz').addEventListener('click',(event)=>{
//
//         alert("do quiz alert")
//         //xml request , add a something
//         const xhr = new XMLHttpRequest();
//         xhr.open('POST','http://localhost:8080/quiz',true);
//         xhr.setRequestHeader('Content-Type','application/json');
//         xhr.send(JSON.stringify(something)); //use stringify to convert object to string
//         xhr.onreadystatechange = function(){
//             //so if i have a http response and i have a usefull result to take
//             if(xhr.readyState == 4 && xhr.status == 200){
//
//             }
//         };
//     });
//
//     document.getElementById('myGrades').addEventListener('click',(event)=>{
//         alert("show my grades  alert")
//
//         //XML request object
//         const xhr = new XMLHttpRequest();
//         xhr.open('GET',`http://localhost:8080/myGrades`,true);
//         xhr.send();
//
//         xhr.onreadystatechange =function (){
//
//         };
//     });
//
//
//     document.getElementById('do').addEventListener('click',(event)=>{
//
//     });
//
//
// });