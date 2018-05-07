<?php
$name = $_GET['name'];
$price = $_GET['price'];
$type = $_GET['type'];
$brand = $_GET['brand'];
$quantity = $_GET['quantity'];

$url= "http://localhost:8080/onlinemarket/addproduct?name=".$name."&price=".$price."&type=".$type."&brand=".$brand."&quantity=".$quantity;
$json= file_get_contents($url);
$result= json_decode($json, true);

header("Location: Administrator.html");

?>