
window.onload = function () {
    let logged = JSON.parse(localStorage.getItem('logged'));

    if(logged)
        if(logged === 1) {
            let targetLink = document.querySelectorAll('nav a')[5];

            if (targetLink) {
                targetLink.setAttribute("href", "user_profile.jsp");
            }


            let email = localStorage.getItem('email');
            const xHttpCart = new XMLHttpRequest();

            xHttpCart.onreadystatechange = function () {
                if (this.readyState === 4 && this.status === 200) {
                    const response = JSON.parse(this.response);

                    let container = document.getElementsByClassName('container')[0];
                    let paragraph = document.getElementById('cartMessage');
                    paragraph.innerText = 'Your cart is empty.';

                    response.forEach(function (item) {
                        if (paragraph)
                            paragraph.remove();

                        let image = document.createElement('img');

                        image.src = item.source;
                        image.alt = "Not available";
                        image.setAttribute('width', '50%');

                        container.appendChild(image);
                        container.appendChild(document.createTextNode(item.number));
                        container.appendChild(document.createElement('br'));
                    });
                }
            };

            xHttpCart.open("GET", "shopping_cart?email=" + email, true);
            xHttpCart.send();
        }
};
