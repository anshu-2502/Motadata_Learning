$(document).ready(function () {

    $("#form1").submit(function (event) {
        var formData = {
            name: $("#name").val(),
            email: $("#email").val(),
            hobbies: $("#hobbies").val(),
        };

        $.ajax({
            type: "POST",
            url: "http://localhost:8080/submit",
            data: formData,
            dataType: "json",
            encode: true,
        }).done(function (data) {

            console.log(data);

        });


    });

    $("button#show").click(function (){
        $.ajax({
            type: "GET",
            url: "http://localhost:8080/get",
            dataType: "json",

            success: function (data) {

                console.log(data.result);

                let aData = $.parseJSON(data.result);

                // for(var i in data.result)
                // {
                //     $("p#result").html(data.result);
                // }

                $("#datatable").DataTable({
                    data: aData,

                    columns: [
                        {
                            data: 'name'
                        },
                        {
                            data: 'email'
                        },
                        {
                            data: 'hobbies'
                        }
                    ]

                });
            }
        });

    });


});