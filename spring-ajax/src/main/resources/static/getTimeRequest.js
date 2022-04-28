$(document).ready(
    function() {
        $("#time").click(function (event) {
            event.preventDefault();
            $.ajax({
                type: "GET",
                url: 'getTime',
                success: function (data) {
                    $('#printTime').html(data)
                }

            });
        });
    });