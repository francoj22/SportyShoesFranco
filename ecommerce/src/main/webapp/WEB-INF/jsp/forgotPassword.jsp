<jsp:include page="header.jsp" />
<section class="titlebar">
    <div class="container">
        <div class="sixteen columns">
            <h2>Forgot Password</h2>

            <nav id="breadcrumbs">
                <ul>
                    <li><a href="/index">Home</a></li>
                    <li>Forgot Password</li>
                </ul>
            </nav>
        </div>
    </div>
</section>
<div class="container">
    <div class="six columns centered">
                <h3 class="headline">Forgot Password</h3><span class="line" style="margin-bottom:20px;"></span>
                <div class="clearfix"></div>
                <form action="#" method="post" id="forgotpassword_form" name= "forgotpassword_form" class="login">
                    <p class="form-row form-row-wide">
                        <label for="email">Email Address: <span class="required">*</span></label>
                        <input type="text" class="input-text" name="email" id="email" value="" required/>
                    </p>
                   <p class="form-row form-row-wide">
                     <label for="newpassword">New Password: <span class="required">*</span></label>
                       <input type="password" class="input-text" name="password" id="password"/>
                   </p>
                    <p class="form-row form-row-wide">
                       <label for="confirmpassword">Confirm Password: <span class="required">*</span></label>
                       <input type="password" class="input-text" name="confirmpassword" id="confirmpassword"/>
                   </p>
                    <p class="form-row">
                        <input type="submit" class="button" name="update" value="update"/>
                    </p>

                </form>

    </div>
</div>
<div class="margin-top-50"></div>

<jsp:include page="footer.jsp" />
<script src="custom-js/forgotPassword.js"></script>

