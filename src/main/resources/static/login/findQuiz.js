
document.getElementById("findQuiz").addEventListener("click", (event) => {

    // Update a user

    var id = 1;

    var studentNew = {};
    studentNew.email = "maths@gmail.com";
    studentNew.phoneNumber = 345677;
    studentNew.password = "dretfgdgdf";//prepei na perasei prvta apo to security kanonika
    studentNew.fullName = "Artemis";

    var json = JSON.stringify(studentNew);

    var xhr = new XMLHttpRequest();
    xhr.open("PUT", "http://localhost:8080/teacher/student/"+id, true);
    xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhr.onload = function () {
        var text = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {
            console.table(text);
        } else {
            console.error(text);
        }
    }
    xhr.send(json);
});