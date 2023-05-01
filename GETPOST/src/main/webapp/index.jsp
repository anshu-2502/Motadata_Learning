<!DOCTYPE html>
<html>
<head>
    <title>jQuery Form Example</title>
    <link
            rel="stylesheet"
            href="//netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css"
    />
    <script src="getpost.js"></script>


</head>
<body>
<div class="col-sm-6 col-sm-offset-3">
    <h1>FORM</h1>

    <form action=submit method="post" >
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

        <button type="submit" value="submit" class="btn btn-warning">
            POST
        </button>

        <button type="submit" class="btn btn-info">
            GET
        </button>
    </form>

</div>
</body>
</html>

