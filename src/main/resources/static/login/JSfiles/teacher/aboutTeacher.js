

document.getElementById("infoStudent").addEventListener("click", (event) => {
    document.getElementById("label").classList.remove('hide');
    document.getElementById("emailStudent").classList.remove('hide');
    document.getElementById("search").classList.remove('hide');
});

document.getElementById("deleteStudent").addEventListener("click", (event) => {
    document.getElementById("labelDelete").classList.remove('hide');
    document.getElementById("idStudent").classList.remove('hide');
    document.getElementById("delete").classList.remove('hide');
});

document.getElementById("deleteQuestion").addEventListener("click", (event) => {
    document.getElementById("labelDeleteQuestion").classList.remove('hide');
    document.getElementById("idQuestion").classList.remove('hide');
    document.getElementById("deleteQ").classList.remove('hide');
});
document.getElementById("search").addEventListener("click", (event) => {

    const accessToken = localStorage.getItem("accessToken");
    const email = localStorage.getItem("email");

    //Ψάχνω με βάση το email του μαθητή γιατι έχουμε πάρει ως παραδοχή ότι ο μαθητής ανήκει σε ένας καθηγητή Άρα δεν χρειάζομαι και το id του teacher για να αναζητήσω τον μαθητή στη βάση
    const emailStudent = document.getElementById('emailStudent').value;

    const request = new XMLHttpRequest();

    //for asynchronised
    request.open('GET', "http://localhost:8080/teacher/studentInfo/"+emailStudent, true);
    request.setRequestHeader("Authorization", accessToken);
    request.setRequestHeader('Content-type','application/json;');
    request.send();
    //to check when the request is okay to leave
    request.onreadystatechange = function () {

        if (request.readyState == 4) {
            if (request.status == 200) {

                let divElem = document.getElementById('infoList');
                let headersValues = ['Id','Βαθμός','Φωτογραφία', 'Επίπεδο','Επιλογή 1η','Επιλογή 2η','Επιλογή 3η','Επιλογή 4η','Κείμενο','Script','Δάσκαλος'];

                let table = document.createElement('table');
                let headersRows = document.createElement('tr');

                //delete all the childrens besause maybe already exists a table with not updated info
                while (divElem.firstChild) {
                    divElem.removeChild(divElem.firstChild);
                }

                const questions = JSON.parse(request.responseText);

                //if results is 0 means that the select returns 0 rows because it doesn't find books to database
                if (questions.length == 0) {

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
                questions.forEach(question => {

                    var i=0;
                    let row = document.createElement('tr');
                    var values = [];
                    var values = Object.values(question);
                    for (i in values){
                        if(i == 3 ){
                            var j=0;
                            var questionValues = [];
                            questionValues = Object.values(values[i]);

                            for (j in questionValues){
                                let cell = document.createElement('td');
                                let textNode = document.createTextNode(questionValues[j]);
                                cell.appendChild(textNode);
                                //add cell by cell into the row to complete the info of one book that i have in the database
                                row.appendChild(cell);
                            }

                        }else if(i!=2 && i!=1) {
                            // if(i != 3 && i!=5 && i!=6){
                            let cell = document.createElement('td');
                            let textNode = document.createTextNode(values[i]);
                            cell.appendChild(textNode);
                            //add cell by cell into the row to complete the info of one book that i have in the database
                            row.appendChild(cell);
                            // }
                        }
                    }

                    //add row by row into the table
                    table.appendChild(row);


                });

                //add the completed table
                divElem.appendChild(table);

                let br = document.createElement('br');
                divElem.appendChild(br);

                // document.getElementById("deleteQuestion").classList.remove('hide');
                // document.getElementById("updateQuestion").classList.remove('hide');
                // document.getElementById("infoQuestion").classList.remove('hide');

            }
        }
    };

});


document.getElementById("search").addEventListener("click", (event) => {

    const accessToken = localStorage.getItem("accessToken");
    const email = localStorage.getItem("email");

    //Ψάχνω με βάση το email του μαθητή γιατι έχουμε πάρει ως παραδοχή ότι ο μαθητής ανήκει σε ένας καθηγητή Άρα δεν χρειάζομαι και το id του teacher για να αναζητήσω τον μαθητή στη βάση
    const emailStudent = document.getElementById('emailStudent').value;

    const request = new XMLHttpRequest();

    //for asynchronised
    request.open('GET', "http://localhost:8080/teacher/studentInfo/"+emailStudent, true);
    request.setRequestHeader("Authorization", accessToken);
    request.setRequestHeader('Content-type','application/json;');
    request.send();
    //to check when the request is okay to leave
    request.onreadystatechange = function () {

        if (request.readyState == 4) {
            if (request.status == 200) {

                let divElem = document.getElementById('infoList');
                let headersValues = ['Βαθμός','Κείμενο','Φωτογραφία', 'Επιλογή 1η','Επιλογή 2η','Επιλογή 3η','Επιλογή 4η'];

                let table = document.createElement('table');
                let headersRows = document.createElement('tr');

                //delete all the childrens besause maybe already exists a table with not updated info
                while (divElem.firstChild) {
                    divElem.removeChild(divElem.firstChild);
                }

                const questions = JSON.parse(request.responseText);

                //if results is 0 means that the select returns 0 rows because it doesn't find books to database
                if (questions.length == 0) {

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
                questions.forEach(question => {

                    var i=0;
                    let row = document.createElement('tr');
                    var values = [];
                    var values = Object.values(question);
                    for (i in values){
                        if(i == 3 ){
                            var j=0;
                            var questionValues = [];
                            questionValues = Object.values(values[i]);

                            for (j in questionValues){
                                if(j!=0 && j!=1 && j!=7 ) {
                                    let cell = document.createElement('td');
                                    let textNode = document.createTextNode(questionValues[j]);
                                    cell.appendChild(textNode);
                                    //add cell by cell into the row to complete the info of one book that i have in the database
                                    row.appendChild(cell);
                                }
                            }

                        }else if(i!=0 && i!=2) {
                            // if(i != 3 && i!=5 && i!=6){
                            let cell = document.createElement('td');
                            let textNode = document.createTextNode(values[i]);
                            cell.appendChild(textNode);
                            //add cell by cell into the row to complete the info of one book that i have in the database
                            row.appendChild(cell);
                            // }
                        }
                    }

                    //add row by row into the table
                    table.appendChild(row);


                });

                //add the completed table
                divElem.appendChild(table);

                let br = document.createElement('br');
                divElem.appendChild(br);

                // document.getElementById("deleteQuestion").classList.remove('hide');
                // document.getElementById("updateQuestion").classList.remove('hide');
                // document.getElementById("infoQuestion").classList.remove('hide');

            }
        }
    };

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

document.getElementById("showStudents").addEventListener("click", (event) => {
    const accessToken = localStorage.getItem("accessToken");
    const email = localStorage.getItem("email");

    var emailTeacher = email
    const request = new XMLHttpRequest();

    //for asynchronised
    request.open('GET', "http://localhost:8080/teacher/studentsList/"+emailTeacher, true);
    request.setRequestHeader("Authorization", accessToken);
    request.setRequestHeader('Content-type','application/json;');
    request.send();
    //to check when the request is okay to leave
    request.onreadystatechange = function () {

        if (request.readyState == 4) {
            if (request.status == 200) {

                let divElem = document.getElementById('studentList');
                let headersValues = ['Id','Email', 'Τηλέφωνο','Όνομα'];

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

                        var i=0;
                        let row = document.createElement('tr');
                        var values = [];
                        var values = Object.values(student);
                        for (i in values){
                            if(i != 3 && i!=5 && i!=6){
                                let cell = document.createElement('td');
                                let textNode = document.createTextNode(values[i]);
                                cell.appendChild(textNode);
                                //add cell by cell into the row to complete the info of one book that i have in the database
                                row.appendChild(cell);
                            }
                        }

                        //add row by row into the table
                        table.appendChild(row);


                });

                //add the completed table
                divElem.appendChild(table);

                let br = document.createElement('br');
                divElem.appendChild(br);

                document.getElementById("deleteStudent").classList.remove('hide');
                document.getElementById("updateStudent").classList.remove('hide');
                document.getElementById("infoStudent").classList.remove('hide');

            }
        }
    };
});

document.getElementById("delete").addEventListener("click", (event) => {

    const accessToken = localStorage.getItem("accessToken");
    const email = localStorage.getItem("email");

    const idStudent = document.getElementById("idStudent").value;
    alert("deleteStudent"+idStudent);
    let xhr = new XMLHttpRequest();
    xhr.open("DELETE", "http://localhost:8080/teacher/student/"+idStudent, true);
    xhr.setRequestHeader("Authorization", accessToken);
    xhr.setRequestHeader('Content-type','application/json;');
    xhr.onload = function () {
        let question = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {
            console.table(question);
        } else {
            // console.error(question);
        }
    }
    xhr.send(null);
});


document.getElementById("deleteQ").addEventListener("click", (event) => {

    const accessToken = localStorage.getItem("accessToken");
    const email = localStorage.getItem("email");

    const idQuestion = document.getElementById("idQuestion").value;
    alert("deleteStudent"+idQuestion);
    let xhr = new XMLHttpRequest();
    xhr.open("DELETE", "http://localhost:8080/teacher/question/"+idQuestion, true);
    xhr.setRequestHeader("Authorization", accessToken);
    xhr.setRequestHeader('Content-type','application/json;');
    xhr.onload = function () {
        let question = JSON.parse(xhr.responseText);
        if (xhr.readyState == 4 && xhr.status == "200") {
            console.table(question);
        } else {
            alert("Something Went Wrong with the Server");
        }
    }
    xhr.send(null);
});

document.getElementById("myQuestions").addEventListener("click", (event) => {

    const accessToken = localStorage.getItem("accessToken");
    const email = localStorage.getItem("email");

    const request = new XMLHttpRequest();

    //for asynchronised
    request.open('GET', "http://localhost:8080/teacher/questionList/"+email, true);
    request.setRequestHeader("Authorization", accessToken);
    request.setRequestHeader('Content-type','application/json;');
    request.send();
    //to check when the request is okay to leave
    request.onreadystatechange = function () {

        if (request.readyState == 4) {
            if (request.status == 200) {

                let divElem = document.getElementById('questionList');
                let headersValues = ['Id','Φωτογραφία','Κείμενο','Επιλογή 1η','Επιλογή 2η','Επιλογή 3η','Επιλογή 4η'];

                let table = document.createElement('table');
                let headersRows = document.createElement('tr');

                //delete all the childrens besause maybe already exists a table with not updated info
                while (divElem.firstChild) {
                    divElem.removeChild(divElem.firstChild);
                }

                let questions = [];
                questions = JSON.parse(request.responseText);

                //if results is 0 means that the select returns 0 rows because it doesn't find books to database
                if (questions.length === 0) {

                    let errorTextNode = document.createTextNode("We don't have questions in our database");
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

                questions.forEach(question => {

                    var i=0;
                    let row = document.createElement('tr');
                    var values = [];
                    var values = Object.values(question);
                    for (i in values){
                        if( i != 7){
                            let cell = document.createElement('td');
                            let textNode = document.createTextNode(values[i]);
                            cell.appendChild(textNode);
                            //add cell by cell into the row to complete the info of one question that we have in the database
                            row.appendChild(cell);
                        }
                    }

                    //add row by row into the table
                    table.appendChild(row);


                });































                // questions.forEach(question => {
                //
                //     var i=0;
                //     let row = document.createElement('tr');
                //     var values = [];
                //     var values = Object.values(question);
                //     for (i in values){
                //         if(i == 3 ){
                //             var j=0;
                //             var questionValues = [];
                //             questionValues = Object.values(values[i]);
                //
                //             for (j in questionValues){
                //                 let cell = document.createElement('td');
                //                 let textNode = document.createTextNode(questionValues[j]);
                //                 cell.appendChild(textNode);
                //                 //add cell by cell into the row to complete the info of one book that i have in the database
                //                 row.appendChild(cell);
                //             }
                //
                //         }else if(i!=2 && i!=1) {
                //
                //             let cell = document.createElement('td');
                //             let textNode = document.createTextNode(values[i]);
                //             cell.appendChild(textNode);
                //             //add cell by cell into the row to complete the info of one book that i have in the database
                //             row.appendChild(cell);
                //
                //         }
                //     }
                //
                //     //add row by row into the table
                //     table.appendChild(row);
                //
                //
                // });

                //add the completed table
                divElem.appendChild(table);

                let br = document.createElement('br');
                divElem.appendChild(br);

                document.getElementById("deleteQuestion").classList.remove('hide');
                document.getElementById("updateQuestion").classList.remove('hide');

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
