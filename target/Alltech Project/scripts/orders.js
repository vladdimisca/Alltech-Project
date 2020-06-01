window.onload = function () {
    let logged = JSON.parse(localStorage.getItem('logged'));

    if(logged)
        if(logged === 1) {
            let targetLink = document.querySelectorAll('nav a')[5];

            if (targetLink) {
                targetLink.setAttribute("href", "user_profile.jsp");
            }

            let email = localStorage.getItem('email');

            getOrders(email);
        }
};

function getOrders(email) {
    const xHttpOrder = new XMLHttpRequest();

    xHttpOrder.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const response = JSON.parse(this.response);

            let container = document.getElementsByClassName('container')[0];
            let paragraph = document.getElementById('OrdersMessage');

            response.forEach(function (item) {
                if (paragraph)
                    paragraph.style.display = "none";
/*
            <div class="archive">
                    <div class="grow">
                    <article class="article">
                    <p class="par" style="font-weight: bold">Order number: 5 </p>
                <hr class="new1">
                    <p class="center">Date: 01/06/2020</p>
                <hr class="new1">
                    <p class="center">Phone number: 0725342724</p>
                <hr class="new1">
                    <p class="price"> $650</p>
                    <hr class="new1">
                    <p class="center">Delivery method: Cash on delivery</p>
                <a href="#">
                    <button class="cart">
                    View order
                    </button>
                </a>
                </article>
                </div> */
                let archive = document.createElement('div');
                archive.setAttribute ('class', 'archive');

                let grow = document.createElement('div');
                grow.setAttribute('class', 'grow');

                let article = document.createElement('div');
                article.setAttribute('class', 'article');

                archive.appendChild(grow);
                grow.appendChild(article)

                let para1 = document.createElement('p');
                para1.innerHTML = "Order number " + item.orderId;
                para1.setAttribute('class', "para");

                article.appendChild(para1);

                let hr1 = document.createElement('hr');
                hr1.setAttribute('class', 'new1');

                article.appendChild(hr1);

                let para2 = document.createElement('p');
                para2.innerHTML = "Date: " + item.date;
                para2.setAttribute('class', "center");

                article.appendChild(para2);

                let hr2 = document.createElement('hr');
                hr2.setAttribute('class', 'new1');

                article.appendChild(hr2);

                let para3 = document.createElement('p');
                para3.innerHTML = "Phone number: " + item.phoneNumber;
                para3.setAttribute('class', "center");

                article.appendChild(para3);

                let hr3 = document.createElement('hr');
                hr3.setAttribute('class', 'new1');

                article.appendChild(hr3);

                let para4 = document.createElement('p');
                para4.innerHTML = "Delivery method: " + item.deliveryMethod;
                para4.setAttribute('class', "center");

                article.appendChild(para4);

                let a = document.createElement('a');
                a.setAttribute('href', '#');

                article.appendChild(a);

                let button = document.createElement('button');
                button.innerHTML = "View command";
                button.setAttribute('class', 'cart');

                container.appendChild(archive);

            });
        }
    }


    xHttpOrder.open("GET", "order?email=" + email, true);
    xHttpOrder.send();
};