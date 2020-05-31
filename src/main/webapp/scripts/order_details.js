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

    const xHttpOrder = new XMLHttpRequest();

    xHttpOrder.onreadystatechange = function () {

    }

    xHttpOrder.open("POST", "order?email=" + email + "&price=" + totalPrice + "&address=" + fullAddress +
                "&phoneNumber=" + phoneNumber + "&deliveryMethod=" + deliveryMethod, true);
    xHttpOrder.send();
}
