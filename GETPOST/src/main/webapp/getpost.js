$(document).ready(function () {

    var ajaxOptions = {

      "url": url, "type": type, "method": method, "data": data

    };


    $("#form1").submit(function (event) {

        var formData = {

            name: $("#name").val(),

            email: $("#email").val(),

            hobbies: $("#hobbies").val(),

        };

        var url = "http://localhost:8080/submit"

        var type = "POST"

        var data = formData

        AjaxCall(url,type,postCall,data);

    });

    //
    // $("#post").click(function(){
    //
    //
    // });

    $("button#show").click(function (){

        var url = "http://localhost:8080/get"

        var type = "GET"

        AjaxCall(url, type, getCall)


    });



    function AjaxCall(url, type, getpost, data) {
            $.ajax({

                type: type,

                url: url,

                data: data,

                dataType: "json",

                encode: true,

                success: function (data) {

                   getpost(data)
                }

            })

    }

    function postCall(data){

        console.log(data);
    }

    function getCall(data){

        console.log(data.result);

        let aData = $.parseJSON(data.result);

        $("#datatable").dataTable().fnDestroy();

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
        })

    }




});