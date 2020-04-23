
window.onload = function () {
    document.getElementById('registerForm').onsubmit = function (event) {
        event.preventDefault();

        let firstName = document.getElementById('firstName');
        let lastName = document.getElementById('lastName');
        let email = document.getElementById('email');
        let password = document.getElementById('password');

        const xHttpRegister = new XMLHttpRequest();

        xHttpRegister.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                const response = JSON.parse(this.response);
                let message = "You have been successfully registered!";

                if(response.message === message) {
                    window.location.replace('sign_in.jsp?message=' + message);
                } else {
                    if (!document.getElementById('message')) {
                        let message = document.createElement('h4');
                        message.setAttribute('id', 'message');
                        message.innerHTML = response.message;

                        password.parentNode.insertBefore(message, password.nextSibling);
                    }
                }
            }
        };

        xHttpRegister.open("POST", "register?firstName=" + firstName.value + "&lastName=" + lastName.value + "&email=" + email.value + "&password=" + password.value, true);
        xHttpRegister.send();
    };
};
