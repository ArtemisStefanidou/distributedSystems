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

//check the input from the user before request leave
function validateForm() {

    //get the values of the elements to use them below
    const email = document.getElementById('email').value;
    const fullName = document.getElementById('fullName').value;
    const password = document.getElementById('password').value;
    const phone = document.getElementById('phone').value;

    if (email == '' || email.split('@').length < 2) {

        alert("All the fields must be filled out.Please fill out the field 'Email'");
        return false;

    }

    if (fullName == '') {

        alert("All the fields must be filled out.Please fill out the field for fullName");
        return false;

    }

    if (password == '') {

        alert("All the fields must be filled out. Fill out the password please");
        return false;

    }

    if (phone == '' || phone < 0 || Number.isInteger(phone) || phone.toString().indexOf('.') == 0) {

        alert("Please give a valid phone like 11880 or 6912341003 . Not -8.5 or 8.6 or nothing");
        return false;

    }
    return true;
}

document.getElementById("addStudent").addEventListener("click", (event) => {

    if(!validateForm()){
        return false;
    }else{
        const email_student = document.getElementById('email').value;
        let phone_student = document.getElementById('phone').value;
        const password_student = document.getElementById('password').value;
        const fullName_student = document.getElementById('fullName').value;

        const accessToken = localStorage.getItem("accessToken");
        const email = localStorage.getItem("email");

        let user = new UserPost(null,email_student,phone_student.toString(),password_student,fullName_student,"student",email);

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
    }

});

document.getElementById("updateStudent").addEventListener("click", (event) => {

    // Update a user
    const accessToken = localStorage.getItem("accessToken");
    const email = localStorage.getItem("email");

    const emailStudent = document.getElementById('email').value;
    let phoneStudent = document.getElementById('phone').value;
    const passwordStudent = document.getElementById('password').value;
    const fullNameStudent = document.getElementById('fullName').value;
    phoneStudent = phoneStudent.toString();

    var studentNew = {};
    studentNew.user_id = "";
    studentNew.user_email = emailStudent;
    studentNew.user_phone_number = phoneStudent;
    studentNew.user_password = passwordStudent;
    studentNew.user_fullName = fullNameStudent;
    studentNew.user_role = "";
    studentNew.email_teacher = email;

    var json = JSON.stringify(studentNew);

    const xhr = new XMLHttpRequest();

    xhr.open("PUT", "http://localhost:8080/teacher/student/"+email, true);
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