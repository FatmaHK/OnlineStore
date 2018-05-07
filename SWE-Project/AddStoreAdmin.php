<?php
$name = $_GET['name'];
$type = $_GET['type'];
$ownerName = $_GET['ownerName'];
$location = $_GET['location'];

$url= "http://localhost:8080/onlinemarket/addstore/request?name=".$name."&type=".$type."&ownerName=".$ownerName."&location=".$location;
$json= file_get_contents($url);
$result= json_decode($json, true);
if ($result==false){
header("Location: Invalid.html");	
	
}
else
{
header("Location: StoreOwner.html");
}
?>