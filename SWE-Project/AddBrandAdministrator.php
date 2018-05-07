<?php
$brandname = $_GET['brandname'];
$brandcategory = $_GET['brandcategory'];
//$error = $_GET['error'];

$url= "http://localhost:8080/onlinemarket/addbrand?name=".$brandname."&category=".$brandcategory;
$json= file_get_contents($url);
$result= json_decode($json, true);

if ($result)
{   echo "added successfully";
	header("Location: Administrator.html");
}
else
{
	header("Location: Administrator.html");
	//$error = "Invalid Information";
}

?>