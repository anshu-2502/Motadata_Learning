<!DOCTYPE html>
<html>
<head>
    <title>jQuery Form Example</title>
    <link
            rel="stylesheet"
            href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
    />
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>

    <script type="text/javascript" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>

    <link
            rel="stylesheet"
            type="text/css"
            href="http://ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/css/jquery.dataTables.css"
    />


    <script src="getpost.js"></script>


</head>
<body>
<div class="col-sm-6 col-sm-offset-3">
    <h1>FORM</h1>

    <form id="form1" method="post" >
        <div id="name-group" class="form-group">
            <label for="name">Name</label>
            <input
                    type="text"
                    class="form-control"
                    id="name"
                    name="name"
                    placeholder="Full Name"
            />
        </div>

        <div id="email-group" class="form-group">
            <label for="email">Email</label>
            <input
                    type="text"
                    class="form-control"
                    id="email"
                    name="email"
                    placeholder="johndoe@example.com"
            />
        </div>

        <div id="hobby-group" class="form-group">
            <label for="hobbies">Hobbies</label>
            <input
                    type="text"
                    class="form-control"
                    id="hobbies"
                    name="Hobbies"
                    placeholder="Singing, Dancing , Reading"
            />
        </div>

        <button id="post" type="submit" value="submit" class="btn btn-warning">
            POST
        </button>
    </form>

    <div>

        <br>
        <button id ="show" class="btn btn-info">
            GET
        </button>
    </div>

    <BR>

    <div><h3>INFORMATION</h3></div>

    <div style = "width: 700px; padding: 5px; border: 1px solid black;">
        <table id = "datatable">
            <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Hobbies</th>
            </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>

</div>




</body>
</html>

