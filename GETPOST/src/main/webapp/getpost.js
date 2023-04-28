
$(document).ready(function () {
    $("form").submit(function (event) {
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

        event.preventDefault();
    });
});