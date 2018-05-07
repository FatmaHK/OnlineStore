<?php
$productName = $_GET['pname'];
$storeName = $_GET['sname'];
$price = $_GET['price'];
$quantity = $_GET['quantity'];


$url="http://localhost:8080/onlinemarket/addProductToStore/".$storeName."/".$productName."/".$quantity."/".$price;
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