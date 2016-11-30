<?php
    $con = mysqli_connect("localhost", "id188612_gnb", "abcd1234", "id188612_green");
    
    $scientific = $_POST["scientific"];
    
    $statement = mysqli_prepare($con, "SELECT * FROM wildlife WHERE scientific = ?");
    mysqli_stmt_bind_param($statement, "s", $scientific);
    mysqli_stmt_execute($statement);
    
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $scientific, $common, $family, $status, $class, $info);
    
    $response = array();
    $response["success"] = false;  
    
    while(mysqli_stmt_fetch($statement)){
        $response["success"] = true;  
        $response["scientific"] = $scientific;
        $response["common"] = $common;
        $response["family"] = $family;
	$response["status"] = $status;
        $response["class"] = $class;
        $response["info"] = $info;
    }
    
    echo json_encode($response);
?>