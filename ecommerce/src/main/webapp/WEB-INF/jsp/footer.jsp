<!-- Footer
================================================== -->
<div id="footer">
  <!-- Container -->
  <div class="container">
    <div class="four columns">
      <h3 class="headline footer">Shorty Shoes
      </h3>
      <span class="line" >
      </span>
      <div class="clearfix">
      </div>
      <p class="margin-top-15">Fresh, Iconic And Exclusive Styles For On The Pitch And On The Street From Nike. Discover The Latest Nike Shoes. Shop Online. Shop On The Nike App. Gift Cards Available. Become A Nike Member. 60-Day Free Returns. Customise On Nike By You.
      </p>
    </div>
    <div class="four columns">
      <!-- Headline -->
      <h3 class="headline footer">Customer Service
      </h3>
      <span class="line">
      </span>
      <div class="clearfix">
      </div>
      <ul class="footer-links">
        <li>
          <a href="#">Order Status
          </a>
        </li>
        <li>
          <a href="#">Payment Methods
          </a>
        </li>
        <li>
          <a href="#">Delivery & Returns
          </a>
        </li>
        <li>
          <a href="#">Privacy Policy
          </a>
        </li>
        <li>
          <a href="#">Terms & Conditions
          </a>
        </li>
      </ul>
    </div>
    <div class="four columns">
      <!-- Headline -->
      <h3 class="headline footer">My Account
      </h3>
      <span class="line">
      </span>
      <div class="clearfix">
      </div>
      <ul class="footer-links">
        <li>
          <a href="#">My Account
          </a>
        </li>
        <li>
          <a href="#">Order History
          </a>
        </li>
      </ul>
    </div>
    <div class="four columns">
      <!-- <h3 class="headline footer">Map
      </h3>
      <iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3916.321089378231!2d76.97929831433837!3d11.014518257766737!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x3ba8582f2596e827%3A0x4e07ad2de0de72a7!2sSuraj+Technologies!5e0!3m2!1sen!2sin!4v1473857313735"
              width="250" height="180" frameborder="0" style="border:0" allowfullscreen>
      </iframe>  -->
    </div>
  </div>
  <!-- Container / End -->
</div>
<!-- Footer / End -->
<!-- Footer Bottom / Start -->
<div id="footer-bottom">
  <!-- Container -->
  <div class="container">
    <div class="eight columns">&#169; Copyright 2021 by
      <a href="#">Franco Gutierrez
      </a>.
      All Rights Reserved.
    </div>
    <div class="eight columns">
      <ul class="payment-icons">
        <li>
          <img src="images/visa.png" alt=""/>
        </li>
        <li>
          <img src="images/mastercard.png" alt=""/>
        </li>
      </ul>
    </div>
  </div>
  <!-- Container / End -->
</div>
<!-- Footer Bottom / End -->
<!-- Back To Top Button -->
<div id="backtotop">
  <a href="#">
  </a>
</div>
</div>
<!-- Java Script
================================================== -->
<script src="scripts/jquery-3.3.1.min.js">
</script>
<script src="https://ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.4.1.min.js"></script>
<script src="scripts/jquery.jpanelmenu.js">
</script>
<script src="scripts/jquery.themepunch.plugins.min.js">
</script>
<script src="scripts/jquery.themepunch.revolution.min.js">
</script>
<script src="scripts/jquery.themepunch.showbizpro.min.js">
</script>
<script src="scripts/jquery.magnific-popup.min.js">
</script>
<script src="scripts/hoverIntent.js">
</script>
<script src="scripts/superfish.js">
</script>
<script src="scripts/jquery.pureparallax.js">
</script>
<script src="scripts/jquery.pricefilter.js">
</script>
<script src="scripts/jquery.selectric.min.js">
</script>
<script src="scripts/jquery.royalslider.min.js">
</script>
<script src="scripts/SelectBox.js">
</script>
<script src="scripts/modernizr.custom.js">
</script>
<script src="scripts/waypoints.min.js">
</script>
<script src="scripts/jquery.flexslider-min.js">
</script>
<script src="scripts/jquery.counterup.min.js">
</script>
<script src="scripts/jquery.tooltips.min.js">
</script>
<script src="scripts/jquery.isotope.min.js">
</script>
<script src="scripts/puregrid.js">
</script>
<script src="scripts/stacktable.js">
</script>
<script src="scripts/custom.js">
</script>
<script src="//cdnjs.cloudflare.com/ajax/libs/validate.js/0.13.1/validate.min.js"></script>
<script type="text/javascript" src="scripts/paginathing.js">
</script>
<style type="text/css">
  .resizePdtImage {
    height: 250px !important;
  }
  .fa_custom {
    color: #3BE723
  }
 <style>
  .product-button {
    cursor: pointer;
  }
  .mediaholder {
    cursor: pointer;
  }
  .pdtIds {
    cursor: pointer;
  }
  #search-field {
    width: 232px;
    margin-top: 10px;
  }
  #searchButton{
    margin-top: 10px;
  }
  .test {
    height: 30px;
    width: 30px;
    float: left;
  }
  .ui-menu .ui-menu-item {
    height: 30px;
    position: relative;
    margin: 0;
    padding: 3px 1em 3px .4em;
    cursor: pointer;
    min-height: 0;
    list-style-image: url("data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7");
  }
</style>

<script type="text/javascript">
  var responseObj1 = {
  };
  $("#search-field").keyup(function () {
    var key1 = document.getElementById("search-field").value;
    var keyValue1 = {
      "phrase": key1};
    $.ajax({
      url: "api/search.php",
      dataType: "json",
      type: "POST",
      data: JSON.stringify(keyValue1),
      success: function (data) {
        responseObj1.obj = data;
        test();
      }
      ,
      error: function (d) {
        /*alert("No Result");*/
        test();
      }
    }
          );
  }
                          );
  function test() {
    var $project = $('#search-field');
    var projects = responseObj1.obj;
    $project.autocomplete({
      minLength: 0,
      source: projects,
      focus: function (event, ui) {
        $project.val(ui.item.product_name);
        return false;
      }
    }
                         );
    $project.data("ui-autocomplete")._renderItem = function (ul, item) {
      var $li = $('<li>'),
          $img = $('<img>');
      var pdtIdFrmSearch = item.product_id;
      $img.attr({
        class: 'test', src: 'admin/Product Images/' + item.icon, id: item.product_id,
        // src: 'https://jqueryui.com/resources/demos/autocomplete/images/' + item.icon,
        // alt: item.label
      }
               );
      $li.attr('data-value', item.product_name);
      $li.append('<a id=\'' + pdtIdFrmSearch + '\' onclick="searchPdtId()" >');
      $li.find('a').append($img).append(item.product_name);
      return $li.appendTo(ul);
    };
  }
  (jQuery);
  function searchPdtId() {
    var x = $(event.currentTarget).attr("id");
    window.location.href = "product_details.php?Details=" + x;
  }
</script>
<script>
  function cart_size() {
    var x = $(event.currentTarget).attr("value");
    var cart_id = $(event.currentTarget).attr("id");
    var size = {
      "size": x, "cart_id": cart_id};
    $.ajax({
      url: "api/cartSize.php",
      dataType: "json",
      type: "POST",
      data: JSON.stringify(size),
      success: function (data) {
        $("#snackbar_all").append('Size Added');
        var x = document.getElementById("snackbar_all")
        x.className = "show";
        setTimeout(function () {
          x.className = x.className.replace("show", "");
        }
                   , 3000);
        setTimeout(function () {
          $("#snackbar_all").empty();
        }
                   , 4000);
      }
      ,
      error: function (d) {
        $("#snackbar_all").append('faild!');
        var x = document.getElementById("snackbar_all")
        x.className = "show";
        setTimeout(function () {
          x.className = x.className.replace("show", "");
        }
                   , 3000);
        setTimeout(function () {
          $("#snackbar_all").empty();
        }
                   , 4000);
        //alert('faild!');
      }
    }
          );
  }
  function color_change() {
    var x = $(event.currentTarget).attr("data-value");
    var url = "product_details.php?Details=";
    window.location.href = url + x;
  }
  $('.size_val').on('change', function () {
    var x = this.value;
    var url = "product_details.php?Details=";
    window.location.href = url + x;
  }
                   )
</script>
<script src="js/jquery-ui.js">
</script>

<style>
  #snackbar {
    visibility: hidden;
    min-width: 250px;
    margin-left: -125px;
    background-color: #3a91cf;
    color: #fff;
    text-align: center;
    border-radius: 2px;
    padding: 16px;
    position: fixed;
    z-index: 1000;
    left: 50%;
    bottom: 30px;
    font-size: 17px;
  }
  #snackbar_updated {
    visibility: hidden;
    min-width: 250px;
    margin-left: -125px;
    background-color: #3a91cf;
    color: #fff;
    text-align: center;
    border-radius: 2px;
    padding: 16px;
    position: fixed;
    z-index: 1000;
    left: 50%;
    bottom: 30px;
    font-size: 17px;
  }
  #snackbar_faild {
    visibility: hidden;
    min-width: 250px;
    margin-left: -125px;
    background-color: #3a91cf;
    color: #fff;
    text-align: center;
    border-radius: 2px;
    padding: 16px;
    position: fixed;
    z-index: 1000;
    left: 50%;
    bottom: 30px;
    font-size: 17px;
  }
  #snackbar_all {
    visibility: hidden;
    min-width: 250px;
    margin-left: -125px;
    background-color: #3a91cf;
    color: #fff;
    text-align: center;
    border-radius: 2px;
    padding: 16px;
    position: fixed;
    z-index: 1000;
    left: 50%;
    bottom: 30px;
    font-size: 17px;
  }
  #snackbar_procced_to_checkout {
    visibility: hidden;
    min-width: 250px;
    margin-left: -125px;
    background-color: #3a91cf;
    color: #fff;
    text-align: center;
    border-radius: 2px;
    padding: 16px;
    position: fixed;
    z-index: 1000;
    left: 50%;
    bottom: 30px;
    font-size: 17px;
  }
  #snackbar.show {
    visibility: visible;
    -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
    animation: fadein 0.5s, fadeout 0.5s 2.5s;
  }
  #snackbar_updated.show {
    visibility: visible;
    -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
    animation: fadein 0.5s, fadeout 0.5s 2.5s;
  }
  #snackbar_faild.show {
    visibility: visible;
    -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
    animation: fadein 0.5s, fadeout 0.5s 2.5s;
  }
  #snackbar_all.show {
    visibility: visible;
    -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
    animation: fadein 0.5s, fadeout 0.5s 2.5s;
  }
  #snackbar_procced_to_checkout.show {
    visibility: visible;
    -webkit-animation: fadein 0.5s, fadeout 0.5s 2.5s;
    animation: fadein 0.5s, fadeout 0.5s 2.5s;
  }
  @-webkit-keyframes fadein {
    from {
      bottom: 0;
      opacity: 0;
    }
    to {
      bottom: 30px;
      opacity: 1;
    }
  }
  @keyframes fadein {
    from {
      bottom: 0;
      opacity: 0;
    }
    to {
      bottom: 30px;
      opacity: 1;
    }
  }
  @-webkit-keyframes fadeout {
    from {
      bottom: 30px;
      opacity: 1;
    }
    to {
      bottom: 0;
      opacity: 0;
    }
  }
  @keyframes fadeout {
    from {
      bottom: 30px;
      opacity: 1;
    }
    to {
      bottom: 0;
      opacity: 0;
    }
  }
</style>
<div id="snackbar">Added To Cart
</div>
<div id="snackbar_updated">Product Already Added To Cart
</div>
<div id="snackbar_faild">Please Try Again
</div>
<div id="snackbar_all">
</div>
<div id="snackbar_procced_to_checkout">Item purchased! Thanks for you shopping!</div>
</body>
</html>