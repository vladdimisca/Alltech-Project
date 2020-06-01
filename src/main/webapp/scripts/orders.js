window.onload = function () {
    let logged = JSON.parse(localStorage.getItem('logged'));

    if(logged)
        if(logged === 1) {
            let targetLink = document.querySelectorAll('nav a')[5];

            let paragraph = document.getElementById('ordersMessage');
            paragraph.innerText = "You have no orders.";

            if (targetLink) {
                targetLink.setAttribute("href", "user_profile.jsp");
            }

            let email = localStorage.getItem('email');

            getOrders(email);
        }
};

function getOrders(email) {
    const xHttpOrder = new XMLHttpRequest();

    let container = document.getElementsByClassName('container')[0];
    let paragraph = document.getElementById('ordersMessage');

    xHttpOrder.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const response = JSON.parse(this.response);

            response.forEach(function (item) {
                if (paragraph)
                    paragraph.style.display = "none";

                let archive = document.getElementsByClassName('archive')[0];

                let grow = document.createElement('div');
                grow.setAttribute('class', 'grow');

                let article = document.createElement('article');
                article.setAttribute('class', 'article');

                archive.appendChild(grow);
                grow.appendChild(article)

                let para1 = document.createElement('p');
                para1.innerHTML = "Order number: " + item.orderId;
                para1.setAttribute('class', 'par');
                para1.style.fontWeight = "bold";

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

                let hr4 = document.createElement('hr');
                hr4.setAttribute('class', 'new1');

                article.appendChild(hr4);

                let paraprice = document.createElement('p');
                paraprice.innerHTML = "$" + item.price;
                paraprice.setAttribute('class', "price");

                article.appendChild(paraprice);

                let hr3 = document.createElement('hr');
                hr3.setAttribute('class', 'new1');

                article.appendChild(hr3);

                let para4 = document.createElement('p');
                if(item.deliveryMethod == 1)
                    para4.innerHTML = "Cash on delivery";
                else
                    para4.innerHTML = "Pick from store";

                para4.setAttribute('class', "center");

                article.appendChild(para4);

                let br = document.createElement('br');

                article.appendChild(br);

                let a = document.createElement('a');
                a.setAttribute('href', '#');

                article.appendChild(a);

                let button = document.createElement('button');
                button.innerHTML = "View order";
                button.setAttribute('class', 'cart');

                a.appendChild(button);

                container.appendChild(archive);

            });
        }
    }


    xHttpOrder.open("GET", "order?email=" + email, true);
    xHttpOrder.send();
}