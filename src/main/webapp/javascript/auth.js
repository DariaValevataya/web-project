const form = document.getElementsByTagName("form")[0];
const firstname = document.getElementById("firstname");
const lastname = document.getElementById("lastname");
const login = document.getElementById("login");
const phone = document.getElementById("phone");
const email = document.getElementById("email");
const password = document.getElementById("password");
const password2 = document.getElementById("confirmPassword");

const email_regex = /^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9.]+$/;
var phone_regex = /^\+375 (44|29|33|25) [0-9]{3}-[0-9]{2}-[0-9]{2}$/;
const password_regex = /^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}$/;
const login_regex = /\w{6,15}/;
const firstname_regex = /^([A-Z]|[А-Я])([a-z]|[а-я]){1,15}$/;
const lastname_regex = /^([A-Z]|[А-Я])([a-z]|[а-я]){1,15}$/;
form.addEventListener('submit', (event) => {
    event.preventDefault();
    console.log('Form submitted');
    if (validation(firstname, firstname_regex) && validation(lastname, lastname_regex) && validation(phone, phone_regex) && validation(email, email_regex) && validation(login, login_regex) && validation(password, password_regex) && comparePasswords(password, password2)) {
        form.submit();
    }
});

function validation(input, regex) {
    let validateResult = true;
    removeError(input);
    if (input.value == "") {
        createError(input, 'Input value ')
        return false;
    }
    if (!regex.test(input.value)) {
        createError(input, 'Invalid value')
        validateResult = false;
    }
    return validateResult;
}

function comparePasswords(input1, input2) {
    let compareResult = true;
    removeError(input2);
    if (input1.value != input2.value) {
        createError(input2, 'Passwords are not equalse')
        compareResult = false;
    }
    return compareResult;
}

function createError(input, text) {
    const parent = input.parentElement;
    const errorLabel = document.createElement('label');
    errorLabel.classList.add('error-label');
    errorLabel.textContent = text;
    parent.classList.add('error');
    parent.append(errorLabel);

}

function removeError(input) {
    const parent = input.parentElement;
    while (parent.classList.contains('error')) {
        parent.querySelector('.error-label').remove();
        parent.classList.remove('error');
    }
}