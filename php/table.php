
<?php

include "query.php";

$con = mysqli_connect("localhost","root","","myDb");
$sql = "select id,name,email,password from student";
$result = mysqli_query($con,$sql);
mysqli_close($con);
?>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Data-Table-Page</title>
</head>
<body>

<form action="table.php" method="post">
<button name="add">Add New</button>
</form>

    <table class="table" border="1">
        <thead>
            <tr>
            <th>Roll no.</th>
            <th>Name</th>
            <th>Email</th>
            <th>Password</th>
            <th>Acivity</th>
            </tr>
        </thead>
        <tbody>
            <?php while($row = mysqli_fetch_assoc($result)){?>
            <tr>
                <td><?php echo $row["id"]?></td>
                <td><?php echo $row["name"]?></td>
                <td><?php echo $row["email"]?></td>
                <td><?php echo $row["password"]?></td>
                <td>
                    <form action="editfrom.php" method="post">
                    <button name="edit" value="<?php echo $row["id"]?>">edit</button>
                    </form>
                    <form action="table.php" method="post">
                <button name="delete" value="<?php echo $row["id"]?>">delete</button>
                    </form>
            </td>
            </tr>
            <?php } ?>
        </tbody>
    </table>
</body>
</html>
