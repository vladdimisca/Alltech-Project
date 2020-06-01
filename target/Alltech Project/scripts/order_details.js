window.onload = function () {
    let orderForm = document.getElementById("orderForm");
    let email = localStorage.getItem("email");

    const xHttpPrice = new XMLHttpRequest();

    let totalPrice = document.getElementById("totalPrice");
    let priceMessage = totalPrice.innerHTML;
    let price, finalPrice;

    xHttpPrice.onreadystatechange = function () {
        if (this.readyState === 4 && this.status === 200) {
            const response = JSON.parse(this.response);

            totalPrice.innerHTML = priceMessage + (parseInt(response['totalPrice']) + 5);
            price = document.createTextNode(response['totalPrice']);
            finalPrice = parseInt(price.nodeValue) + 5;
        }
    }

    xHttpPrice.open("PUT", "shopping_cart?email=" + email, true);
    xHttpPrice.send();

    let radioGroup = document.querySelectorAll("input[name=delivery]");

    radioGroup[0].onclick = function () {
        if(radioGroup[0].checked) {
            finalPrice = parseInt(price.nodeValue) + 5;

            totalPrice.innerHTML = priceMessage + finalPrice;
        }
    }

    radioGroup[1].onclick = function () {
        if(radioGroup[1].checked) {
            finalPrice = parseInt(price.nodeValue);

            totalPrice.innerHTML = priceMessage + finalPrice;
        }
    }

    orderForm.onsubmit = function(event) {
        event.preventDefault();

        commitOrder(email, finalPrice);
    }
}

function commitOrder(email, totalPrice) {
    let phoneNumber = document.getElementById("phoneNumber").value;
    let fullAddress = document.getElementById("address").value;
    let deliveryMethod = document.querySelector("input[name=delivery]:checked").value;

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

    const xHttpOrder = new XMLHttpRequest();

    xHttpOrder.onreadystatechange = function () {
        const response = JSON.parse(this.response);

        if(response.hasOwnProperty("success")) {
            window.location.replace('orders.jsp');
        }
    }

    xHttpOrder.open("POST", "order?email=" + email + "&price=" + totalPrice + "&address=" + fullAddress +
                "&phoneNumber=" + phoneNumber + "&deliveryMethod=" + deliveryMethod + "&date=" + dateTime, true);
    xHttpOrder.send();
}
