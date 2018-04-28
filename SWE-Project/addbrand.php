<?php
$brandName = $_GET['bname'];
$storeName = $_GET['sname'];


$url="http://localhost:8080/onlinemarket/addBrandToStore/".$storeName."/".$brandName;
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