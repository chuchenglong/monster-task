function init() {

}

function submit() {
    var username = document.getElementById("username").value;
    var password = $("#password").val();

    var params = {};
    params.username = username;
    params.password = password;

    $x.ajax_post("login/checkLogin.do", params, success, failed);
}

function success(data) {
    $w.url("html/main/main.html", data);
}

function failed(data) {
    console.log(data.responseText);
}