class loginCredentials{
    constructor(email, password) {
        this.email=email;
        this.password=password;
    }
}

document.getElementById("login").addEventListener("click",
    (event) => {

        var email = document.getElementById("emailUser").value;
        const password = document.getElementById("passwordUser").value;

        const user = new loginCredentials(email, password);

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
                    localStorage.setItem("accessToken", accessToken);

                    refreshToken='Bearer ' + response.refresh_token;
                    localStorage.setItem("refreshToken", refreshToken);

                    role=response.role_name ;
                    localStorage.setItem("role", role);

                    email=response.user_email_for_id;
                    localStorage.setItem("email", email);

                    window.location.href = "http://localhost:8080/login/"+ role+"/menu";



                }else{
                    alert("Incorrect input.Please check your email or password")
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