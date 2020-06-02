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

            let details = document.createElement('p');
            details.innerHTML = response["orderId"] + ", " + response["email"] + ", " + response["price"] + ", " +
                response["phoneNumber"] + ", " + response["deliveryMethod"] + ", " + response["address"] + ", " +
                response["date"];

            container.appendChild(details);

            const products = JSON.parse(response["products"]);

            products.forEach(function(item) {
                let product = document.createElement("p");

                product.innerHTML = item["productId"] + ", " + item["number"] + ", " + item["price"] + ", " + item["link"] +
                    ", " + item["source"];

                container.appendChild(product);
            });
        }
    }

    xHttpOrder.open("GET", "order?type=2&orderId=" + orderId, true);
    xHttpOrder.send();
}