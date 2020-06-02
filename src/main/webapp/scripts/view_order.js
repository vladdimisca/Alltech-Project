 window.onload = function () {
    let orderId = JSON.parse(sessionStorage.getItem('orderId'));

    if(orderId) {
        showOrder(orderId);
    }
};

function showOrder(orderId) {
    const xHttpOrder = new XMLHttpRequest();

    xHttpOrder.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const response = JSON.parse(this.response);

            let container = document.getElementsByClassName("container")[0];

            let details = document.createElement('div');

            let order = document.createElement('h2');
            order.setAttribute('class', 'center');
            order.innerHTML = "Order number: " + response["orderId"];

            details.appendChild(order);

            let br = document.createElement('br');

            details.appendChild(br);

            let em = document.createElement('p');
            let txt = "Email: "
            em.innerHTML = txt.bold() + response["email"];

            details.appendChild(em);

            let nr = document.createElement('p');
            let txt2 = "Phone number: ";
            nr.innerHTML = txt2.bold() + response["phoneNumber"];

            details.appendChild(nr);

            let address = document.createElement('p');
            let txt3 = "Address: "
            address.innerHTML = txt3.bold() + response["address"];

            details.appendChild(address);

            let price = document.createElement('p');
            let txt4 = "Price: ";
            price.innerHTML = txt4.bold() + "$" + response["price"];

            details.appendChild(price);

            let delivery = document.createElement('p');
            let txt5 = "Delivery method: ";
            if(response["deliveryMethod"] === 1)
                delivery.innerHTML = txt5.bold() + "Cash on delivery";
            else
                delivery.innerHTML = txt5.bold() + "Pick from our store";

            details.appendChild(delivery);

            let date = document.createElement('p');
            let txt6 = "Date the order was sent: ";
            date.innerHTML = txt6.bold() + response["date"];

            details.appendChild(date);

            let br2 = document.createElement('br');

            details.appendChild(br2);

            let prod = document.createElement('h5');
            prod.innerHTML = "Products: "

            details.appendChild(prod);

            container.appendChild(details);

            const products = JSON.parse(response["products"]);

            products.forEach(function(item) {

                let archive = document.createElement('div');
                archive.setAttribute ('class', 'archive');

                let article = document.createElement('div');
                article.setAttribute('class', 'article');

                archive.appendChild(article);

                let br1 = document.createElement('br');

                let div = document.createElement('div');

                let para = document.createElement('p');
                para.innerHTML = "x" + item["number"];
                para.id = "para";

                div.appendChild(para);

                let anchor = document.createElement('a');
                anchor.href = item["link"];

                let image = document.createElement('img');
                image.src = item["source"];
                image.alt = "Not available";

                anchor.appendChild(image);

                article.appendChild(anchor);
                article.appendChild(div);

                container.appendChild(archive);
                container.appendChild(br1);
            });
        }
    }

    xHttpOrder.open("GET", "order?type=2&orderId=" + orderId, true);
    xHttpOrder.send();
}