window.onload = function () {
    let logged = JSON.parse(localStorage.getItem('logged'));

    if(logged)
        if(logged === 1) {
            let targetLink = document.querySelectorAll('nav a')[5];

            if (targetLink) {
                targetLink.setAttribute("href", "user_profile.jsp");
            }

            let email = localStorage.getItem('email');

            GetCart(email);
        }
};

function GetCart(email) {
    const xHttpCart = new XMLHttpRequest();

    xHttpCart.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const response = JSON.parse(this.response);

            let container = document.getElementsByClassName('container')[0];
            let paragraph = document.getElementById('cartMessage');
            paragraph.innerText = 'Your cart is empty.';

            if(response.hasOwnProperty('failure')) {
                paragraph.innerText = response.failure;
            } else {
                response.forEach(function (item) {
                    if (paragraph)
                        paragraph.style.display = "none";

                    let archive = document.createElement('div');
                    archive.setAttribute ('class', 'archive');

                    let article = document.createElement('div');
                    article.setAttribute('class', 'article');

                    archive.appendChild(article);

                    let br = document.createElement('br');

                    let para = document.createElement('p');
                    para.innerHTML = "x" + item.number;
                    para.id = "para";
                    let close = document.createElement('i');
                    close.className = "fa fa-close";
                    close.style = "font-size:20px;color:red;";
                    close.onclick = () => DeleteItemFromCart(email, item.productId, item.number, archive, br);

                    let image = document.createElement('img');

                    image.src = item.source;
                    image.alt = "Not available";

                    article.appendChild(image);
                    article.appendChild(para);
                    article.appendChild(close);

                    container.appendChild(archive);
                    container.appendChild(br);
                });
            }
        }
    };

    xHttpCart.open("GET", "shopping_cart?email=" + email, true);
    xHttpCart.send();
}

function DeleteItemFromCart(email, productId, number, div, br) {
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

    xHttpDelete.open("DELETE","shopping_cart?email=" + email + "&productId=" + productId + "&number=" + number , true);
    xHttpDelete.send();

    window.location.replace("shopping_cart.jsp");
}