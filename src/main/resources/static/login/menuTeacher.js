document.getElementById("myQuestions").addEventListener("click", (event) => {


    let divElem = document.getElementById('questionList');
    let headersValues = ['Question', 'option1'];

    let tableQuestion = document.createElement('table');
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

    tableQuestion.appendChild(headersRows);
    divElem.appendChild(tableQuestion);

});

document.getElementById("showStudents").addEventListener("click", (event) => {


    let divElem = document.getElementById('studentList');
    let headersValues = ['Student', 'option1'];

    let tableStudent = document.createElement('table');
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

    tableStudent.appendChild(headersRows);
    divElem.appendChild(tableStudent);

});

// function validateFormQuestion() {
//
//     document.getElementById('subject').style.borderColor = '';
//     const subjectSelect = document.getElementById('subject').value;
//
//     if (subjectSelect == 'select') {
//
//         document.getElementById('subject').style.borderColor = 'OrangeRed';
//         alert("All the fields must be filled out. Fill out the subject please");
//         return false;
//     }
//
//     return true;
// }
//
// document.getElementById("doQuiz").addEventListener("click", (event) => {
//
//     if(!validateFormQuestion()){
//         return false;
//     }else {
//         location.href = "http://localhost:8080/login/student/doQuiz";
//
//     }
// });


// document.getElementById("myQuestions").addEventListener("click", (event) => {
//
//     const request = new XMLHttpRequest();
//
//     request.open('GET', "http://localhost:8080/teacher/menu/teacherQuestionList/", true);
//     request.send();
//     request.onreadystatechange = function () {
//
//         if (request.readyState == 4) {
//             if (request.status == 200) {
//
//
//                 // const grades = JSON.parse(request.responseText);
//                 // alert(grades.toString());
//
//             }
//         }
//     };

    // let idTeacher = 4; //Artemis in the Data Base
    //
    // //for asynchronised θελει το email του ή θα γίνει η ταυτοποίηση μέσα από το τόκεν
    // request.open('GET', "http://localhost:8080/teacher/questionList/"+idTeacher, true);
    // request.send();
    // //to check when the request is okay to leave
    // request.onreadystatechange = function () {
    //
    //     if (request.readyState == 4) {
    //         if (request.status == 200) {
    //
    //             let divElem = document.getElementById('questionList');
    //             let headersValues = ['Id','Image', 'Level', 'Option_1', 'Option_2','Option_3','Option_4',"Subject","Teacher","Script","Text"];
    //
    //             let table = document.createElement('table');
    //             let headersRows = document.createElement('tr');
    //
    //             //delete all the children because they may already exist in a table without updated info
    //             while (divElem.firstChild) {
    //                 divElem.removeChild(divElem.firstChild);
    //             }
    //
    //             const question = JSON.parse(request.responseText);
    //
    //             //if results is 0 means that the select returns 0 rows because it doesn't find books to database
    //             if (question.length == 0) {
    //
    //                 let errorTextNode = document.createTextNode("We don't have students in our database");
    //                 //add this child to divElem to print the message to user
    //                 divElem.appendChild(errorTextNode);
    //                 return false;
    //             }
    //
    //             //do the row and the cells for the headers of the table
    //             headersValues.forEach(headerText => {
    //                 let header = document.createElement('th');
    //                 let textNode = document.createTextNode(headerText);
    //                 header.appendChild(textNode);
    //                 headersRows.appendChild(header);
    //             });
    //
    //             table.appendChild(headersRows);
    //
    //             /*for each row that exists in the results (the rows that given by select)
    //                i do a foreach for each value that object book has to create the table to
    //                put all the values for each book that i have*/
    //
    //             /*if something went wrong with the database in the table appeared the wrong
    //                 message to inform the user*/
    //
    //             let row = document.createElement('tr');
    //
    //             // alert(Object.keys(students))
    //             Object.values(question).forEach(text => {
    //
    //                 let cell = document.createElement('td');
    //                 let textNode = document.createTextNode(text);
    //                 cell.appendChild(textNode);
    //                 //add cell by cell into the row to complite the info of one book that i have in the database
    //                 row.appendChild(cell);
    //
    //             })
    //
    //             //add row by row into the table
    //             table.appendChild(row);
    //
    //
    //
    //             //add the completed table
    //             divElem.appendChild(table);
    //         }
    //     }
    // };
// });

//document.getElementById("myQuestions").addEventListener("click", (event) => {

//
// document.getElementById("deleteQuestion").addEventListener("click", (event) => {
//
//     alert("deleteQuestion");
//     let xhr = new XMLHttpRequest();
//     let id = 1;
//     xhr.open("DELETE", "http://localhost:8080/teacher/question/"+id, true);
//     xhr.onload = function () {
//         let question = JSON.parse(xhr.responseText);
//         if (xhr.readyState == 4 && xhr.status == "200") {
//             console.table(question);
//         } else {
//             console.error(question);
//         }
//     }
//     xhr.send(null);
// });
//
// document.getElementById("putQuestion").addEventListener("click", (event) => {
//
//     // Update a user
//
//     var id = 1;
//
//     var questionNew = {};
//     questionNew.image = "maths";
//     questionNew.text = "toDo";
//     questionNew.option1 = "question_option1";
//     questionNew.option2 = "question_option2";
//     questionNew.option3 = "question_option3";
//     questionNew.option4 = "question_option4";
//     questionNew.script = "toDo";
//
//     var json = JSON.stringify(questionNew);
//
//     var xhr = new XMLHttpRequest();
//     xhr.open("PUT", "http://localhost:8080/teacher/question/"+id, true);
//     xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
//     xhr.onload = function () {
//         var text = JSON.parse(xhr.responseText);
//         if (xhr.readyState == 4 && xhr.status == "200") {
//             console.table(text);
//         } else {
//             console.error(text);
//         }
//     }
//     xhr.send(json);
//
// });
//
// document.getElementById("showStudents").addEventListener("click", (event) => {
//     var nameTeacher = "Artemis"
//     const request = new XMLHttpRequest();
//
//     //for asynchronised
//     request.open('GET', "http://localhost:8080/teacher/studentsList/"+nameTeacher, true);
//     request.send();
//     //to check when the request is okay to leave
//     request.onreadystatechange = function () {
//
//         if (request.readyState == 4) {
//             if (request.status == 200) {
//
//                 let divElem = document.getElementById('studentList');
//                 let headersValues = ['Id','Email', 'Phone Number', 'Pass', 'Name','Teacher'];
//
//                 let table = document.createElement('table');
//                 let headersRows = document.createElement('tr');
//
//                 //delete all the childrens besause maybe already exists a table with not updated info
//                 while (divElem.firstChild) {
//                     divElem.removeChild(divElem.firstChild);
//                 }
//
//                 const students = JSON.parse(request.responseText);
//
//                 //if results is 0 means that the select returns 0 rows because it doesn't find books to database
//                 if (students.length == 0) {
//
//                     let errorTextNode = document.createTextNode("We don't have students in our database");
//                     //add this child to divElem to print the message to user
//                     divElem.appendChild(errorTextNode);
//                     return false;
//                 }
//
//                 //do the row and the cells for the headers of the table
//                 headersValues.forEach(headerText => {
//                     let header = document.createElement('th');
//                     let textNode = document.createTextNode(headerText);
//                     header.appendChild(textNode);
//                     headersRows.appendChild(header);
//                 });
//
//                 table.appendChild(headersRows);
//
//                 /*for each row that exists in the results (the rows that given by select)
//                    i do a foreach for each value that object book has to create the table to
//                    put all the values for each book that i have*/
//
//                 /*if something went wrong with the database in the table appeared the wrong
//                     message to inform the user*/
//                 students.forEach(student => {
//                     let row = document.createElement('tr');
//
//                     Object.values(student).forEach(text => {
//                         let cell = document.createElement('td');
//                         let textNode = document.createTextNode(text);
//                         cell.appendChild(textNode);
//                         //add cell by cell into the row to complite the info of one book that i have in the database
//                         row.appendChild(cell);
//                     })
//
//                     //add row by row into the table
//                     table.appendChild(row);
//
//                 });
//
//                 //add the completed table
//                 divElem.appendChild(table);
//             }
//         }
//     };
// });
//
// document.getElementById("putStudent").addEventListener("click", (event) => {
//
//     // Update a user
//
//     var id = 1;
//
//     var studentNew = {};
//     studentNew.email = "maths@gmail.com";
//     studentNew.phoneNumber = 345677;
//     studentNew.password = "dretfgdgdf";//prepei na perasei prvta apo to security kanonika
//     studentNew.fullName = "Artemis";
//
//     var json = JSON.stringify(studentNew);
//
//     var xhr = new XMLHttpRequest();
//     xhr.open("PUT", "http://localhost:8080/teacher/student/"+id, true);
//     xhr.setRequestHeader('Content-type','application/json; charset=utf-8');
//     xhr.onload = function () {
//         var text = JSON.parse(xhr.responseText);
//         if (xhr.readyState == 4 && xhr.status == "200") {
//             console.table(text);
//         } else {
//             console.error(text);
//         }
//     }
//     xhr.send(json);
//
// });
//
// document.getElementById("deleteStudent").addEventListener("click", (event) => {
//
//     alert("deleteStudent");
//     let xhr = new XMLHttpRequest();
//     let id = 1;
//     xhr.open("DELETE", "http://localhost:8080/teacher/student/"+id, true);
//     xhr.onload = function () {
//         let question = JSON.parse(xhr.responseText);
//         if (xhr.readyState == 4 && xhr.status == "200") {
//             console.table(question);
//         } else {
//             console.error(question);
//         }
//     }
//     xhr.send(null);
// });

