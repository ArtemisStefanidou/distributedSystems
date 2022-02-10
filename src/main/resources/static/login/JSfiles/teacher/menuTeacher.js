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