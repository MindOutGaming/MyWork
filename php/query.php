
<?php
    $con = mysqli_connect("localhost","root","","myDb");
if(isset($_REQUEST['add'])){
    header("location:from.php");
}
if(isset($_REQUEST['edit'])){
$id = $_POST['edit'];
$sql = "select * from student where id = '".$id."';";
    $result3 = mysqli_query($con,$sql);
    if($result3){
    mysqli_close($con);
    }
}
if(isset($_REQUEST['delete'])){

    $id = $_POST['delete'];
    $sql = "delete from student where id = '".$id."';";
    $result1 = mysqli_query($con,$sql);
    if($result1){
        echo "<script>alert('Student Deleted Successfully!')</script>";
        mysqli_close($con);

    }    
}if(isset($_REQUEST['btn'])){

    $name = $_POST['name'];
    $email = $_POST['email'];
    $pass = $_POST['password'];
    $sql = "insert into student(name,email,password) values('".$name."','".$email."','".$pass."');";
    $result2 = mysqli_query($con,$sql);
    if($result2){
        echo "<script>alert('Add New Student Successfully!')</script>";
        mysqli_close($con);
    }   
}if(isset($_REQUEST['update'])){

    $id = $_POST['id'];
    $name = $_POST['name'];
    $email = $_POST['email'];
    $pass = $_POST['password'];
    $sql = "update student set name='".$name."',email='".$email."',password='".$pass."' where id='".$id."';";
    $result4 = mysqli_query($con,$sql);
    if($result4){
        echo "<script>alert('Update Student Successfully!')</script>";
        mysqli_close($con);
    }   
}

?>