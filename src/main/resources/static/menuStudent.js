document.getElementById("showMyAnswers").addEventListener("click", (event) => {
    const request = new XMLHttpRequest();

    //for asynchronised
    request.open('GET', "http://localhost:8080/student/answerList", true);
    request.send();
    //to check when the request is okay to leave
    request.onreadystatechange = function () {

        if (request.readyState == 4) {
            if (request.status == 200) {

                let divElem = document.getElementById('listAnswers');
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