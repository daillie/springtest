const emailField = $("#inputEmail")[0];
const emailHelp = $("#emailHelp")[0];
let emailValid = false;
const VALID_CLASS = "is-valid";
const INVALID_CLASS = "is-invalid";
const buttonSignUp = $("#sign_up_btn")[0];


function processLogin(){
    buttonSignUp.onclick = function () {
        if (!emailValid) {
            alert("email is not valid or already used");
            return;
        }
        let user = {
            email: $("#inputEmail").prop("value"),
            password: $("#inputPassword").prop("value")
        };
        console.log(user);
        sendJsonData("/users/add", user,
            function (response) {
                console.log(response.status);
                console.log(response.body);
            });
    };


    emailField.oninput = function () {
        console.log("check")
        if (!emailField.checkValidity()) {
            setInvalidEmail();
            return;
        }

        let emailData = {
            email: emailField.value
        }

        sendData("/users/exists",
            emailData, function (response) {
                setInvalidEmail();
            }, function (response) {
                console.log("ERROR PROKNULA: " + response.status);
                if (response.status === 404) {
                    setValidEmail();
                }
            }, "GET");
    };
}


function sendJsonData(url, data, onSuccess, type = "POST") {
    sendData(url, JSON.stringify(data), onSuccess, type)
}

function sendData(url, data, onSuccess, onError = null, type = "POST") {
    console.log("sending data");
    $.ajax({
        url: url,
        type: type,
        data: data,
        contentType: "application/json; charset=utf-8",
        dataType: "json",

        success: onSuccess,
        error: onError === null ? function (xhr, status, error) {
            console.log(status);
            //console.log(xhr.responseText);
        } : onError
    });
    console.log("data sent");
}

function setInvalidEmail() {
    emailField.classList.remove(VALID_CLASS);
    emailField.classList.add(INVALID_CLASS);
    emailHelp.classList.add("invalid-feedback");
    emailHelp.value = "email invalid or already used";

    emailValid = false;
}

function setValidEmail() {
    emailField.classList.remove(INVALID_CLASS);
    emailField.classList.add(VALID_CLASS);
    emailHelp.classList.remove("invalid-feedback");
    emailHelp.value = "email is valid";

    emailValid = true
}