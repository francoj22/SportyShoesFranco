$(document).ready(function() {

    var userId = $("#logInUserId").val();
    $.ajax({
        type: "GET",
        url: "/getMainParentCategories",
        cache: false,
        success: function(data) {
            $ulSub = $("#categories");
            if (data[0].success = "true") {
                var data = data[0].mainParentCategoryList;
                $.each(data, function(i, item) {
                    $ulSub.append('<li id="' + item.mainParentCatId + '"><a style="cursor: pointer" onclick="loadCategory_main('+item.mainParentCatId+');" >' + item.mainParentCatName + '<span class="glyphicon glyphicon-chevron-right"></span></a></li>');
				});

            }
        },
        error: function(e) {}

    });


    $.ajax({
        type: "GET",
        url: "/getProducts",
        cache: false,
        success: function(data) {
			if (data[0].success = "true") {
				loadProducts(data);
			}

        },
        error: function(d) {
            loadProducts(data);
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
				$("#basket").empty();
        		$("#basket").append(data[0].cartCount + " Items");
			}else{
				$("#basket").empty();
        		$("#basket").append(0+ " Item");
			}
		},error: function(e) {
       		$("#basket").empty();
        	$("#basket").append(0+ " Item");
        }
	});



    //onkeypress only alphabets on fullname
    $("#amount").keypress(function(event) {
        var regex = new RegExp("^[a-zA-Z ]+$");
        var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
        if (!regex.test(key)) {
            event.preventDefault();
            return false;
        }
    });

    // only allow numbers to mobilenumber
    $("#amount").keydown(function(e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
            // Allow: Ctrl+A, Command+A
            (e.keyCode === 65 && (e.ctrlKey === true || e.metaKey === true)) ||
            // Allow: home, end, left, right, down, up
            (e.keyCode >= 35 && e.keyCode <= 40)) {
            // let it happen, don't do anything
            return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });

});

function loadProducts(data) {
    $("#allProducts").empty();
	data.all_products = data[0].productsList;
    if (data.all_products.length == 0) {
        var msg = "<h3><font color='green'> Sorry no products available for your search</font></h3>";
        $("#allProducts").append(msg);
    } else {
        for (var i = 0; i < data.all_products.length; i++) {
            var str = data.all_products[i].productImages;
            var str_array = str.split(',');
            if (data.all_products[i].productQuantity == 0) {
                var price = 'Out of Stocks';
                var add_to_cart_button = "";
            } else {
                var rupeesymbol = '₹';
                var x = data.all_products[i].productPrice;
                x = x.toString();
                var lastThree = x.substring(x.length - 3);
                var otherNumbers = x.substring(0, x.length - 3);
                if (otherNumbers != '')
                    lastThree = ',' + lastThree;
                var res = otherNumbers.replace(/\B(?=(\d{2})+(?!\d))/g, ",") + lastThree;
                var price = res;
                var price_final = rupeesymbol.concat(price);

                var selling_price = data.all_products[i].sellingPrice;
                selling_price = selling_price.toString();

                var lastThree = selling_price.substring(selling_price.length - 3);
                var otherNumbers = selling_price.substring(0, selling_price.length - 3);
                if (otherNumbers != '')
                    lastThree = ',' + lastThree;
                var res = otherNumbers.replace(/\B(?=(\d{2})+(?!\d))/g, ",") + lastThree;
                var selling_price1 = res;

                var selling_price_result = rupeesymbol.concat(selling_price1);


                var add_to_cart_button = "<a id= \"" + data.all_products[i].productId + "\" onclick=\"addToCart(" + data.all_products[i].productId + ",\'" + data.all_products[i].productColorName + "\',\'" + data.all_products[i].productSize + "\');\"  class=\"product-button\"><i class=\"fa fa-shopping-cart\"></i> Add to Cart</a>";
            }
            var displayImages = "<a id= \"" + data.all_products[i].productId + "\"><img class=\"resizePdtImage img-responsive\" src=\"images/products/" + str_array[0] + "\"/><div class=\"cover\"><img class=\"resizePdtImage img-responsive\" src= \"images/products/" + str_array[1] + "\"></div></a>";
            var productid = data.all_products[i].productId;
            var innerHtml = "<div class=\"four shop columns\"><figure class=\"product\"><i style=\"z-index: 1\" productid= \"" + productid + "\"    id= \"" + productid + "\" onclick=\"whistlelistfunction();\"  aria-hidden=\"true\"></i><div class=\"mediaholder\">" + displayImages + add_to_cart_button + "</div><section style=\"height:160px !important\"><span class=\"product-category\"></span><h5 style=\"text-transform:capitalize;\">" + data.all_products[i].productName + "</h5><span class=\"product-price-discount\" ><i>" + selling_price_result + "</i></span><span class=\"product-price-discount\" >" + price_final + "</span></section></figure></div>"
            $("#allProducts").append(innerHtml);
            if (data.all_products.length == 0) {
                $(".pagination-container").empty();
            } else if (data.all_products.length <= 9) {
                $(".pagination-container").empty();
                $('#allProducts').paginathing({
                    perPage: 9,
                    limitPagination: 1
                })
            } else if (data.all_products.length > 9 && data.all_products.length <= 18) {
                $(".pagination-container").empty();
                $('#allProducts').paginathing({
                    perPage: 9,
                    limitPagination: 2
                })
            } else if (data.all_products.length > 18 && data.all_products.length <= 27) {
                $(".pagination-container").empty();
                $('#allProducts').paginathing({
                    perPage: 9,
                    limitPagination: 3
                })
            } else {
                $(".pagination-container").empty();
                $('#allProducts').paginathing({
                    perPage: 9,
                    limitPagination: 4
                })
            }
        }
    }
}


function addToCart(product_Id,color,size) {
    var user_id = $("#logInUserId").val();
    var addToCartDetails = JSON.stringify({
        "product_id": ""+ product_Id+ "",
        "user_id": ""+ user_id+ "",
        "qty": ""+1+ "",
        "size": ""+ size+ "",
        "color": ""+ color+ ""
    });
    if (user_id == "0") {
        $("#snackbar_all").append('Please Login');
        var x = document.getElementById("snackbar_all")
        x.className = "show";
        setTimeout(function() {
            x.className = x.className.replace("show", "");
        }, 2000);
        setTimeout(function() {
            $("#snackbar_all").empty();
            window.location.href = "/index";
        }, 3000);
    }  else {
        $.ajax({
            url: "/addToCart",
   			contentType: 'application/json',
            mimeType: 'application/json',            
			type: "POST",
            data: addToCartDetails,
            success: function(data) {
                renderCartData(data);
            },
            error: function(data) {
                renderCartData(data);
            }
        });
    }
}	

function renderCartData(data) {
    if (data[0].success == "true") {
        var x = document.getElementById("snackbar")
        x.className = "show";
        setTimeout(function() {
            x.className = x.className.replace("show", "");
        }, 3000);
    } else {
		if(data[0].message == "Item already added in the Cart! Kindly Check"){
			var x = document.getElementById("snackbar_updated")
		}else{
			var x = document.getElementById("snackbar_faild")
		}
        x.className = "show";
        setTimeout(function() {
            x.className = x.className.replace("show", "");
        }, 3000);
    }
}