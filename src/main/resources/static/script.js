
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




document.getElementById("colSubmit").addEventListener("click", (event) => {

    const questionPost = new QuestionPost('image', 'test', 'opt1', 'opt2', 'opt3', 'opt4' , 'script');

    const xhr = new XMLHttpRequest();
    xhr.open("POST", "http://localhost:8080/createQuestion", true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send(JSON.stringify(questionPost));
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            if (xhr.status == 200) {

            }
        }
    };
});














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