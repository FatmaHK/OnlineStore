<?php
$storename = $_GET['storename'];
$email = $_GET['email'];

$url= "http://localhost:8080/onlinemarket/add-collaborator/?email=".$email."&sName=".$storename;
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