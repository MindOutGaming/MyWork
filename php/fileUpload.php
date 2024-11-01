<?php
if(isset($_REQUEST['upload'])){
    $fileName = $_FILES['file']['name'];
    $temp = $_FILES['file']['tmp_name'];
    if (move_uploaded_file($temp,"D:/wamp64/tmp/myFile/".$fileName)) {
        echo "<script>alert('File uploaded')</script>";
    }else{
        echo "<script>alert('File can't upload')</script>";
    }
}
?>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>File-Upload</title>
</head>
<body>
    <center>
    <form action="fileUpload.php" method="post" enctype="multipart/form-data">
        <label for="file">import File:-</label><br><br>
        <input type="file" id="file" name="file" placeholder="import file here..."><br><br>
        <button name='upload'>UPLOAD</button>
    </form><br><br>
    <a download="<?= $fileName?>" href="D:/wamp64/tmp/myFile/<?= $fileName?>">download file here..</a>
    </center>
</body>
</html>