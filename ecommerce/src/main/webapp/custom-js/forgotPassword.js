$(document).ready(function() {

    $("#forgotpassword_form").validate({
        rules: {

            email: {
                required: true,
                email: true
            },
            password: {
                required: true,
                minlength: 5
            },
            confirmpassword: {
                required: true,
                minlength: 5,
                equalTo: "#password"
            }
        },

        messege: {

            email: "Please enter a valid email address",
            password: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            confirmpassword: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long",
                equalTo: "Please enter the same password as above"
            }

        },
        submitHandler: function(form) {
            $.ajax({
                type: "POST",
                url: "/updatePassword",
                data: $('#forgotpassword_form').serialize(),
                success: function(data) {
                    if (data[0].success == "true") {
                        $("#snackbar_all").append(data[0].message);
                        var x = document.getElementById("snackbar_all")
                        x.className = "show";
                        setTimeout(function() {
                            x.className = x.className.replace("show", "");
                        }, 3000);
                        setTimeout(function() {
                            $("#snackbar_all").empty();
                            $("#reset").click();
                            window.location.href = "/index";
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
                beforeSend: function() {
                }
            });
        }


    });
})