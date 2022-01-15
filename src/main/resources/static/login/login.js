
var accessToken;
var refreshToken;

class loginCredentials{
    constructor(email, password) {
        this.email=email;
        this.password=password;
    }
}

document.getElementById("login").addEventListener("click",
    (event) => {


        const user = new loginCredentials('bill@gmail.com', '1234');

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

                    alert(accessToken+'\n'+refreshToken);
                }
            }
        };



});