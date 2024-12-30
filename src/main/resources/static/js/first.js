console.log("hello,world!")
//document.getElementById('forma').addEventListener("submit", checkAuth);


function checkAuth(event){
    event.preventDefault();
    var elem = document.getElementById('forma');
    var name = elem.username.value;
    var pass = elem.password.value;
    var mail = elem.email.value;
    var url = false;
    var fail = "";
    if(document.location.href.split("register.html").length > 1) url = true;
    if(url) var apass = elem.accpassword.value;

    // if(url){if(pass != apass) fail = "Пароли отличаются";}
    if(url){if(pass != apass) fail = "Пароли отличаются";}
    if(name == "" || pass == "" || mail == "") fail = "Заполните все поля";
    else if(pass.split("&").length > 1) fail = "Некорректный пароль";
    if(fail != "") document.getElementById('error').innerHTML = fail;
    else{
        window.location = 'index.html';
    }
}