
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

                }
            };

            xHttpProfile.open("GET", "user_profile?email=" + email, true);
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

