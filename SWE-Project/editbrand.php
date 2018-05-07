<?php
$brandID = $_GET['brandID'];
$BrandName= $_GET['BrandName'];
$category=$_GET['category'];

$url="http://localhost:8080/onlinemarket/editBrandInStore"."&brandID=".$brandID."&BrandName=".$BrandName."&category=".$category;
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