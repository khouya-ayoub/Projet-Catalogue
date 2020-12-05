function addToBasket(id) {
    $.ajax({
        url: '/panier',
        method: 'POST',
        data: {add: id},
        succes: function() {
            alert("Product added to basket!")
        }
    });
}

function deleteProduct(id) {
    $.ajax({
        url: '/panier',
        data: {remove: id},
        method: 'POST',
        succes: function() {
            alert("Product removed ! ");
        }
    })
}