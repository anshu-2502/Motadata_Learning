$(document).ready(function(){
    $("#myBtn").click(function(){
        $("#myModal").modal();
    });
});


var showssh = $(function () {
        $("#myselection").change(function () {
            if ($(this).val() == "ssh") {
                $("#sshcall").show();
            } else {
                $("#sshcall").hide();
            }
        });
    });

$(document).ready(function() {

    $.ajax({
        url:'http://localhost:8080/getdata',
        type: 'GET',
        dataType: 'json',

        success: function (data)
        {
            JSON.stringify(data);

            $('#myTable').DataTable({

                data: data,

                columns: [
                    { title: 'device_id',  data: 'device_id'},
                    { title: 'device_ip',   data: 'device_ip' },
                    { title: 'device_name', data: 'device_name' },
                    { title: 'device_type', data: 'device_type' },
                    { title: 'action', data:'null',
                        render: function (data, type, row) {

                            return `
            <button class="btn btn-primary" >Edit</button>
            <button class="btn btn-danger">Delete</button>
            <button class="btn btn-info">Run</button> `;
                        }
                    }
                ]
            });
        }
    })

});

























//
// $("form").submit(function (e) {
//     e.preventDefault();
//     var name = $("input[name='name']").val();
//     var email = $("input[name='email']").val();
//
//     $(".data-table tbody").append("<tr nameHere='" + name + "' emailHere='" + email + "'><td>" + name + "</td><td>" + email + "</td><td><button class='btn btn-info btn-edit ms-2 mt-2'>Edit</button><button class='btn btn-danger btn-delete ms-2 mt-2'>Delete</button></td></tr>");
//
//     $("input[name='name']").val('');
//     $("input[name='email']").val('');
// });
//
// $("body").on("click", ".btn-delete", function () {
//     $(this).parents("tr").remove();
// });
//
// $("body").on("click", ".btn-edit", function () {
//     var name = $(this).parents("tr").attr('nameHere');
//     var email = $(this).parents("tr").attr('emailHere');
//
//     $(this).parents("tr").find("td:eq(0)").html('<input name="edit_name" class="form-control" value="' + name + '">');
//     $(this).parents("tr").find("td:eq(1)").html('<input name="edit_email" class="form-control" value="' + email + '">');
//
//     $(this).parents("tr").find("td:eq(2)").prepend("<button class='btn btn-info btn-update ms-2 mt-2'>Update</button><button class='btn btn-warning btn-cancel ms-2 mt-2'>Cancel</button>")
//     $(this).hide();
// });
//
// $("body").on("click", ".btn-cancel", function () {
//     var name = $(this).parents("tr").attr('nameHere');
//     var email = $(this).parents("tr").attr('emailHere');
//
//     $(this).parents("tr").find("td:eq(0)").text(name);
//     $(this).parents("tr").find("td:eq(1)").text(email);
//
//     $(this).parents("tr").find(".btn-edit").show();
//     $(this).parents("tr").find(".btn-update").remove();
//     $(this).parents("tr").find(".btn-cancel").remove();
// });
//
// $("body").on("click", ".btn-update", function () {
//     var name = $(this).parents("tr").find("input[name='edit_name']").val();
//     var email = $(this).parents("tr").find("input[name='edit_email']").val();
//
//     $(this).parents("tr").find("td:eq(0)").text(name);
//     $(this).parents("tr").find("td:eq(1)").text(email);
//
//     $(this).parents("tr").attr('nameHere', name);
//     $(this).parents("tr").attr('emailHere', email);
//
//     $(this).parents("tr").find(".btn-edit").show();
//     $(this).parents("tr").find(".btn-cancel").remove();
//     $(this).parents("tr").find(".btn-update").remove();
// });
