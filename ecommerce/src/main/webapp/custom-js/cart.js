$(document).ready(function() {

    var userId = $("#logInUserId").val();

    $.ajax({
        type: "POST",
        url: "/cartCount",
        data: {
            "userId": userId
        },
        cache: false,
        success: function(data) {
            if (data[0].success = "true") {
                $("#basket").empty();
                $("#basket").append(data[0].cartCount + " Items");
            } else {
                $("#basket").empty();
                $("#basket").append(0 + " Item");
            }
        },
        error: function(e) {
            $("#basket").empty();
            $("#basket").append(0 + " Item");
        }
    });

    $.ajax({
        type: "POST",
        url: "/cartCount",
        data: {
            "userId": userId
        },
        cache: false,
        success: function(data) {
            if (data[0].success = "true") {
                if (data[0].cartCount != "0") {
                    $('#cartEmptyDisplay').hide();
                    $('#cartNotEmptyDisplay').show();
                } else {
                    $('#cartNotEmptyDisplay').hide();
                    $('#cartEmptyDisplay').show();
                }
            } else {
                $('#cartNotEmptyDisplay').hide();
                $('#cartEmptyDisplay').show();
            }
        },
        error: function(e) {
            $('#cartNotEmptyDisplay').hide();
            $('#cartEmptyDisplay').show();
        }

    });

    $.ajax({
        type: "POST",
        url: "/cartDetails",
        data: {
            "userId": userId
        },
        cache: false,
        success: function(data) {
            if (data[0].success = "true") {
                var data = data[0].cartList;
                var table = $("#cartTable");
                var cartTotalTable = $("#cartTotalTable");
                var sumOfCartTotal = 0;
                var rupeesymbol = '₹';
                $.each(data, function(i, item) {
                    var imgArr = item.products.productImages.split(',');
                    var quantityTd = '<td><div class="qtyminus" onclick="cart_minus(' + item.cartId + ',' + item.productId + ',' + userId + ');" id="' + item.cartId + '"></div><input type="text" name="quantity" value="' + item.qty + '" class="qty" id="' + item.cartId + '-' + item.productId + '"/><div class="qtyplus" onclick="cart_plus(' + item.cartId + ',' + item.productId + ',' + userId + ')" id="' + item.cartId + '"></div></td>';
                    var totalAmountTd = '<td class="cart-total cart-total-append-' + item.cartId + '><p class = "appendTotalamt">' + rupeesymbol + numberWithCommas(item.qty * item.products.sellingPrice) + '</p></td>';
                    var removeCardTd = '<td><a id="' + item.cartId + '" class="cart-remove" onclick="cartRemove(' + item.cartId + ');"></a></td>'
                    var tableRow = '<tr id = ' + item.cartId + '><td><img style="width: 80px !important;height: 80px !important" src="images/products/' + imgArr[0] + '" alt=""/></td><td class="cart-title"><a href="/products" title="' + item.products.productName + '" style="cursor:pointer" id= "' + item.productId + '" >' + item.products.productName.substring(0, 25) + '...' + '</a></td><td>' + rupeesymbol + numberWithCommas(item.products.sellingPrice) + '</td>' + quantityTd + '+' + totalAmountTd + '+' + removeCardTd + '</tr>';
                    sumOfCartTotal += (item.qty * item.products.sellingPrice);
                    table.append($(tableRow));
                });
                $("#grandTotalCart").val('');
                $("#grandTotalCart").text('');
                $("#grandTotalCart").append(rupeesymbol + numberWithCommas(sumOfCartTotal));
                $("#grandOrderTotal").val('');
                $("#grandOrderTotal").text('');
                $("#grandOrderTotal").append(rupeesymbol + numberWithCommas(sumOfCartTotal));
                
            } else {}
        },
        error: function(e) {
            $('#cartNotEmptyDisplay').hide();
            $('#cartEmptyDisplay').show();
        }

    });




});

function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function cartRemove(cartId) {

    $.ajax({
        type: "POST",
        url: "/deleteCart",
        data: {
            "cart_id": cartId
        },
        cache: false,
        success: function(data) {
            if (data.success = "true") {
                $("#snackbar_all").empty();
                $("#snackbar_all").append(data.message);
                var x = document.getElementById("snackbar_all")
                x.className = "show";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");
                }, 3000);
                setTimeout(function() {
                    $("#snackbar_all").empty();
                    window.location.reload();
                }, 4000);

            } else {
                $("#snackbar_all").empty();
                $("#snackbar_all").append('Cart cannot be deleted, Kindly contact Admin! ');
                var x = document.getElementById("snackbar_all")
                x.className = "show";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");
                }, 3000);
            }
        },
        error: function(data) {
            $("#snackbar_all").empty();
            $("#snackbar_all").append('Cart cannot be deleted, Kindly contact Admin! ');
            var x = document.getElementById("snackbar_all")
            x.className = "show";
            setTimeout(function() {
                x.className = x.className.replace("show", "");
            }, 3000);

        }

    });

}

function cart_plus(cartId, productId, userId) {

    var qty = $("#" + cartId + '-' + productId).val();
    qty++;

    $.ajax({
        type: "POST",
        url: "/updateCart",
        data: {
            "cart_id": cartId,
            "qty": qty
        },
        cache: false,
        success: function(data) {
            if (data.success = "true") {
                $("#snackbar_all").empty();
                $("#snackbar_all").append(data.message);
                var x = document.getElementById("snackbar_all")
                x.className = "show";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");
                }, 3000);
                setTimeout(function() {
                    $("#snackbar_all").empty();
                    window.location.reload();
                }, 4000);

            } else {
                $("#snackbar_all").empty();
                $("#snackbar_all").append('Cart Qty Cannot be updated, Kindly contact Admin! ');
                var x = document.getElementById("snackbar_all")
                x.className = "show";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");
                }, 3000);
            }
        },
        error: function(data) {
            $("#snackbar_all").empty();
            $("#snackbar_all").append('Cart cannot be updated, Kindly contact Admin! ');
            var x = document.getElementById("snackbar_all")
            x.className = "show";
            setTimeout(function() {
                x.className = x.className.replace("show", "");
            }, 3000);

        }

    });


}


function cart_minus(cartId, productId, userId) {

    var qty = $("#" + cartId + '-' + productId).val();
    qty--;

    if (qty > 0) {
        $.ajax({
            type: "POST",
            url: "/updateCart",
            data: {
                "cart_id": cartId,
                "qty": qty
            },
            cache: false,
            success: function(data) {
                if (data.success = "true") {
                    $("#snackbar_all").empty();
                    $("#snackbar_all").append(data.message);
                    var x = document.getElementById("snackbar_all")
                    x.className = "show";
                    setTimeout(function() {
                        x.className = x.className.replace("show", "");
                    }, 3000);
                    setTimeout(function() {
                        $("#snackbar_all").empty();
                        window.location.reload();
                    }, 4000);

                } else {
                    $("#snackbar_all").empty();
                    $("#snackbar_all").append('Cart Qty Cannot be updated, Kindly contact Admin! ');
                    var x = document.getElementById("snackbar_all")
                    x.className = "show";
                    setTimeout(function() {
                        x.className = x.className.replace("show", "");
                    }, 3000);
                }
            },
            error: function(data) {
                $("#snackbar_all").empty();
                $("#snackbar_all").append('Cart Qty Cannot be updated, Kindly contact Admin!  ');
                var x = document.getElementById("snackbar_all")
                x.className = "show";
                setTimeout(function() {
                    x.className = x.className.replace("show", "");
                }, 3000);

            }

        });

    } else {
        $("#snackbar_all").empty();
        $("#snackbar_all").append('Cart Qty Cannot be Zero, Kindly Delete the cart! ');
        var x = document.getElementById("snackbar_all")
        x.className = "show";
        setTimeout(function() {
            x.className = x.className.replace("show", "");
        }, 3000);


    }



}

function proceed_to_checkout() {
    var pCheckout = document.getElementById("snackbar_procced_to_checkout")
    pCheckout.className = "show";
    setTimeout(function() {
        pCheckout.className = pCheckout.className.replace("show", "");
    }, 3000);
}