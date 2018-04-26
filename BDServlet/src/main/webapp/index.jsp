<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Sign up</title>
    <link rel="stylesheet", href="css/style.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
</head>
<body>
<div class="center">
    <form class="form-group"
          name="Form1"
          method="post"
          action="profile1">
        <label for="fname" id="fnamelabel">First Name<span style='color:red' id='namef'></span><br /></label>
        <input type="text" id="fname" name="firstname" placeholder="Your name.." class="form-control">
        <label for="email">Email</label>
        <input type="text" id="email" name="email" placeholder="Your email..." class="form-control">
        <label for="email">Password</label>
        <input type="text" id="password" name="password" placeholder="Your password..." class="form-control">
    <div class="col-auto">
        <input type="submit" value="Submit" class="btn btn-primary" id="btn">
    </div>
    </form>
</div>
<script type='text/javascript' src='https://code.jquery.com/jquery-latest.min.js'></script>
<script type='text/javascript' src='js/saveform.js'></script>
<script type="text/javascript" src="js/scrip.js"></script>
</body>
</html>