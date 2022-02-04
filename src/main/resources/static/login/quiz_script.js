const startButton = document.getElementById('start-btn')
const nextButton = document.getElementById('next-btn')
const questionContainerElement = document.getElementById('question-container')
const questionElement = document.getElementById('question')
const answerButtonsElement= document.getElementById('answer-buttons')
let shuffledQuestions, currentQuestionIndex


document.getElementById("start-btn").addEventListener("click", (event) => {
    const accessToken = localStorage.getItem("accessToken");
    const email = localStorage.getItem("email");

    const request = new XMLHttpRequest();

    //for asynchronised
    request.open('GET', "http://localhost:8080/student/doQuiz/" + email, true);
    request.setRequestHeader("Authorization", accessToken);
    request.setRequestHeader('Content-type', 'application/json;');
    request.send();
    //to check when the request is okay to leave
    request.onreadystatechange = function () {

        if (request.readyState == 4) {
            if (request.status == 200) {


                const questionsJSON = JSON.parse(request.responseText);
                localStorage.setItem("questionsJSON",questionsJSON);
                startGame(questionsJSON);

            }
        }
    }
});


// startButton.addEventListener('click', startGame)

nextButton.addEventListener('click',()=>{
    currentQuestionIndex++
    setNextQuestion()
})


function startGame(questionsJSON){

    alert(questionsJSON);
    startButton.classList.add('hide')
    // shuffledQuestions = questions.sort(() => Math.random() - .5)
    shuffledQuestions = questionsJSON.sort(() => Math.random() - .5)
    currentQuestionIndex = 0
    questionContainerElement.classList.remove('hide')
    setNextQuestion()
}

function setNextQuestion(){
    resetState()
    showQuestion(shuffledQuestions[currentQuestionIndex])

}

function showQuestion(q){
    console.log(q.text);
    questionElement.innerText = q.text

    q.answers = q.answers.sort(() => Math.random() - .5)

    q.answers.forEach(answer=> {
        const button = document.createElement('button')
        button.innerText = answer.text
        button.classList.add('btn')

        if (answer.correct === 'true') {
            button.dataset.correct = answer.correct
        }
        button.addEventListener('click', selectAnswer)
        answerButtonsElement.appendChild(button)
    })
}
function selectAnswer(e){
    const selectedButton = e.target
    const correct = selectedButton.dataset.correct
    setStatusClass(document.body, correct)
    Array.from(answerButtonsElement.children).forEach(button => {
        setStatusClass(button,button.dataset.correct)
    })

    if (shuffledQuestions.length> currentQuestionIndex+1) {
        nextButton.classList.remove('hide')
    }else{
        startButton.innerText = 'Ολοκλήρωση Quiz'
        startButton.classList.remove('hide')
    }
}

function setStatusClass(element, correct){
    clearStatusClass(element)

    if (correct) {
        element.classList.add('correct')
    }else{
        element.classList.add('wrong')
    }
}

function clearStatusClass(element){
    element.classList.remove('correct')
    element.classList.remove('wrong')
}
function resetState(){
    clearStatusClass(document.body)
    nextButton.classList.add('hide')
    while( answerButtonsElement.firstChild){
        answerButtonsElement.removeChild(answerButtonsElement.firstChild)
    }
}


const questions=
    [
        {
            question: 'What is 2+2',
            image: "fwto1",
            answers: [
                {
                    text: '4',correct: true
                },

                {
                    text: '3',correct: false
                },

                {
                    text: '2',correct: false
                },

                {
                    text: '1',correct: false
                }
            ]
        }


        ,

        {

            question: 'What is 8+2',
            image: "fwto2",
            answers: [
                {
                    text: '10',correct: true
                },

                {
                    text: '3',correct: false
                },

                {
                    text: '2',correct: false
                },

                {
                    text: '1',correct: false
                }
            ]
        }

        ,

        {
            question: 'What is 18+2',
            image: "fwto3",
            answers: [
                {
                    text: '20',correct: true
                },
                {
                    text: '3',correct: false
                },
                {
                    text: '2',correct: false
                },
                {
                    text: '1',correct: false
                }
            ]
        }

        ,

        {


            question: 'Να υπολογίσετε την γωνία ω',
            image: "fwto4",
            answers: [
                {
                    text: 'ω=40',correct: true
                },

                {
                    text: 'ω=100',correct: false
                },

                {
                    text: 'ω=20',correct: false
                },

                {
                    text: 'ω=44',correct: false
                }


            ]

        }
    ]

