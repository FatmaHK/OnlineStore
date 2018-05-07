<?php

$StoreName = $_GET['sname'];
$ProductID = $_GET['oldId'];
$price = $_GET['price'];
$quantity = $_GET['quantity'];

$url= "http://localhost:8080/onlinemarket/editProductToStore/".$StoreName."/".$ProductID."?quantity=".$quantity."&price=".$price;
$json= file_get_contents($url);
$result= json_decode($json, true);

if ($result)
{
	header("Location: added.php");
}
else
{
header("Location: reject.php");
}


?>