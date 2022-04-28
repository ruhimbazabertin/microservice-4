$(document).ready(
    function (){
        //CALL METHOD TO DISPLAY DEPART DATA IN DROPDOWN FOR USER
        loadDepartments();
        //CALL METHOD TO DISPLAY USER DATA TABLE
        getAllUsersWithDepartments();
        //JQUERY FORM VALIDATION FOR USER
            let $userForm = $('#userForm');
        //validate space in form fields
        $.validator.addMethod("noSpace", function (value, element){
            return value == '' || value.trim().length != 0
        }, "Spaces are not allowed");
            if($userForm.length){
                $userForm.validate({
                    rules:{
                        firstname: {
                            required: true,
                            noSpace: true
                        },
                        lastname: {
                            required: true,
                            noSpace: true
                        },
                        email: {
                            required: true,
                            email: true,
                            noSpace: true
                        },
                        department: {
                            required: true,
                            noSpace: true
                        }
                    },
                    messages:{
                        firstname: {
                            required: "Please enter firstName"
                        },
                        lastname: {
                            required: "Please enter lastName"
                        },
                        email: {
                            required: "Please enter a valid email"
                        },
                        department: {
                            required: "Please select department"
                        }
                    },
                   submitHandler: function(form,e) {
                       e.preventDefault();
                       console.log('Form submitted');
                       //CALL METHOD FOR CREATING A NEW USER
                       createUser();
                   }
                });


            }

        $("#editUserButton").click(function(event){
            event.preventDefault()
            updateUser();
            //getAllUsersRecord();
        })
    })
        function createUser(){
            //PREPARE FORM DATA
            var formData = {
                firstName : $("#firstName").val(),
                lastName : $("#lastName").val(),
                email  : $("#email").val(),
                departId  : $("#userDepartDropDown").val()
            }
            console.log(formData);
            //DO POST
            $.ajax({
                type : "POST",
                contentType: "application/json; charset=utf-8",
                url : "http://localhost:8090/api/v1/users/create",
                data : JSON.stringify(formData),
                dataType : 'json',
                success : function(result){
                    if(result){
                        $('#userForm')[0].reset()
                        alert("USER CREATED PROPERLY!");
                        getAllUsersWithDepartments();
                    }else{
                        alert("Something went wrong");
                    }
                    },
                error : function(e){
                    alert("Error!")
                    console.log("ERROR: ", e);
                }
            });
        }

        //DataTable for users
        var data = "";
        function getAllUsersWithDepartments() {
            //make request for departments
            let departments = null
            $
                .ajax({
                    type : "GET",
                    url: "http://localhost:9092/api/v1/departments/all",
                    success : function(response) {
                        departments = response
                        console.log(departments);
                    }
                    });
            $
                .ajax({
                    type : "GET",
                    url : "http://localhost:8090/api/v1/users/all",
                    success : function(response) {
                        data = response
                        console.log(data);
                        for (count = 0; count < data.length; count++) {
                            $("#usersTable")
                                .append(
                                    '<tr class="tr"> <td>'
                                    + data[count].userId
                                    + '</td> <td>'
                                    + data[count].firstName
                                    + '</td> <td>'
                                    + data[count].lastName
                                    + '</td> <td>'
                                    + data[count].email
                                    + '</td> <td>'
                                    + departments.filter(item=>item.departId==data[count]['departId']).map(item=>item.departName)
                                    + '</td> <td>'
                                    + departments.filter(item=>item.departId==data[count]['departId']).map(item=>item.departCode)
                                    + '</td> <td>'
                                    + departments.filter(item=>item.departId==data[count]['departId']).map(item=>item.departAddress)
                                    + '</td> <td>'
                                   + '<input type="button" class="btn btn-primary"  data-toggle="modal" data-target="#userEditModel" id="editUserButton" onclick="editUser('
                                    + data[count].userId
                                    + ')"  value="Edit"/></td> <td> <input type="button"  class="btn btn-danger" id="deleteButton" onclick="deleteUser('
                                    + data[count].userId
                                    + ');" value="Delete"/></td> </tr>');
                        }
                    },
                    error : function(err) {
                        console.log(err);
                        alert("SOMETHING WENT WRONG")
                    }
                });

        }


function loadDepartments(){
     url = 'http://localhost:9092/api/v1/departments/all';
    $.get(url, function(response){
        userDepartDropDown.innerHTML = '';
        $.each(response, function (index, depart){
            $("<option>").val(depart.departId).text(depart.departName).appendTo(userDepartDropDown);
        });
    }).done(function (){
    }).fail(function(){
    });
}
function loadDepartsForEditing(){
        url = 'http://localhost:9092/api/v1/departments/all';
        $.get(url, function(response){
            console.log(response);
            EditUserDepartDropDown.innerHTML = '';
            $.each(response, function (index, depart){
                $("<option>").val(depart.departId).text(depart.departName).appendTo(EditUserDepartDropDown);
            });
        }).done(function (){
        }).fail(function(){
        });
}
function editUser(id) {
//CALL loadDepartsForEditing TO BE LOADED IN USER EDIT MODEL
    loadDepartsForEditing();
    $.ajax({
        type: "GET",
        url: 'http://localhost:8090/api/v1/users/single/' + id,
        dataType: 'json',
        success: function (response) {
            console.log(response)
            $('#user_id').val(response.userId),
                $("#first_name").val(response.firstName),
                $("#last_name").val(response.lastName),
                $("#userEmail").val(response.email),
                $("#userDepartDropDown").val(response.departId)

        }
    });
}
    function updateUser(){
    //PREPARE FORM DATA
    let formData = {
        userId: $("#user_id").val(),
        firstName : $("#first_name").val(),
        lastName : $("#last_name").val(),
        email  : $("#userEmail").val(),
        departId  : $("#EditUserDepartDropDown").val()

    }

    console.log(formData);
    //DO POST
    $.ajax({
        type : "POST",
        contentType: "application/json; charset=utf-8",
        url : "http://localhost:8090/api/v1/users/create",
        data : JSON.stringify(formData),
        dataType : 'json',
        success : function(result){
            if(result){
                $('#userEditModel').modal('hide');
                alert("USER UPDATED PROPERLY");
               // getAllUsersWithDepartments();
            }else{
                alert("SOMETHING WENT WRONG");
            }

        },
        error : function(e){
            alert("Error!")
            console.log("ERROR: ", e);
        }
    });
    }

function deleteUser(id){
    $.ajax({
        method : 'DELETE',
        url: 'http://localhost:8090/api/v1/users/delete/'+ id,
        success: function (){
            alert("USER DELETED PROPERLY!");
           // getAllUsersWithDepartments();
        },
        error: function(error){
            alert(error);
        }
    })

}
