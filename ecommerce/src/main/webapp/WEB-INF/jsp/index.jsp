<jsp:include page="header.jsp" />
<section class="titlebar">
    <div class="container">
        <div class="sixteen columns">
            <h2>My Account</h2>

            <nav id="breadcrumbs">
                <ul>
                    <li><a href="/index">Home</a></li>
                    <li>My Account</li>
                </ul>
            </nav>
        </div>
    </div>
</section>

<div class="container">
    <div class="six columns centered">
        <ul class="tabs-nav my-account">
            <li class=""><a href="#tab1">Login</a></li>
            <li><a href="#tab2">Register</a></li>
        </ul>
        <div class="tabs-container">
            <div class="tab-content" id="tab1" style="display: none;">
                <h3 class="headline">Login</h3><span class="line" style="margin-bottom:20px;"></span>
                <div class="clearfix"></div>
                <form action="#" method="post" id="login_account" name= "login_account" class="login">
                    <input type="hidden" name="conditions" value="check_login">
                    <p class="form-row form-row-wide">
                        <label for="email">Email Address: <span class="required">*</span></label>
                        <input type="text" class="input-text" name="email" id="email" value="" required/>
                    </p>
                    <p class="form-row form-row-wide">
                        <label for="user_password">Password: <span class="required">*</span></label>
                        <input class="input-text" type="password" name="password" id="password" required/>
                    </p>
                    <p class="form-row">
                        <input type="submit" class="button" name="login" value="Login"/>
                        <!--label for="rememberme" class="rememberme">
                            <input name="rememberme" type="checkbox" id="rememberme" value="forever" /> Remember Me</label-->
                    </p>
                    <p class="lost_password">
                        <a href="/forgotPassword"><font color="green">Forgot Password?</font></a>
                    </p>
                </form>
            </div>
            <!-- Register -->
            <div class="tab-content" id="tab2" style="display: none;">
                <h3 class="headline">Register</h3><span class="line" style="margin-bottom:20px;"></span>
                <div class="clearfix"></div>
                <form method="post" class="register" id="registration_form" name="registration_form">
                    <p class="form-row form-row-wide">
                        <label for="firstname">First Name: <span class="required">*</span></label>
                        <input type="text" class="input-text" name="firstName" id="firstName" value=""/>
                    </p>
                    <p class="form-row form-row-wide">
                        <label for="lastname">Last Name: <span class="required">*</span></label>
                        <input type="text" class="input-text" name="lastName" id="lastName" value=""/>
                    </p>
                    <p class="form-row form-row-wide">
                        <label for="email">Email Address: <span class="required">*</span></label>
                        <input type="email" class="input-text" name="email" id="email" value=""/>
                    </p>
                    <p class="form-row form-row-wide">
                        <label for="phone">Phone: <span class="required">*</span></label>
                        <input type="text" class="input-text" name="phone" maxlength="10" id="phone" value=""/>
                    </p>
                    <p class="form-row form-row-wide">
                        <label for="gender">Gender: <span class="required">*</span></label>
                        <select id="gender" name="gender" class="input-text">
                            <option value="male">Male</option>
                            <option value="female">Female</option>
                            <option value="others">Others</option>
                        </select>
                    </p>
                    <p class="form-row form-row-wide">
                        <label for="password">Password: <span class="required">*</span></label>
                        <input type="password" class="input-text" name="password" id="password"/>
                    </p>
                    <p class="form-row form-row-wide">
                        <label for="repassword">Repeat Password: <span class="required">*</span></label>
                        <input type="password" class="input-text" name="repassword" id="repassword"/>
                    </p>
                    <p class="form-row">
                        <input type="submit" class="button" name="register" value="Register"/>
                        <input type="reset" id="reset" class="button" name="reset" value="reset" style="display: none"/>
                    </p>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="margin-top-50"></div>
<jsp:include page="footer.jsp" />
<script src="custom-js/index.js"></script>