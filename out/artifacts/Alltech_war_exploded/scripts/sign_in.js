
window.onload = function () {
    document.getElementById('loginForm').onsubmit = function (event) {
        event.preventDefault();

        let email = document.getElementById('email');
        let password = document.getElementById('password');

        const xHttpLogin = new XMLHttpRequest();

        xHttpLogin.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                const response = JSON.parse(this.response);

                if(response.hasOwnProperty('success')) {
                    window.location.replace('user_profile.jsp?email=' + email.value);
                } else {
                    window.location.replace('sign_in.jsp?message=' + response.failure);
                }
            }
        };

        xHttpLogin.open("POST", "sign_in?email=" + email.value + "&password=" + password.value, true);
        xHttpLogin.send();
    };
};