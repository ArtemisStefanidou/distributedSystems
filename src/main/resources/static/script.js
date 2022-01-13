
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

class GradePost {
    constructor(grade_of_question,grade_question_id,grade_user_id) {
        this.grade_of_question = grade_of_question;
        this.grade_question_id = grade_question_id;
        this.grade_user_id = grade_user_id;
    }
}




document.getElementById("classSubmit").addEventListener("click", (event) => {

    //const classPost = new ClassPost(12,"DHMOTIKO");

    var classNew = {};
    classNew.class_id = 12;
    classNew.class_name = "gimnasio";

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/teacher/class", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(classNew));
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

    alert("js");
    let xhr = new XMLHttpRequest();
    let id = 1;
    xhr.open("DELETE", "http://localhost:8080/teacher/class/"+id, true);
    xhr.onload = function () {
        var classBack = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {
            console.table(classBack);
        } else {
            console.error(classBack);
        }
    }
    xhr.send(null);
});

document.getElementById("deleteSubject").addEventListener("click", (event) => {

    alert("deleteSubject");
    let xhr = new XMLHttpRequest();
    let id = 1;
    xhr.open("DELETE", "http://localhost:8080/teacher/subject/"+id, true);
    xhr.onload = function () {
        let subject = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {
            console.table(subject);
        } else {
            console.error(subject);
        }
    }
    xhr.send(null);
});


document.getElementById("deleteQuestion").addEventListener("click", (event) => {

    alert("deleteQuestion");
    let xhr = new XMLHttpRequest();
    let id = 1;
    xhr.open("DELETE", "http://localhost:8080/teacher/question/"+id, true);
    xhr.onload = function () {
        let question = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {
            console.table(question);
        } else {
            console.error(question);
        }
    }
    xhr.send(null);
});

document.getElementById("deleteStudent").addEventListener("click", (event) => {

    alert("deleteStudent");
    let xhr = new XMLHttpRequest();
    let id = 1;
    xhr.open("DELETE", "http://localhost:8080/teacher/student/"+id, true);
    xhr.onload = function () {
        let question = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {
            console.table(question);
        } else {
            console.error(question);
        }
    }
    xhr.send(null);
});

document.getElementById("studentList").addEventListener("click", (event) => {
    const request = new XMLHttpRequest();

    //for asynchronised
    request.open('GET', "http://localhost:8080/teacher/studentsList/", true);
    request.send();
    //to check when the request is okay to leave
    request.onreadystatechange = function () {

        if (request.readyState == 4) {
            if (request.status == 200) {

                let divElem = document.getElementById('printStudents');
                let headersValues = ['Id','Email', 'Phone Number', 'Pass', 'Name','Teacher'];

                let table = document.createElement('table');
                let headersRows = document.createElement('tr');

                //delete all the childrens besause maybe already exists a table with not updated info
                while (divElem.firstChild) {
                    divElem.removeChild(divElem.firstChild);
                }

                const students = JSON.parse(request.responseText);

                //if results is 0 means that the select returns 0 rows because it doesn't find books to database
                if (students.length == 0) {

                    let errorTextNode = document.createTextNode("We don't have students in our database");
                    //add this child to divElem to print the message to user
                    divElem.appendChild(errorTextNode);
                    return false;
                }

                //do the row and the cells for the headers of the table
                headersValues.forEach(headerText => {
                    let header = document.createElement('th');
                    let textNode = document.createTextNode(headerText);
                    header.appendChild(textNode);
                    headersRows.appendChild(header);
                });

                table.appendChild(headersRows);

                /*for each row that exists in the results (the rows that given by select)
                   i do a foreach for each value that object book has to create the table to
                   put all the values for each book that i have*/

                /*if something went wrong with the database in the table appeared the wrong
                    message to inform the user*/
                students.forEach(student => {
                    let row = document.createElement('tr');

                    Object.values(student).forEach(text => {
                        let cell = document.createElement('td');
                        let textNode = document.createTextNode(text);
                        cell.appendChild(textNode);
                        //add cell by cell into the row to complite the info of one book that i have in the database
                        row.appendChild(cell);
                    })

                    //add row by row into the table
                    table.appendChild(row);

                });

                //add the completed table
                divElem.appendChild(table);
            }
        }
    };
});

document.getElementById("getStudent").addEventListener("click", (event) => {
    const request = new XMLHttpRequest();

    let id = 4;
    //for asynchronised
    request.open('GET', "http://localhost:8080/teacher/student/"+id, true);
    request.send();
    //to check when the request is okay to leave
    request.onreadystatechange = function () {

        if (request.readyState == 4) {
            if (request.status == 200) {

                let divElem = document.getElementById('printStudent');
                let headersValues = ['Id','Email', 'Phone Number', 'Pass', 'Name','Role','Teacher'];

                let table = document.createElement('table');
                let headersRows = document.createElement('tr');

                //delete all the childrens besause maybe already exists a table with not updated info
                while (divElem.firstChild) {
                    divElem.removeChild(divElem.firstChild);
                }

                const students = JSON.parse(request.responseText);

                //if results is 0 means that the select returns 0 rows because it doesn't find books to database
                if (students.length == 0) {

                    let errorTextNode = document.createTextNode("We don't have students in our database");
                    //add this child to divElem to print the message to user
                    divElem.appendChild(errorTextNode);
                    return false;
                }

                //do the row and the cells for the headers of the table
                headersValues.forEach(headerText => {
                    let header = document.createElement('th');
                    let textNode = document.createTextNode(headerText);
                    header.appendChild(textNode);
                    headersRows.appendChild(header);
                });

                table.appendChild(headersRows);

                /*for each row that exists in the results (the rows that given by select)
                   i do a foreach for each value that object book has to create the table to
                   put all the values for each book that i have*/

                /*if something went wrong with the database in the table appeared the wrong
                    message to inform the user*/

                    let row = document.createElement('tr');

                    // alert(Object.keys(students))
                    Object.values(students).forEach(text => {

                        let cell = document.createElement('td');
                        let textNode = document.createTextNode(text);
                        cell.appendChild(textNode);
                        //add cell by cell into the row to complite the info of one book that i have in the database
                        row.appendChild(cell);

                    })

                    //add row by row into the table
                    table.appendChild(row);



                //add the completed table
                divElem.appendChild(table);
            }
        }
    };
});

//student

document.getElementById("getGrades").addEventListener("click", (event) => {
    const request = new XMLHttpRequest();

    //for asynchronised
    request.open('GET', "http://localhost:8080/student/gradesList", true);
    request.send();
    //to check when the request is okay to leave
    request.onreadystatechange = function () {

        if (request.readyState == 4) {
            if (request.status == 200) {

                let divElem = document.getElementById('printGrades');
                let headersValues = ['Question','User', 'Grade'];

                let table = document.createElement('table');
                let headersRows = document.createElement('tr');

                //delete all the childrens besause maybe already exists a table with not updated info
                while (divElem.firstChild) {
                    divElem.removeChild(divElem.firstChild);
                }

                //do the row and the cells for the headers of the table
                headersValues.forEach(headerText => {
                    let header = document.createElement('th');
                    let textNode = document.createTextNode(headerText);
                    header.appendChild(textNode);
                    headersRows.appendChild(header);
                });

                table.appendChild(headersRows);

                const grades = JSON.parse(request.responseText);

                //if results is 0 means that the select returns 0 rows because it doesn't find books to database
                if (grades.length == 0) {

                    let errorTextNode = document.createTextNode("We don't have grades in our database");
                    //add this child to divElem to print the message to user
                    divElem.appendChild(errorTextNode);
                    return false;
                }

                /*for each row that exists in the results (the rows that given by select)
                   i do a foreach for each value that object book has to create the table to
                   put all the values for each book that i have*/

                /*if something went wrong with the database in the table appeared the wrong
                    message to inform the user*/
                grades.forEach(student => {
                    let row = document.createElement('tr');

                    Object.values(grade).forEach(text => {
                        let cell = document.createElement('td');
                        let textNode = document.createTextNode(text);
                        cell.appendChild(textNode);
                        //add cell by cell into the row to complite the info of one book that i have in the database
                        row.appendChild(cell);
                    })

                    //add row by row into the table
                    table.appendChild(row);

                });

                //add the completed table
                divElem.appendChild(table);
            }
        }
    };
});

document.getElementById("gradePost").addEventListener("click", (event) => {

    const gradePost = new GradePost(12, 1, 1);

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/student/quizAnswers", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(gradePost));
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {

            }
        }
    };
});

document.getElementById("putClass").addEventListener("click", (event) => {

    // Update a user

    var id = 1;

    var classNew = {};
    classNew.class_name = "gimnasio";
    var json = JSON.stringify(classNew);

    var xhr = new XMLHttpRequest();
    xhr.open("PUT", "http://localhost:8080/teacher/class/"+id, true);
    xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhr.onload = function () {
        var classDB = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {
            console.table(classDB);
        } else {
            console.error(classDB);
        }
    }
    xhr.send(json);


});

document.getElementById("putSubject").addEventListener("click", (event) => {

    // Update a user

    var id = 1;

    var subjectNew = {};
    subjectNew.subject_name = "exisoseis";
    subjectNew.subject_class = "gimnasio";
    var json = JSON.stringify(subjectNew);

    var xhr = new XMLHttpRequest();
    xhr.open("PUT", "http://localhost:8080/teacher/subject/"+id, true);
    xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
    xhr.onload = function () {
        var subjectDB = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {
            console.table(subjectDB);
        } else {
            console.error(subjectDB);
        }
    }
    xhr.send(json);

});

document.getElementById("putQuestion").addEventListener("click", (event) => {

    // Update a user

    var id = 1;

    var questionNew = {};
    questionNew.image = "maths";
    questionNew.text = "toDo";
    questionNew.option1 = "question_option1";
    questionNew.option2 = "question_option2";
    questionNew.option3 = "question_option3";
    questionNew.option4 = "question_option4";
    questionNew.script = "toDo";

    var json = JSON.stringify(questionNew);

    var xhr = new XMLHttpRequest();
    xhr.open("PUT", "http://localhost:8080/teacher/question/"+id, true);
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

document.getElementById("putStudent").addEventListener("click", (event) => {

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

document.getElementById("doQuiz").addEventListener("click", (event) => {
    const request = new XMLHttpRequest();

    var name = "quiz1"
    //for asynchronised
    request.open('GET', "http://localhost:8080/student/doQuiz/"+name, true);
    request.send();
    //to check when the request is okay to leave
    request.onreadystatechange = function () {

        if (request.readyState == 4) {
            if (request.status == 200) {
                let divElem = document.getElementById('printStudent');
                let headersValues = ['Id','Id Question', 'Name'];

                let table = document.createElement('table');
                let headersRows = document.createElement('tr');

                //delete all the childrens besause maybe already exists a table with not updated info
                while (divElem.firstChild) {
                    divElem.removeChild(divElem.firstChild);
                }

                const students = JSON.parse(request.responseText);

                //if results is 0 means that the select returns 0 rows because it doesn't find books to database
                if (students.length == 0) {

                    let errorTextNode = document.createTextNode("We don't have students in our database");
                    //add this child to divElem to print the message to user
                    divElem.appendChild(errorTextNode);
                    return false;
                }

                //do the row and the cells for the headers of the table
                headersValues.forEach(headerText => {
                    let header = document.createElement('th');
                    let textNode = document.createTextNode(headerText);
                    header.appendChild(textNode);
                    headersRows.appendChild(header);
                });

                table.appendChild(headersRows);

                /*for each row that exists in the results (the rows that given by select)
                   i do a foreach for each value that object book has to create the table to
                   put all the values for each book that i have*/

                /*if something went wrong with the database in the table appeared the wrong
                    message to inform the user*/

                let row = document.createElement('tr');

                // alert(Object.keys(students))
                Object.values(students).forEach(text => {

                    let cell = document.createElement('td');
                    let textNode = document.createTextNode(text);
                    cell.appendChild(textNode);
                    //add cell by cell into the row to complite the info of one book that i have in the database
                    row.appendChild(cell);

                })

                //add row by row into the table
                table.appendChild(row);



                //add the completed table
                divElem.appendChild(table);
            }
        }
    };

});








