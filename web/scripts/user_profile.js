
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
                    let firstName = document.createElement("h4");
                    let lastName = document.createElement("h4");
                    let em = document.createElement("h4");

                    firstName.innerText = 'First Name: ' + response.firstName;
                    lastName.innerText = 'Last Name: ' + response.lastName;
                    em.innerText = 'Email: ' + response.email;

                    let detailsDiv = document.getElementById('logged');
                    detailsDiv.appendChild(firstName);
                    detailsDiv.appendChild(lastName);
                    detailsDiv.appendChild(em);
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

