
var accessToken;
var refreshToken;
var role;
var email;

class loginCredentials{
    constructor(email, password) {
        this.email=email;
        this.password=password;
    }
}

document.getElementById("login").addEventListener("click",
    (event) => {


        const user = new loginCredentials('artemis@gmail.com', '5678');

        var formBody = [];
        for (var property in user) {
            var encodedKey = encodeURIComponent(property);
            var encodedValue = encodeURIComponent(user[property]);
            formBody.push(encodedKey + "=" + encodedValue);
        }
        formBody = formBody.join("&");

        const xhr = new XMLHttpRequest();
        xhr.open("POST", "http://localhost:8080/login", true);
        xhr.setRequestHeader("Content-Type"
            ,"application/x-www-form-urlencoded;charset=UTF-8");
        xhr.send(formBody);
        xhr.onreadystatechange = function () {
            if (xhr.readyState == 4) {
                if (xhr.status == 200) {
                    var response = JSON.parse(xhr.response);
                    accessToken='Bearer ' + response.access_token;
                    refreshToken='Bearer ' + response.refresh_token;
                    role=response.role_name ;
                    email=response.user_email_for_id;

                    window.location.href = "http://localhost:8080/login/"+ role+"/menu";

                }
            }
        };
});



/*const request = new XMLHttpRequest();

request.open('GET', "http://localhost:8080/" + role + "/menu", true);
request.setRequestHeader("Authorization"
    ,accessToken);
request.send();
request.onreadystatechange = function () {
    if (request.readyState == 4) {
        if (request.status == 200) {



        };
    };
};*/
