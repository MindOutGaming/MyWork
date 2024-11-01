
<?php
include "query.php";
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form-Page</title>
</head>
<body>
    
    <h1>Add Student Form</h1>
    <form action="table.php" method="post">
        Name:
        <input type="text" name="name" id="name"><br><br>
        Email:
        <input type="email" name="email" id="email"><br><br>
        Password:
        <input type="password" name="password" id="password"><br><br>

        <button name="btn">Submit</button> 

        <button type="reset">Reset</button>
    </form>

</body>
</html>
