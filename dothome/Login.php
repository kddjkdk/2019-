<?php    $con = mysqli_connect("localhost", "giantstar115", "Rmaghk^^47", "giantstar115");
    mysqli_query($con,'SET NAMES utf8');

    $id = $_POST["userID"];
    $password = $_POST["userPass"];

    $statement = mysqli_prepare($con, "SELECT * FROM USER WHERE userID = ? AND userPass = ?");
    mysqli_stmt_bind_param($statement, "ss", $id, $password);
    mysqli_stmt_execute($statement);


    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $id, $password, $name, $phoneNumber, $eamil);

    $response = array('success'=>'false');
    //$response["success"] = false;
    while(mysqli_stmt_fetch($statement)) {
        $response["success"] = true;
        $response["userID"] = $id;
        $response["userPass"] = $password;
        $response["userName"] = $name;
        $response["userPhone"] = $phoneNumber;
        $response["userEamil"] = $eamil;
    }

    $json = json_encode($response);
    echo $json;
?>
