window.addEventListener('load',(event)=>{
    document.getElementById('doquiz').addEventListener('click',(event)=>{

        alert("do quiz alert")
        //xml request , add a something
        const xhr = new XMLHttpRequest();
        xhr.open('POST','http://localhost:8080/quiz',true);
        xhr.setRequestHeader('Content-Type','application/json');
        xhr.send(JSON.stringify(something)); //use stringify to convert object to string
        xhr.onreadystatechange = function(){
            //so if i have a http response and i have a usefull result to take
            if(xhr.readyState == 4 && xhr.status == 200){

            }
        };
    });

    document.getElementById('myGrades').addEventListener('click',(event)=>{
        alert("show my grades  alert")

        //XML request object
        const xhr = new XMLHttpRequest();
        xhr.open('GET',`http://localhost:8080/myGrades`,true);
        xhr.send();

        xhr.onreadystatechange =function (){

        };
    });


    document.getElementById('do').addEventListener('click',(event)=>{

    });


});