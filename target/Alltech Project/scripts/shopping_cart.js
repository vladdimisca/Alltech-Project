window.onload = function () {
    let logged = JSON.parse(localStorage.getItem('logged'));

    if(logged)
        if(logged === 1) {
            let targetLink = document.querySelectorAll('nav a')[5];

            if (targetLink) {
                targetLink.setAttribute("href", "user_profile.jsp");
            }

            let email = localStorage.getItem('email');

            getCart(email);
        }
};

function getCart(email) {
    const xHttpCart = new XMLHttpRequest();

    xHttpCart.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const response = JSON.parse(this.response);

            let container = document.getElementsByClassName('container')[0];
            let paragraph = document.getElementById('cartMessage');
            paragraph.innerText = 'Your cart is empty.';

            response.forEach(function (item) {
                if (paragraph)
                    paragraph.style.display = "none";

                let archive = document.createElement('div');
                archive.setAttribute ('class', 'archive');

                let article = document.createElement('div');
                article.setAttribute('class', 'article');

                archive.appendChild(article);

                let br = document.createElement('br');

                let div = document.createElement('div');

                let para = document.createElement('p');
                para.innerHTML = "x" + item.number;
                para.id = "para";

                div.appendChild(para);

                let divbtn = document.createElement('div');
                divbtn.setAttribute('class', 'qty');

                let span = document.createElement('span');
                span.onclick = () => decreaseByOne(email, item.productId, para);
                span.setAttribute('class', 'minus bg-dark');
                span.innerText = "-";

                divbtn.appendChild(span);

                let span2 = document.createElement('span');
                span2.onclick = () => increaseByOne(email, item.productId, para);
                span2.setAttribute('class', 'plus bg-dark');
                span2.innerText = "+";

                divbtn.appendChild(span2);

                div.appendChild(divbtn);

                let close = document.createElement('i');
                close.className = "fa fa-close";
                close.style = "font-size:20px;color:red;";

                close.onclick = () => deleteItemFromCart(email, item.productId, item.number, archive, br);

                close.onmouseover = function () { close.style = "font-size:20px;color:blue;cursor:pointer" };
                close.onmouseout = function () { close.style = "font-size:20px;color:red;"; }

                let anchor = document.createElement('a');
                anchor.href = item.link;

                let image = document.createElement('img');
                image.src = item.source;
                image.alt = "Not available";

                anchor.appendChild(image);

                article.appendChild(anchor);
                article.appendChild(div);
                article.appendChild(close);

                container.appendChild(archive);
                container.appendChild(br);
            });

            if(paragraph.style.display === 'none') {
                let hr = document.createElement('hr');

                let priceP = getTotalPrice(email);

                priceP.style.fontSize = "x-large";
                priceP.style.fontWeight = "bold";
                priceP.style.float = "right";

                container.appendChild(hr);
                container.appendChild(priceP);

                let button = document.createElement('button');
                button.setAttribute('class', 'registerbtn');
                button.innerText = "Proceed";

                container.appendChild(button);
            }
        }
    };

    xHttpCart.open("GET", "shopping_cart?email=" + email, true);
    xHttpCart.send();
}

function increaseByOne(email, productId, paragraph) {
    const xHttpAdd = new XMLHttpRequest();

    xHttpAdd.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const response = JSON.parse(this.response);

            if(response.hasOwnProperty('success')) {
                paragraph.innerHTML = "x" + response.number;
            }
        }
    };

    xHttpAdd.open("POST", "shopping_cart?email=" + email + "&productId=" + productId, true);
    xHttpAdd.send();

    window.location.replace("shopping_cart.jsp");
}

function decreaseByOne(email, productId, paragraph) {
    const xHttpDecrease = new XMLHttpRequest();

    xHttpDecrease.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const response = JSON.parse(this.response);

            if(response.hasOwnProperty('success')) {
                paragraph.innerHTML = "x" + response.number;
            }
        }
    };

    xHttpDecrease.open("DELETE", "shopping_cart?type=2&email=" + email + "&productId=" + productId, true);
    xHttpDecrease.send();

    window.location.replace("shopping_cart.jsp");
}

function deleteItemFromCart(email, productId,div, br) {
    const xHttpDelete = new XMLHttpRequest();

    xHttpDelete.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const response = JSON.parse(this.response);

            if (response.hasOwnProperty('success')) {
                div.remove();
                br.remove();
            }
        }
    }

    xHttpDelete.open("DELETE","shopping_cart?type=1&email=" + email + "&productId=" + productId, true);
    xHttpDelete.send();

    window.location.replace("shopping_cart.jsp");
}

function getTotalPrice(email) {
    const xHttpPrice = new XMLHttpRequest();

    let totalPrice = document.createElement('p');

    xHttpPrice.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const response = JSON.parse(this.response);

            totalPrice.innerHTML = "Total price: $" + response['totalPrice'];
        }
    }

    xHttpPrice.open("PUT", "shopping_cart?email=" + email, true);
    xHttpPrice.send();

    return totalPrice;
}