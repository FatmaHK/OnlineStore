<html>
<?php
$storename = $_GET['storename'];
$url= "http://localhost:8080/onlinemarket/get-Statistics/".$storename;
$json= file_get_contents($url);
$result= json_decode($json, true);

?>
<div>
	<form action="addToPanel.php" method="get">
		<?php echo "<input type='hidden' name='atorename' value=".$storename.">
		<input type='submit' value='Add Statistics to panel'>";?>
	</form>

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