<?php
$username = $_GET['username'];
$productname = $_GET['productname'];
$storeName = $_GET['storeName'];
$requiredAmount=$_GET['requiredAmount'];

$url= "http://localhost:8080/onlinemarket/buyproduct/".$username."/".$storeName."/".$productname."/".$requiredAmount;
$json= file_get_contents($url);
$result= json_decode($json, true);

if ($result==-1)
{
	header("Location: reject.php");
	}
else
{
	header("Location: added.php");
	
}
?>