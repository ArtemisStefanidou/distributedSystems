
document.getElementById("showMyAnswers").addEventListener("click", (event) => {

    //Ψάχνω με βάση το email του μαθητή γιατι έχουμε πάρει ως παραδοχή ότι ο μαθητής ανήκει σε ένας καθηγητή Άρα δεν χρειάζομαι και το id του teacher για να αναζητήσω τον μαθητή στη βάση
    const accessToken = localStorage.getItem("accessToken");
    const email = localStorage.getItem("email");

    const request = new XMLHttpRequest();


    //for asynchronised
    request.open('GET', "http://localhost:8080/student/answerList/"+email, true);
    request.setRequestHeader("Authorization", accessToken);
    request.setRequestHeader('Content-type','application/json;');
    request.send();

    //to check when the request is okay to leave
    request.onreadystatechange = function () {

        if (request.readyState == 4) {
            if (request.status == 200) {

                let divElem = document.getElementById('listAnswers');
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

            }
        }
    };

});