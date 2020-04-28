window.onload = function () {
    let logged = JSON.parse(localStorage.getItem('logged'));

    if(logged)
        if(logged === 1) {
            let targetLink = document.querySelectorAll('nav a')[5];

            if(targetLink) {
                targetLink.setAttribute("href", "user_profile.jsp");
            }

            let email = localStorage.getItem('email');

            let changePass = document.getElementById('changeForm')

            if(changePass){
                changePass.onsubmit = (event) => updatePassword(event, email);
            }

        }
}


function updatePassword (event, email) {
    event.preventDefault()
    let oldPassword = document.querySelector('input[id=oldpsw]');
    let newPassword = document.querySelector('input[id=newpsw]');

    const xHttpUpdate = new XMLHttpRequest();

    console.log(oldPassword.value);
    console.log(newPassword.value);

    xHttpUpdate.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const response = JSON.parse(this.response);

            if (response.hasOwnProperty('success')) {
                localStorage.setItem('logged', '0');
                window.location.replace('sign_in.jsp?message=' + response.success);

            } else {
                let message = document.createElement('h4');
                newPassword.parentNode.insertBefore(message, newPassword.nextSibling);
                message.innerHTML = response.failure;
                }
            }
    };

    xHttpUpdate.open("POST", "user_account?type=" + "1" + "&email=" + email + "&oldPassword=" + oldPassword.value + "&newPassword=" + newPassword.value, true);
    xHttpUpdate.send();
}