$(document).ready(
    function (){
        //getAllDepartsRecord()
        //SUBMIT FORM
        // $("#save_depart").click(function (event){
        //     //prevent the form from submitting via the browser
        //     event.preventDefault();
        //     createDepart();
        // });
        let $departForm = $('#departForm');
        //validate space in form fields
        $.validator.addMethod("noSpace", function (value, element){
            return value == '' || value.trim().length != 0
        }, "Spaces are not allowed");
        if($departForm .length){
            $departForm .validate({
                rules:{
                    departname: {
                        required: true,
                        noSpace: true
                    },
                    departaddress: {
                        required: true,
                        noSpace: true
                    },
                    departcode: {
                        required: true,
                        noSpace: true
                    },
                },
                messages:{
                    departname: {
                        required: "Please enter DepartmentName"
                    },
                    departaddress: {
                        required: "Please enter DepartmentAddress"
                    },
                    departcode: {
                        required: "Please enter a valid DepartmentCode"
                    },
                },
                submitHandler: function(form,e) {
                    e.preventDefault();
                    console.log('Form submitted');
                    //CALL METHOD FOR CREATING A NEW USER
                    createDepart();
                }
            });


        }
        function createDepart(){
            //PREPARE FORM DATA
            var formData = {
                departName : $("#departName").val(),
                departAddress : $("#departAddress").val(),
                departCode  : $("#departCode").val()
            }
            console.log(formData);
            //DO POST
            $.ajax({
                type : "POST",
                contentType: "application/json; charset=utf-8",
                url : "http://localhost:9092/api/v1/departments/create",
                data : JSON.stringify(formData),
                dataType : 'json',
                success : function(result){
                    if(result){
                        $('#departForm')[0].reset()
                        alert("Department CREATED PROPERLY!");
                    }else{
                       alert("Something went wrong");
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
//DataTable for Department
var data = "";
function getAllDepartsRecord() {
    $
        .ajax({
            type : "GET",
            url : "http://localhost:9092/api/v1/departments/all",
            success : function(response) {
                data = response
                console.log(data);
                $('.tr').remove();
                for (count = 0; count < data.length; count++) {
                    $("#departsTable")
                        .append(
                            '<tr class="tr"> <td>'
                            + data[count].departId
                            + '</td> <td>'
                            + data[count].departName
                            + '</td> <td>'
                            + data[count].departAddress
                            + '</td> <td>'
                            + data[count].departCode
                            + '</td> <td><input type="button" class="btn btn-warning" onclick="editDepart('
                            + data[count].userId
                            + ')"  value="Edit"/></td> <td> <input type="button" class="btn btn-danger" onclick="deleteDepart('
                            + data[count].userId
                            + ');" value="Delete"/></td> </tr>');
                }
            },
            error : function(err) {
                alert("error is" + err)
            }
        });
}