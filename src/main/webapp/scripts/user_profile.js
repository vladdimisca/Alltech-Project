
window.onload = function () {
    let logged = JSON.parse(localStorage.getItem('logged'));

    if(logged)
        if(logged === 1) {
            let targetLink = document.querySelectorAll('nav a')[5];

            if(targetLink) {
                targetLink.setAttribute("href", "user_profile.jsp");
            }

            let email = localStorage.getItem('email');
            const xHttpProfile = new XMLHttpRequest();

            xHttpProfile.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
                    const response = JSON.parse(this.response);

                    let archiveFirst = document.createElement('div');
                    archiveFirst.setAttribute ('class', 'archive');

                    let articleFirst = document.createElement('div');
                    articleFirst.setAttribute('class', 'article');

                    archiveFirst.appendChild(articleFirst);

                    let archiveLast = document.createElement('div');
                    archiveLast.setAttribute ('class', 'archive');

                    let articleLast = document.createElement('div');
                    articleLast.setAttribute('class', 'article');

                    archiveLast.appendChild(articleLast);

                    let archiveEmail = document.createElement('div');
                    archiveEmail.setAttribute ('class', 'archive');

                    let articleEmail = document.createElement('div');
                    articleEmail.setAttribute('class', 'article');

                    archiveEmail.appendChild(articleEmail);


                    let firstName = document.createElement("h4");
                    let changeFirst = document.createElement("button");
                    let lastName = document.createElement("h4");
                    let changeLast = document.createElement("button");
                    let em = document.createElement("h4");
                    let changeEmail = document.createElement("button");

                    changeFirst.setAttribute('class', 'button2');
                    changeFirst.innerText = "Change";

                    changeLast.setAttribute('class', 'button2');
                    changeLast.innerText = "Change";

                    changeEmail.setAttribute('class', 'button2');
                    changeEmail.innerText = "Change";


                    firstName.innerText = 'First Name: ' + response.firstName;
                    lastName.innerText = 'Last Name: ' + response.lastName;
                    em.innerText = 'Email: ' + response.email;

                    articleFirst.appendChild(firstName);
                    articleFirst.appendChild(changeFirst);

                    articleLast.appendChild(lastName);
                    articleLast.appendChild(changeLast)

                    articleEmail.appendChild(em);
                    articleEmail.appendChild(changeEmail)

                    let detailsDiv = document.getElementById('logged');
                    detailsDiv.appendChild(archiveFirst);
                    detailsDiv.appendChild(archiveLast);
                    detailsDiv.appendChild(archiveEmail);

                    changeFirst.onclick = () => changeFirstName(changeFirst, articleFirst, response.firstName, email);
                    changeLast.onclick = () => changeLastName(changeLast, articleLast, response.lastName, email);
                    changeEmail.onclick = () => changeEm(changeEmail, articleEmail, email);
                }
            };

            xHttpProfile.open("GET", "user_account?email=" + email, true);
            xHttpProfile.send();

        }
};

function login(email) {
    localStorage.setItem('logged', '1');
    localStorage.setItem('email', email);
}

function logout() {
    localStorage.setItem('logged', '0');
    localStorage.removeItem('email');
    location.replace("sign_in.jsp");
}

function deletionPage() {
    location.replace("deletion_page.jsp");
}

function changePassword() {
    location.replace("change_password.jsp");
}

function changeFirstName(changeFirst, articleFirst, textName, email) {
    changeFirst.onclick = null;

    const xHttpUpdate = new XMLHttpRequest();

    let text = articleFirst.firstChild;
    let button = articleFirst.childNodes[1];
    articleFirst.removeChild(text);

    let firstName = document.createElement('h4');
    firstName.innerText = "First name:"

    let input = document.createElement('input');
    input.value = textName;
    input.style.marginTop = "3px";
    input.style.marginLeft = "5px";
    input.style.fontSize = "larger";

    button.innerText = "Submit";

    articleFirst.insertBefore(firstName, button);
    articleFirst.insertBefore(input, button);

    changeFirst.onclick = function() {
        let text = input.value;

        articleFirst.removeChild(firstName);
        articleFirst.removeChild(input);

        let newFirstName = document.createElement('h4');

        newFirstName.innerText = 'First name: ' + text;

        button.innerText = "Change";

        articleFirst.insertBefore(newFirstName, button);

        xHttpUpdate.open("POST", "user_account?type=" + "2" + "&email=" + email + "&firstName=" + text, true);
        xHttpUpdate.send();

        changeFirst.onclick = () => changeFirstName(changeFirst, articleFirst, text);
    };
}


function changeLastName(changeLast, articleLast, textName, email) {
    changeLast.onclick = null;

    const xHttpUpdate = new XMLHttpRequest();

    let text = articleLast.firstChild;
    let button = articleLast.childNodes[1];
    articleLast.removeChild(text);

    let lastName = document.createElement('h4');
    lastName.innerText = "Last name:"

    let input = document.createElement('input');
    input.value = textName;
    input.style.marginTop = "3px";
    input.style.marginLeft = "5px";
    input.style.fontSize = "larger";

    button.innerText = "Submit";

    articleLast.insertBefore(lastName, button);
    articleLast.insertBefore(input, button);

    changeLast.onclick = function() {
        let text = input.value;

        articleLast.removeChild(lastName);
        articleLast.removeChild(input);

        let newLastName = document.createElement('h4');

        newLastName.innerText = 'Last name: ' + text;

        button.innerText = "Change";

        articleLast.insertBefore(newLastName, button);

        xHttpUpdate.open("POST", "user_account?type=" + "3" + "&email=" + email + "&lastName=" + text, true);
        xHttpUpdate.send();

        changeLast.onclick = () => changeLastName(changeLast, articleLast, text);
    };
}


function changeEm (changeEmail, articleEmail, oldEmail) {
    changeEmail.onclick = null;

    const xHttpUpdate = new XMLHttpRequest();

    let text = articleEmail.firstChild;
    let button = articleEmail.childNodes[1];
    articleEmail.removeChild(text);

    let email = document.createElement('h4');
    email.innerText = "Email:"

    let input = document.createElement('input');
    input.value = oldEmail;
    input.style.marginTop = "3px";
    input.style.marginLeft = "5px";
    input.style.fontSize = "larger";
    input.pattern = "^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$";
    input.required = true;

    button.innerText = "Submit";

    articleEmail.insertBefore(email, button);
    articleEmail.insertBefore(input, button);

    changeEmail.onclick = function() {
        let text = input.value;

        localStorage.setItem("email", text);

        xHttpUpdate.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                const response = JSON.parse(this.response);

                if (text === oldEmail) {
                    if (document.getElementById('message')) {
                        let message = document.getElementById('message');
                        message.parentNode.removeChild(message);
                    }
                    articleEmail.removeChild(email);
                    articleEmail.removeChild(input);

                    let newEmail = document.createElement('h4');

                    newEmail.innerText = 'Email: ' + text;

                    button.innerText = "Change";

                    articleEmail.insertBefore(newEmail, button);

                    changeEmail.onclick = () => changeEm(changeEmail, articleEmail, text);
                }
                else
                if(response.hasOwnProperty('success')) {
                    if (document.getElementById('message')) {
                        let message = document.getElementById('message');
                        message.parentNode.removeChild(message);
                    }
                    articleEmail.removeChild(email);
                    articleEmail.removeChild(input);

                    let newEmail = document.createElement('h4');

                    newEmail.innerText = 'Email: ' + text;

                    button.innerText = "Change";

                    articleEmail.insertBefore(newEmail, button);

                    changeEmail.onclick = () => changeEm(changeEmail, articleEmail, text);
                } else {
                    if (!document.getElementById('message')) {
                        let detailsDiv = document.getElementById('logged');
                        let message = document.createElement("h5");
                        message.setAttribute('id', 'message');
                        message.innerText = response.failure;
                        detailsDiv.appendChild(message);
                    }
                }
            }
        };

        xHttpUpdate.open("POST", "user_account?type=" + "4" + "&email=" + oldEmail + "&newEmail=" + text, true);
        xHttpUpdate.send();
    };
}

