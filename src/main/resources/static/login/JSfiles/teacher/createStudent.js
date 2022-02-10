class UserPost {
    constructor(user_id,user_email,user_phone_number,user_password,user_fullName,user_role,email_teacher) {
        this.user_id = user_id;
        this.user_email = user_email;
        this.user_phone_number  = user_phone_number;
        this.user_password  = user_password;
        this.user_fullname = user_fullName ;
        this.user_role  = user_role;
        this.email_teacher =email_teacher ;
    }
}

document.getElementById("addStudent").addEventListener("click", (event) => {

    const email_student = document.getElementById('email').value;
    const phone_student = document.getElementById('phone').value;
    const password_student = document.getElementById('password').value;
    const fullName_student = document.getElementById('fullName').value;

    const accessToken = localStorage.getItem("accessToken");
    const email = localStorage.getItem("email");

    const user = new UserPost(12,email_student,phone_student,password_student,fullName_student,"student",email);

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/teacher/user", true);
    xhr.setRequestHeader("Authorization", accessToken);
    xhr.setRequestHeader('Content-type','application/json;');

    xhr.send(JSON.stringify(user));
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


document.getElementById("updateStudent").addEventListener("click", (event) => {

    // Update a user

    const emailStudent = document.getElementById('email').value;
    const phoneStudent = document.getElementById('phone').value;
    const passwordStudent = document.getElementById('password').value;
    const fullNameStudent = document.getElementById('fullName').value;

    var studentNew = {};
    studentNew.email = emailStudent;
    studentNew.phoneNumber = phoneStudent;
    studentNew.password = passwordStudent;//prepei na perasei prvta apo to security kanonika
    studentNew.fullName = fullNameStudent;

    var json = JSON.stringify(studentNew);

    const accessToken = localStorage.getItem("accessToken");
    const email = localStorage.getItem("email");

    const xhr = new XMLHttpRequest();

    xhr.open("PUT", "http://localhost:8080/teacher/student/"+emailStudent, true);
    xhr.setRequestHeader("Authorization", accessToken);
    xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhr.onload = function () {
        var text = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {
            console.table(text);
            alert("Successful Update");
        } else {
            alert.error(text);
        }
    }
    xhr.send(json);

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