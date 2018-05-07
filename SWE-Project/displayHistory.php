<html>


    <head>
        <title>Requests</title>
      
        <link href="css/style.css" rel="stylesheet">
		
    </head>
    <body>
        <div class="Admin">
            <div class="navbar">
                <div class="container">
                    <div class="logo">
                        <h1>Phenomena</h1>
                    </div>
                    <div class="links">
                        <ul>
                            <li class="active"><a href="Home.html"> Home</a></li>
                            <li><a href="Log%20In.html">Sign In</a></li>
                            <li><a href="SignUp.html">Sign Up</a></li>
                            <li><a href="SelectYourType.html">Select your Type</a></li>
							<li><a href="Log%20In.html">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </div>
			<form action="" method="get">
				<input type="text" name="sname" required placeholder="Store Name">
				<input type="submit" value="Get history" class='btnAccept'>
			</form>
            <?php 
				$sname = $_GET['sname'];
				if(isset($sname)){
					$url= "http://localhost:8080/onlinemarket/history/".$sname;
                $json= file_get_contents($url);
                $result= json_decode($json, true);
				if(sizeof($result) == 0){
					echo "<br><br>No History!";
				}
                for($i=0; $i<sizeof($result); $i++){
                    echo"<form action='undo.php' method='get' class='requestList'>
					<input type='hidden' name='sId' value=".$result[$i]['store']['id'].">
					<input type='hidden' name='aId' value=".$result[$i]['action']['id'].">
					 ".$result[$i]['action']['name'];
					
					echo "<input type='submit' value='Undo' name='submit' class='btnAccept'>
						</form>";
                }
				}
            ?>
            
        </div>
        
        
        
        
        <script src="JQuery/jquery-3.3.1.min.js"></script>
        <script src="JQuery/script.js"></script>
    </body>
</html>
            