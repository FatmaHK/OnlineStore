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
            <?php 
                $url1= "http://localhost:8080/onlinemarket/addstore/get-all-request";
                $json1= file_get_contents($url1);
                $result1= json_decode($json1, true);
				if(sizeof($result1) == 0){
					echo "<br><br>No Requests!";
				}
                for($i=0; $i<sizeof($result1); $i++){
                    echo"<form action='ManageRequest.php' method='get' class='requestList'>
					<input type='hidden' name='name' value=".$result1[$i]['name'].">
					Store name: ".$result1[$i]['name']."<br>Type: ".$result1[$i]['type'].
					"<br>Owner name: ".$result1[$i]['ownerName']."<br>Location: ".$result1[$i]['location'].
					"<br>";
					
					echo "<input type='submit' value='Accept' name='submit' class='btnAccept'>
					<input type='submit' value='Reject' name='submit' class='btnAccept'>
						<br><br><br></form>";
                }
            ?>
            
        </div>
        
        
        
        
        <script src="JQuery/jquery-3.3.1.min.js"></script>
        <script src="JQuery/script.js"></script>
    </body>
</html>
            