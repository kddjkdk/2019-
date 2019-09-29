<?php
    $con = mysqli_connect("localhost", "giantstar115", "Rmaghk^^47", "giantstar115");
    mysqli_query($con,'SET NAMES utf8');

    $id = $_POST["userID"];
    $password = $_POST["userPass"];
    $name = $_POST["userName"];
    $phoneNumber = $_POST["userPhone"];
    $email = $_POST["userEmail"];

    $statement = mysqli_prepare($con, "INSERT INTO USER VALUES (?,?,?,?,?)");
    mysqli_stmt_bind_param($statement, "sssss", $id, $password, $name, $phoneNumber, $email);
    mysqli_stmt_execute($statement);


    $response = array('success'=>'true');
    //$response["success"] = true;
    $json=json_encode($response);
    echo $json;



?>
