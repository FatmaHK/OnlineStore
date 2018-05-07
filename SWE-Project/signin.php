<?php
$username = $_GET['username'];
$password = $_GET['password'];
//$error = $_GET['error'];

$url= "http://localhost:8080/onlinemarket/signin?username=".$username."&password=".$password;
$json= file_get_contents($url);
$result= json_decode($json, true);

if ($result['type'] == "buyer")
{
	header("Location: Buyer.html");
}
else if($result['type'] == "store owner")
{
	header("Location: StoreOwner.html");
}
else if($result['type'] == "Admin")
{
	header("Location: Administrator.html");
}
else if($result['type'] == "collaborator")
{
	header("Location: Collaborator.html");
}

else{
	
	header("Location: Invalid.html");

}
?>