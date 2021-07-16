<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>
        <!-- Basic Page Needs
        ================================================== -->
        <meta charset="utf-8">
        <title>Sporty Shoes</title>
        <!-- Mobile Specific Metas
        ================================================== -->
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <!-- CSS
        ================================================== -->
        <link rel="stylesheet" href="css/style.css">
        <link rel="stylesheet" href="css/colors/green.css" id="colors">
        <link rel="stylesheet" href="css/jquery-ui.css">
     
        <style>
            .error {
                color: red;
            }
            .login_show {
                background-color: #b6aab9;
                color:white;
                padding:2px !important;
                font-weight:bold;
                text-transform: capitalize;
            }
            #wishlist{
                float: initial;
                margin: 10px;
            }
            #basket{
                margin: 10px;
            }
            }
        </style>
    </head>

    <body class="boxed" style="background-image: url('images/bg/shattered.png');">
        <div id="wrapper">
            <!-- Top Bar
            ================================================== -->
            <div id="top-bar">
                <div class="container">

                    <!-- Top Bar Menu -->
                    <div class="ten columns">
                        <ul class="top-bar-menu">
                            <li><i class="fa fa-phone"></i> +353899405386</li>
                            <li><i class="fa fa-envelope"></i> <a href="#">francogutierrezsalazar@gmail.com</a></li>
                        </ul>
                    </div>

                    <!-- Social Icons -->
                    <div class="six columns">
                        <ul class="social-icons">
                            <li><a class="facebook" href="#"><i class="icon-facebook"></i></a></li>
                            <li><a class="twitter" href="#"><i class="icon-twitter"></i></a></li>
                            <li><a class="dribbble" href="#"><i class="icon-dribbble"></i></a></li>
                            <li><a class="gplus" href="#"><i class="icon-gplus"></i></a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <div class="clearfix"></div>
            <!-- Header
            ================================================== -->
            <div class="container">
                <!-- Logo -->
                <div class="four columns">
                    <div id="logo">
                        <h1><a href="index.php">Sporty Shoes</a></h1>
                    </div>
                </div>


                <!-- Additional Menu -->
                <div class="twelve columns">
                    <div id="additional-menu">
                        <ul>

                                <li><a href="#">My Account</a></li>
                                <% try { 
                                	if (session.getAttribute("USER_NAME") == null || session.getAttribute("USER_NAME").toString().equals("")) { %>
                                		<li class="login_show">ADMIN</li>
                                		<input style= "display:none" type="text" id="logInUserId" name="logInUserId" value= 0>
                                <%   } else { %>
                               			<li class="login_show"><%= session.getAttribute("USER_NAME")%></li>
                               			<input style= "display:none" type="text" id="logInUserId" name="logInUserId" value= <%= session.getAttribute("USER_ID")%>>
                               	<%   } 		
                                 } catch (Exception e) {
                                	 
                                 } %>
                                <li><a href="/logOut">Logout</a></li>
                        </ul>
                    </div>
                </div>


                <!-- Shopping Cart -->
                <div class="twelve columns">

                    <div id="cart">
                        <!-- Button -->
                        <div class="cart-btn">
                         	<% try { 
                                	if (session.getAttribute("USER_NAME") == null || session.getAttribute("USER_NAME").toString().equals("")) { %> 
                                		<a href="#" class="button adc" id="basket">0 Item</a>
                                <%   } else { %>
                                		<a href="/cart" class="button adc" id="basket">0 Item</a>
                               	<%   } 		
                                 } catch (Exception e) {
                                	 
                                 } %>
                        </div>
                    </div>

                    <!-- Search
                    <nav class="top-search"">
                        <button id="searchButton" onclick="search_Action();"><i class="fa fa-search"></i></button>
                        <input class="search-field"  id="search-field" type="text" placeholder="Search" value=""/>
                    </nav>  -->

                </div>

            </div>


            <!-- Navigation
            ================================================== -->
            <div class="container">
                <div class="sixteen columns">

                    <a href="#menu" class="menu-trigger"><i class="fa fa-bars"></i> Menu</a>

                    <nav id="navigation">
                        <ul class="menu" id="responsive">

                            <li><a href="#" class="current homepage" id="current">Home</a></li>
                            <li class="dropdown">
                                <a href="/products">Products</a>
                            </li>
                        </ul>
                    </nav>
                </div>
            </div>