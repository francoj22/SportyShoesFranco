<jsp:include page="header.jsp" />
<link rel="stylesheet" href="custom-css/cart.css">
<section class="titlebar">
    <div class="container">
        <div class="sixteen columns">
            <h2>Shopping Cart</h2>
            <nav id="breadcrumbs">
                <ul>
                    <li><a href="/products">Products</a></li>
                    <li>Shopping Cart</li>
                </ul>
            </nav>
        </div>
    </div>
</section>
 <div class="container cart">
 	<div id="cartNotEmptyDisplay"> 
 		
 		<div class="sixteen columns">
            <!-- Cart -->
            <table class="cart-table responsive-table" id="cartTable">
                <tr>
                    <th>Item  </th>
                    <th>Description</th>
                    <th>Price </th>
                    <th>Quantity</th>
                    <th>Total</th>
                    <th></th>
                </tr>
                <tr>
                </tr>
            </table>

            <!-- Apply Coupon Code / Buttons -->
            <table class="cart-table bottom">

                <tr>
                    <th>
                        <div class="cart-btns">
                            <a href="#" id="proceed_to_checkout" onclick="proceed_to_checkout()" class="button color cart-btns proceed">Proceed to Checkout</a>
                        </div>
                    </th>
                </tr>

            </table>
        </div>


        <!-- Cart Totals -->
        <div class="eight columns cart-totals" id="cartTotalTable">
            <h3 class="headline">Cart Totals</h3><span class="line"></span><div class="clearfix"></div>

            <table class="cart-table margin-top-5">
                <tr>
                    <th>Cart Subtotal</th>
                    <td><p id = "grandTotalCart" ></p></td>
                </tr>
                <tr>
                    <th>Shipping and Handling</th>
                    <td><strong>Free Shipping</strong></td>
                </tr>
                <tr>
                    <th>Order Total</th>
                    <td><p id = "grandOrderTotal" ></p></td>
                </tr>
            </table>
            <br>
        </div>
 		
 		
 		
 	</div>
                
    <div id="cartEmptyDisplay">
        <img src="images/Cart-64.png" style="margin-left:480px">
        <h4 style="text-align: center">No More Products at your basket. Please goto to <a href="/products">shop.</a></h4>
        <br><br>
    </div>

</div>

<div class="margin-top-40"></div>

<jsp:include page="footer.jsp" />
<script src="custom-js/cart.js"></script>
