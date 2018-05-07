<?php
$edit = $_GET['edit'];
$statname = $_GET['statname'];
$url="";
if($edit == "Add Statistic"){
	$url= "http://localhost:8080/onlinemarket/addStatistics/".$statname;
	$json= file_get_contents($url);
}
else if($edit == "Remove Statistic"){
	$url= "http://localhost:8080/onlinemarket/removeStatistics/".$statname;
	$json= file_get_contents($url);
}
//$result= json_decode($json, true);
header("Location: Administrator.html");
?>