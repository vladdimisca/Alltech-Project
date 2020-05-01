
window.onload = function() {
    let logged = JSON.parse(localStorage.getItem('logged'));

    if(logged)
        if(logged === 1) {
            let targetLink = document.querySelectorAll('nav a')[5];

            if(targetLink) {
                targetLink.setAttribute("href", "user_profile.jsp");
            }
        }

    let email = localStorage.getItem('email');
    let commentForm = document.getElementById("commentForm");

    let button = document.getElementById('samsungTV');
    if(button) {
        checkStock(9);
        getComments(9);

        commentForm.onsubmit = function(event) {
            event.preventDefault();

            addComment(email,'9');
        }

        button.onclick = () => addToCart(button, email, '9');
    }

    let button1 = document.getElementById('lgTV');
    if(button1) {
        checkStock(8);
        getComments(8);

        commentForm.onsubmit = function(event) {
            event.preventDefault();

            addComment(email,'8');
        }

        button1.onclick = () => addToCart(button1, email, '8');
    }

    let button2 = document.getElementById('curvedTV');
    if(button2) {
        checkStock(7);
        getComments(7);

        commentForm.onsubmit = function(event) {
            event.preventDefault();

            addComment(email,'7');
        }

        button2.onclick = () => addToCart(button2, email, '7');
    }

    let button3 = document.getElementById('lenovoLaptop');
    if(button3) {
        checkStock(6);
        getComments(6);

        commentForm.onsubmit = function(event) {
            event.preventDefault();

            addComment(email,'6');
        }

        button3.onclick = () => addToCart(button3, email, '6');
    }

    let button4 = document.getElementById('dellLaptop');
    if(button4) {
        checkStock(5);
        getComments(5);

        commentForm.onsubmit = function(event) {
            event.preventDefault();

            addComment(email,'5');
        }

        button4.onclick = () => addToCart(button4, email, '5');
    }

    let button5 = document.getElementById('asusLaptop');
    if(button5) {
        checkStock(4);
        getComments(4);

        commentForm.onsubmit = function(event) {
            event.preventDefault();

            addComment(email,'4');
        }

        button5.onclick = () => addToCart(button5, email, '4');
    }

    let button6 = document.getElementById('huaweiPhone');
    if(button6) {
        checkStock(3);
        getComments(3);

        commentForm.onsubmit = function(event) {
            event.preventDefault();

            addComment(email,'3');
        }

        button6.onclick = () => addToCart(button6, email, '3');
    }

    let button7 = document.getElementById('applePhone');
    if(button7) {
        checkStock(2);
        getComments(2);

        commentForm.onsubmit = function(event) {
            event.preventDefault();

            addComment(email,'2');
        }

        button7.onclick = () => addToCart(button7, email, '2');
    }

    let button8 = document.getElementById('a71Phone');
    if(button8) {
        checkStock(1);
        getComments(1);

        commentForm.onsubmit = function(event) {
            event.preventDefault();

            addComment(email,'1');
        }

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
    let d;

    if(p === null) {
        p = document.createElement('p');
        p.setAttribute('id', 'message');

        d = document.createElement('div');
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

    checkStock(productId);

    d.appendChild(p);
    button.parentNode.insertBefore(d, button.nextSibling);

    setTimeout(function() {

        d.setAttribute('id', 'messages--delete');

        p.addEventListener('transitionend', function() {
             p.parentNode.removeChild(p);
        });
    }, 2000);
}

function checkStock(productId) {
    let p = document.getElementById('stock');

    const xHttpStock = new XMLHttpRequest();

    xHttpStock.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const response = JSON.parse(this.response);

            if (response.hasOwnProperty('stock')) {
                p.innerHTML = response.stock;
            }
        }
    }

    xHttpStock.open("GET", "products?productId=" + productId, true);
    xHttpStock.send();
}

function addComment(email, productId) {
    let p = document.getElementById("message");

    if(p === null) {
        p = document.createElement('p');

        p.setAttribute("id", "message");
    }

    let today = new Date();

    let month = (today.getMonth() + 1) < 10 ? "0" : "";
    month += today.getMonth() + 1;

    let day = today.getDate() < 10 ? "0" : "";
    day += today.getDate();

    let hour = today.getHours() < 10 ? "0" : "";
    hour += today.getHours();

    let minutes = today.getMinutes() < 10 ? "0" : "";
    minutes += today.getMinutes();

    let seconds = today.getSeconds() < 10 ? "0" : "";
    seconds += today.getSeconds();

    let dateTime = today.getFullYear() + "/" + month + "/" + day + " " + hour + ":" + minutes + ":" + seconds;

    const xHttpAdd = new XMLHttpRequest();
    let message = document.getElementById("styledTextArea");

    if(email === null) {
        p.innerHTML = "You must me logged in";
    } else {
        xHttpAdd.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                const response = JSON.parse(this.response);

                let paragraph = document.getElementById("commentP");

                if (response.hasOwnProperty('success')) {
                    if(paragraph !== null){
                        paragraph.style.display = 'none';
                    }

                    p.innerHTML = response.success;

                    let comment = document.createElement('p');
                    comment.innerHTML = email + " " + dateTime + " " + message.value;

                    document.getElementById("commentSection").appendChild(comment);

                    message.value = "";
                }
            }
        }
    }

    xHttpAdd.open("POST", "comments?email=" + email + "&productId=" + productId + "&date=" + dateTime +"&message=" + message.value, true);
    xHttpAdd.send();

    let submitButton = document.getElementById('styledInput');

    submitButton.parentNode.insertBefore(p, submitButton);
}

function getComments(productId) {
    const xHttpGet = new XMLHttpRequest();

    let paragraph = document.getElementById("commentP");

    xHttpGet.onreadystatechange = function() {
        if (this.readyState === 4 && this.status === 200) {
            const response = JSON.parse(this.response);

            response.forEach(function(comment) {
                if(paragraph !== null){
                   paragraph.style.display = 'none';
                }

                let p = document.createElement('p');

                p.innerHTML = comment['email'] + " " + comment['date'] + " " + comment['message'];

                document.getElementById("commentSection").appendChild(p);
            });
        }
    }

    xHttpGet.open("GET", "comments?productId=" + productId, true);
    xHttpGet.send();
}