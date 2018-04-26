var loginChecked = false;
var passwordChecked = false;

var minLoginLength = 5;
var maxLoginLength = 10;
var minPasswordLength = 6;
var maxPasswordLength = 10;

var loginRegEx = /\w/;
var passwordRegEx = /\d\w/;

var loginName = "login";
var passwordName = "password";
var submitId = "loginButton";

var loginText = document.getElementsByName(loginName);
var passwordText = document.getElementsByName(passwordName);
var submitButton = document.getElementById(submitId);

function checkForm(form) {
    if(document.getElementsByName(loginName) < minLoginLength
        || document.getElementsByName(loginName) > maxLoginLength){
        document.getElementsByName(loginName).innerText = 'Error';
        return false;
    }
};
