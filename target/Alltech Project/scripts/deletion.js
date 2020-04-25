window.onload = function () {
    let logged = JSON.parse(localStorage.getItem('logged'));

    if (logged)
        if (logged === 1) {
            let targetLink = document.querySelectorAll('nav a')[5];

            if(targetLink) {
                targetLink.setAttribute("href", "user_profile.jsp");
            }

            let email = localStorage.getItem('email');

            let actualEmail = document.getElementById('email');
            actualEmail.innerHTML += email;

            document.getElementById('deletionForm').onsubmit = function (event) {
                event.preventDefault();

                let password = document.querySelector('input[type=password]');
                const xHttpDelete = new XMLHttpRequest();

                xHttpDelete.onreadystatechange = function () {
                    if (this.readyState === 4 && this.status === 200) {
                        const response = JSON.parse(this.response);

                        if (response.hasOwnProperty('success')) {
                            removeAccount();
                        } else {
                            if (!document.getElementById('message')) {
                                let message = document.createElement('h4');
                                message.setAttribute('id', 'message');
                                message.innerHTML = response.failure;

                                password.parentNode.insertBefore(message, password.nextSibling);
                            } else {
                                document.getElementById('message').innerText = response.failure;
                            }
                        }
                    }
                };

                xHttpDelete.open("POST", "deletion_page?email=" + email + "&password=" + password.value, true);
                xHttpDelete.send();
            }
        }
};


function removeAccount() {
    localStorage.setItem('logged', '0');
    localStorage.removeItem('email');
    location.replace("register.jsp");
}
