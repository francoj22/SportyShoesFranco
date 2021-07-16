$(document).ready(function() {

    //credit cvv only allow numbers
    $("#phone").keydown(function(e) {
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


    //onkeypress only alphabets on creditcard
    $("#firstname").keypress(function(event) {
        var regex = new RegExp("^[a-zA-Z ]+$");
        var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
        if (!regex.test(key)) {
            event.preventDefault();
            return false;
        }
    });

    //onkeypress only alphabets on creditcard
    $("#lastname").keypress(function(event) {
        var regex = new RegExp("^[a-zA-Z ]+$");
        var key = String.fromCharCode(!event.charCode ? event.which : event.charCode);
        if (!regex.test(key)) {
            event.preventDefault();
            return false;
        }
    });


    $("#login_account").validate({
        rules: {
            email: {
                required: true,
                email: true
            },
            password: "required"
        },
        messages: {
            password: "Please your password",
            email: "Please enter a valid email address",
        },
        submitHandler: function(form) {
            $.ajax({
                type: "POST",
                url: "/loginUser",
                data: $('#login_account').serialize(),
                success: function(data) {
                    if (data[0].success == "true") {
                        $("#snackbar_all").append('Account Successfully Logged');
                        var x = document.getElementById("snackbar_all")
                        x.className = "show";
                        setTimeout(function() {
                            x.className = x.className.replace("show", "");
                        }, 3000);
                        setTimeout(function() {
                            $("#snackbar_all").empty();
                            $("#reset").click();
                            window.location.href = "/products";
                        }, 4000);
                    } else {
                        $("#snackbar_all").append(data[0].message);
                        var x = document.getElementById("snackbar_all")
                        x.className = "show";
                        setTimeout(function() {
                            x.className = x.className.replace("show", "");
                        }, 3000);
                        setTimeout(function() {
                            $("#snackbar_all").empty();
                        }, 4000);
                    }
                },
                beforeSend: function() {}
            });
        }
    });


    $("#registration_form").validate({
        rules: {
            firstName: "required",
            lastName: "required",
            gender: "required",
            phone: {
                required: true,
                number: true,
                minlength: 10,
                maxlength: 13
            },
            password: {
                required: true,
                minlength: 5
            },
            repassword: {
                required: true,
                minlength: 5
            },
            email: {
                required: true,
                email: true
            },
            terms: "required"
        },
        messages: {
            firstName: "Please enter your firstname",
            lastName: "Please enter your lastname",
            gender: "Please select gender",
            phone: "Please enter the valid number",
            username: {
                required: "Please enter a username",
                minlength: "Your username must consist of at least 2 characters"
            },
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            repassword: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            email: "Please enter a valid email address",
            terms: "Please accept our policy"
        },
        submitHandler: function(form) {
            $.ajax({
                type: "POST",
                url: "/registerUsers",
                data: $('#registration_form').serialize(),
                success: function(data) {
                    if (data[0].success == "true") {
                        $("#snackbar_all").append('Account Successfully Created');
                        var x = document.getElementById("snackbar_all")
                        x.className = "show";
                        setTimeout(function() {
                            x.className = x.className.replace("show", "");
                        }, 3000);
                        setTimeout(function() {
                            $("#snackbar_all").empty();
                            $("#reset").click();
                            window.location.reload();
                        }, 4000);
                    } else {

                        $("#snackbar_all").append(data[0].message);
                        var x = document.getElementById("snackbar_all")
                        x.className = "show";
                        setTimeout(function() {
                            x.className = x.className.replace("show", "");
                        }, 3000);
                        setTimeout(function() {
                            $("#snackbar_all").empty();
                        }, 4000);

                    }
                },
                beforeSend: function() {}
            });
        }
    });



});