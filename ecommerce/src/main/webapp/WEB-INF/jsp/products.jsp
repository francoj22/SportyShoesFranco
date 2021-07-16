<jsp:include page="header.jsp" />
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<link rel="stylesheet" href="custom-css/product.css">
<section class="parallax-titlebar fullwidth-element"  data-background="#000" data-opacity="0.45" data-height="160">
    <img class="banner" src="images/sportyshoes-banner-1.jpg" alt="" style="height: 678px !important ; top: -233.0678px" />
    <div class="parallax-overlay"></div>
    <div class="parallax-content">
        <h2>Sporty Shoes <span>Free International Shipping</span></h2>
        <nav id="breadcrumbs">
            <ul>
                <li><a href="/index">Home</a></li>
                <li>Products</li>
            </ul>
        </nav>
    </div>
</section>

<div class="container">
    <div class="four columns">
        <!-- Categories -->
        <div class="widget margin-top-0">
            <h3 class="headline">Categories</h3><span class="line"></span><div class="clearfix"></div>
            <ul id="categories">
                <li><a href="/products" style="cursor: pointer">All Products</a></li>
            </ul>
            <div class="clearfix"></div>
        </div>
        
    </div>
    
	<!-- Products -->
    <div class="twelve columns products" id="allProducts" ></div>
    
</div>

<div class="margin-top-15"></div>
<jsp:include page="footer.jsp" />
<script src="custom-js/products.js"></script>