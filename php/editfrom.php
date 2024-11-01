
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
    
    <h1>Edit Student Form</h1>
    <form action="table.php" method="post">
    <?php while($row = mysqli_fetch_assoc($result3)){?>
        <input type="hidden" name="id" id="id" value="<?php echo $row["id"]?>"><br><br>
        Name:
        <input type="text" name="name" id="name" value="<?php echo $row["name"]?>"><br><br>
        Email:
        <input type="email" name="email" id="email" value="<?php echo $row["email"]?>"><br><br>
        Password:
        <input type="password" name="password" id="password" value="<?php echo $row["password"]?>"><br><br>
        <?php } ?>

        <button name="update">Update</button> 

        <button type="reset">Reset</button>
    </form>

</body>
</html>
