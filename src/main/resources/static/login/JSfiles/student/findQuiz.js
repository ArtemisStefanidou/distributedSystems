
document.getElementById("findQuiz").addEventListener("click", (event) => {


    document.getElementById('subject').style.borderColor = '';
    const subjectSelect = document.getElementById('subject').value;

    if (subjectSelect == 'select') {

        document.getElementById('subject').style.borderColor = 'OrangeRed';
        alert("All the fields must be filled out. Fill out the subject please");
        return;
    }

    // class SelectedItems {
    //     constructor(subject,classSelected,level) {
    //         this.subject = subject;
    //         this.classSelected = classSelected;
    //         this.level = level;
    //
    //     }
    // }

    const request = new XMLHttpRequest();

    //const selectedItems = new SelectedItems(subjectSelect,userClass,levelSelect);

    const subjectSend= subjectSelect;
    //for asynchronised
    request.open('GET', "http://localhost:8080/login/student/doQuiz", true);
    request.send();
    //to check when the request is okay to leave
    request.onreadystatechange = function () {

        if (request.readyState == 4) {
            if (request.status == 200) {


                const grades = JSON.parse(request.responseText);
                alert(grades.toString());

            }
        }
    };

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

