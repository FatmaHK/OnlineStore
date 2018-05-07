<?php
$submit = $_GET['submit'];
$name = $_GET['name'];
if($submit=="Accept"){
	$url1= "http://localhost:8080/onlinemarket/addstore/accept-request/?name=".$name;                $json1= file_get_contents($url1);
    $json1= file_get_contents($url1);
	header("Location: added.php");
	
}
else{
	$url1= "http://localhost:8080/onlinemarket/addstore/reject-request/?name=".$name;                $json1= file_get_contents($url1);
    $json1= file_get_contents($url1);
	header("Location: reject.php");
}

?>