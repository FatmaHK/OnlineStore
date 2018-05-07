<h1>Available Statistics</h1>
	<?php
	$url1= "http://localhost:8080/onlinemarket/getAvailableStatistics/";
	$json1= file_get_contents($url1);
	$result1= json_decode($json1, true);
	for($i=0; $i<sizeof($result1); $i++){
		echo $result1[$i]['name']."<br>";
		echo"<form action='addinPanel.php' method='get' class='requestList'>
					<input type='text' name='sname' placeholder='Name Of Store'>
					<input type='hidden' name='sId' value=".$result1[$i]['id'].">
					<br><br>
					<input type='submit' value='Add to panel'>
					<br><br><br><br>";
	} 
	?>
</div>

<br><br><br><br>