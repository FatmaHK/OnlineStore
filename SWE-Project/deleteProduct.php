<?php
$productName = $_GET['pname'];
$StoreName = $_GET['sname'];


$url="http://localhost:8080/onlinemarket/deleteProductFromStore/".$StoreName."/".$productName;
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