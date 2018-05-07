<?php
$name = $_GET['name'];
$username = $_GET['username'];
$email = $_GET['email'];
$password = $_GET['password'];
$type = $_GET['type'];


$url= "http://localhost:8080/onlinemarket/signup?name=".$name."&username=".$username."&email=".$email."&password=".$password."&type=".$type;
$json= file_get_contents($url);
$result= json_decode($json, true);


echo $result['type'];
if ($result['type'] == "Buyer")
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