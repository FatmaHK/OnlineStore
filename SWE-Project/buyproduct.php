<?php
$username = $_GET['username'];
$productname = $_GET['productname'];
$storeName = $_GET['storeName'];
$requiredAmount=$_GET['requiredAmount'];

$url= "http://localhost:8080/onlinemarket/buyproduct/".$username."/".$storeName."/".$productname."/".$requiredAmount;
$json= file_get_contents($url, false);

//echo "success operation ";
	//header("Location: Home.html");

	//header("Location: Buyer.html");
//	echo "Invalid Information";

?>