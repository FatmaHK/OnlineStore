<?php
$sname=$_GET['sname'];
$sId=$_GET['sId'];

$url1= "http://localhost:8080/onlinemarket/addToPanel/".$sname."/".$sId;
	$json1= file_get_contents($url1);
	$result1= json_decode($json1, true);
	
	header("Location: statistics.php");
	
	?>