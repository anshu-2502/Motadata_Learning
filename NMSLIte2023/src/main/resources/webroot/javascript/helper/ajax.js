$(document).ready(function (){


    $("#form1").submit(function (event){

        console.log("in ajax")

        console.log($("#devicename").val())

        var credentials={
            username: $("#username").val(),

            password: $("#password").val(),
        }

        var formData={

            devicename: `${$("#devicename").val()}`,

            deviceip: $("#deviceip").val(),

            type: $("#myselection").val(),

            credentials: credentials,


        };

        console.log(formData)

        var url = "http://localhost:8080/adddevice"

        var type="POST"

        var data= formData

        AjaxCall(url,type,postCall,data);

    });



    function AjaxCall(url, type, getpost,data){

        console.log("inajax2")

        $.ajax({

            type: type,

            url: url,

            data: JSON.stringify(data),

            dataType: "json",

            encode: true,

            success: function (data) {

                console.log(data)
            }
        })
    }
    function postCall(data){
        console.log(data)
    }





})