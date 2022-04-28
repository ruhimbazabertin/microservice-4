$(document).ready(
    function (){
        //SUBMIT FORM
        $("#bookForm").submit(function (event){
            //prevent the form from submitting via the browser
            event.preventDefault();
            ajaxPost();
        })

        function ajaxPost(){
            //PREPARE FORM DATA
            var formData = {
                bookId : $("#bookId").val(),
                bookName : $("#book_name").val(),
                author   : $("#author").val()
            }
            //DO POST
            $.ajax({
                type : "POST",
                contentType: "application/json; charset=utf-8",
                url : "createBook",
                data : JSON.stringify(formData),
                dataType : 'json',
                success : function(result){
                    if(result.status == "success"){
                        $("#postResultDiv").html(
                            "" + result.data.bookName
                                + "Post Successfully! <p>"
                                +"----->Congrats !!"
                                +"</p>>");
                    }else{
                        $("#postResultDiv").html("<strong>Error</strong>");
                    }
                    console.log(result);
                },
                error : function(e){
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });
        }
    });