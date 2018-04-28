<?php
$username = $_GET['username'];
$password = $_GET['password'];
$error = $_GET['error'];

$url= "http://localhost:8080/onlinemarket/signin?username=".$username."&password=".$password;
$json= file_get_contents($url);
$result= json_decode($json, true);

if ($result)
{
	header("Location: SelectYourType.html");
}
else
{
	header("Location: Log In.html");
	$error = "Invalid username or password";
}

?>