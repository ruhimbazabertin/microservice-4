$(document).ready(
    function() {
        $('#loginForm').submit(function (event){
            event.preventDefault();
            alert(" Login Form Button Clicked!");
        });

        $('#registerForm').submit(function (event){
            event.preventDefault();
            alert("Register Form Button Clicked!");
        });
    });