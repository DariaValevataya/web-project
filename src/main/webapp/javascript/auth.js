const form = document.getElementsByTagName("form")[0];
const firstname = document.getElementById("firstname");
const lastname = document.getElementById("lastname");
const login = document.getElementById("login");
const phone = document.getElementById("phone");
const email = document.getElementById("email");
const password = document.getElementById("password");
const email_regex = /[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9.]+$/;
const phone_regex = /\+375 (44|29|33|25) [0-9]{3}-[0-9]{2}-[0-9]{2}/;
const password_regex = /(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z!@#$%^&*]{6,}/;
const login_regex = /^\w{6,10}$/;
const firstname_regex = /^([A-Z]|[А-Я])([a-z]|[а-я]){1,15}$/;
const lastname_regex = /^([A-Z]|[А-Я])([a-z]|[а-я]){1,15}$/;

form.addEventListener('submit', (event) => {
    event.preventDefault();

    if ( validation(phone, phone_regex) === true && validation(email, email_regex) === true && validation(password, password_regex) === true && validation(firstname, firstname_regex) === true && validation(lastname, lastname_regex) === true && validation(login, login_regex) === true) {
        console.log('ok')
    }
});

function validation(input, regex) {
    let validateResult = true;
    removeError(input);
    if (input.value === "") {
        createError(input, 'Input value ')
        validateResult = false;
    }
    if (!regex.test(String(input))) {
        createError(input, 'Invalid value')
        validateResult = false;
    }
    return validateResult;
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
    if (parent.classList.contains('error')) {
        parent.querySelector('.error-label').remove();
        parent.classList.remove('error');
    }
}