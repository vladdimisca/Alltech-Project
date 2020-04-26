
window.onload = function () {
    let logged = JSON.parse(localStorage.getItem('logged'));

    if(logged)
        if(logged === 1) {
            let targetLink = document.querySelectorAll('nav a')[5];

            if(targetLink) {
                targetLink.setAttribute("href", "user_profile.jsp");
            }
        }

    let email = localStorage.getItem('email');

    let button = document.getElementById('samsungTV');
    if(button) {
        button.onclick = () => addToCart(button, email, '9');
    }

    let button1 = document.getElementById('lgTV');
    if(button1) {
        button1.onclick = () => addToCart(button1, email, '8');
    }

    let button2 = document.getElementById('curvedTV');
    if(button2) {
        button2.onclick = () => addToCart(button2, email, '7');
    }

    let button3 = document.getElementById('lenovoLaptop');
    if(button3) {
        button3.onclick = () => addToCart(button3, email, '6');
    }

    let button4 = document.getElementById('dellLaptop');
    if(button4) {
        button4.onclick = () => addToCart(button4, email, '5');
    }

    let button5 = document.getElementById('asusLaptop');
    if(button5) {
        button5.onclick = () => addToCart(button5, email, '4');
    }

    let button6 = document.getElementById('huaweiPhone');
    if(button6) {
        button6.onclick = () => addToCart(button6, email, '3');
    }

    let button7 = document.getElementById('applePhone');
    if(button7) {
        button7.onclick = () => addToCart(button7, email, '2');
    }

    let button8 = document.getElementById('a71Phone');
    if(button8) {
        button8.onclick = () => addToCart(button8, email, '1');
    }
};

function myFunction(imgs) {
    let expandImg = document.getElementById("expandedImg");
    expandImg.src = imgs.src;
    expandImg.parentElement.style.display = "block";
}

function autoGrow(oField) {
    if (oField.scrollHeight > oField.clientHeight) {
        oField.style.height = oField.scrollHeight + "px";
    }
}

function addToCart(button, email, productId) {
    let p = document.getElementById('message');

    if(p === null) {
        p = document.createElement('p');
        p.setAttribute('id', 'message');
        p.style.textAlign = 'center';
        p.style.fontWeight = 'bold';
        p.style.marginTop = "2%";
        p.style.fontSize = 'x-large';
    }

    p.style.display = 'block';

    if(email === null) {
        p.innerHTML = "You must be logged in";
    } else {
        const xHttpAdd = new XMLHttpRequest();

        xHttpAdd.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                const response = JSON.parse(this.response);

                if(response.hasOwnProperty('success')) {
                    p.innerHTML = response.success;
                } else {
                    if(response.hasOwnProperty('failure')) {
                        p.innerHTML = response.failure;
                    }
                }
            }
        };

        xHttpAdd.open("POST", "shopping_cart?email=" + email + "&productId=" + productId, true);
        xHttpAdd.send();
    }

    button.parentNode.insertBefore(p, button);

    setTimeout(function() {
        p.style.display = 'none';
    }, 3000);
}

