<?php
$name = $_GET['name'];
$username = $_GET['username'];
$email = $_GET['email'];
$password = $_GET['password'];

$url= "http://localhost:8080/onlinemarket/signup?name=".$name."&username=".$username."&email=".$email."&password=".$password;
$json= file_get_contents($url);
$result= json_decode($json, true);

if ($result)
{
	header("Location: SelectYourType.html");
}
else
{
echo "invalid data";
}

?>