<html>
<div>
	<h1>Available Statistics</h1>
	<table border=2 width="30%">
	<?php
	$storename = $_GET['storename'];
	$url1= "http://localhost:8080/onlinemarket/getAvailableStatistics/";
	$json1= file_get_contents($url1);
	$result1= json_decode($json1, true);
	for($i=0; $i<sizeof($result1); $i++){
		echo"<tr><td>".$result1[$i]['name']."</td>
		<td><button style='width: 100px'>Add to panel</button></td>
		</tr>";
	} 
	?>
	</table>
</div>

<br><br><br><br>

<?php
$storename = $_GET['storename'];
$url= "http://localhost:8080/onlinemarket/get-Statistics/".$storename;
$json= file_get_contents($url);
$result= json_decode($json, true);

?>

<h1>Statistics Panel</h1>
<table border=2 width="50%">
	<tr>
		<th>Statistic</th>
		<th>Value</th>
	</tr>
	<?php
		foreach ($result as $stat){
			echo"<tr>
			<td>".$stat['statName']."</td>
			<td>".$stat['statEntity']."</td>
			</tr>";
		} 
	?>
	
</table>
</html>