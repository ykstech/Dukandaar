<?php 

require_once 'config.php';

$response = array();

if(isset($_GET['apicall'])){

switch($_GET['apicall']){

case 'signup':
if(isTheseParametersAvailable(array('username','email','password','gender'))){
$username = $_POST['username']; 
$email = $_POST['email']; 
$password = md5($_POST['password']);
$gender = $_POST['gender']; 


$stmt = $conn->prepare("SELECT id FROM users WHERE username = ?");
$stmt->bind_param("s", $username);
$stmt->execute();
$stmt->store_result();


$stmt1 = $conn->prepare("SELECT id FROM users WHERE email = ?");
$stmt1->bind_param("s", $email);
$stmt1->execute();
$stmt1->store_result();

if($stmt->num_rows > 0){
$response['error'] = true;
$response['message'] = 'User already registered';
$stmt->close();
}

else if($stmt1->num_rows > 0){
$response['error'] = true;
$response['message'] = 'Email Address already registered';
$stmt->close();
}else{
$stmt = $conn->prepare("INSERT INTO users (username, email, password, gender) VALUES (?, ?, ?, ?)");
$stmt->bind_param("ssss", $username, $email, $password, $gender);

if($stmt->execute()){
$stmt = $conn->prepare("SELECT id, id, username, email, gender FROM users WHERE username = ?"); 
$stmt->bind_param("s",$username);
$stmt->execute();
$stmt->bind_result($userid, $id, $username, $email, $gender);
$stmt->fetch();

$user = array(
'id'=>$id, 
'username'=>$username, 
'email'=>$email,
'gender'=>$gender
);

$stmt->close();

$response['error'] = false; 
$response['message'] = 'User registered successfully'; 
$response['user'] = $user; 
}
}

}else{
$response['error'] = true; 
$response['message'] = 'required parameters are not available'; 
}

break; 

case 'login':

if(isTheseParametersAvailable(array('username', 'password'))){

$username = $_POST['username'];
$password = md5($_POST['password']); 

$stmt = $conn->prepare("SELECT id, username, email, gender FROM users WHERE username = ? AND password = ?");
$stmt->bind_param("ss",$username, $password);

$stmt->execute();

$stmt->store_result();

if($stmt->num_rows > 0){

$stmt->bind_result($id, $username, $email, $gender);
$stmt->fetch();

$user = array(
'id'=>$id, 
'username'=>$username, 
'email'=>$email,
'gender'=>$gender
);

$response['error'] = false; 
$response['message'] = 'Login successfull'; 
$response['user'] = $user; 
}else{
$response['error'] = false; 
$response['message'] = 'Invalid username or password';
}
}
break; 


case 'getdata':

if(isTheseParametersAvailable(array('month', 'year' , 'pid'))){

$month = $_POST['month'];
$year = $_POST['year']; 
$pid = $_POST['pid']; 

					
$sql5="SELECT * FROM heroes WHERE pid='$pid'";
$result5=mysqli_query($conn,$sql5);

										$amount=0;	$payed=0; $bill=0; $billp=0;
									 while($row5=mysqli_fetch_array($result5)){
									
									$amount= $amount  +	$row5['amount']; 
									
									$payed= $payed  +	$row5['payed']; 
									
									$bill = $bill + 1;
									
									if($row5['amount']==$row5['payed']){
										$billp++;
									}
															  }
												
                                     
$sql6="SELECT * FROM heroes WHERE pid='$pid' && creation LIKE '%$month-$year%'";
$result6=mysqli_query($conn,$sql6);				
                                      $montha=0;	$monthp=0;							
		                          while($row6=mysqli_fetch_array($result6)){
									  
									$montha= $montha  +	$row6['amount']; 
									
									$monthp= $monthp  +	$row6['payed']; 
									  
								  }
								  
								    
$sql7="SELECT * FROM heroes WHERE pid='$pid' && creation LIKE '%$year%'";
$result7=mysqli_query($conn,$sql7);				
                                      $yeara=0;	$yearp=0;							
		                          while($row7=mysqli_fetch_array($result7)){
									  
									$yeara= $yeara  +	$row7['amount']; 
									
									$yearp= $yearp  +	$row7['payed']; 
									  
								  }
								  
		$monthp = $montha-$monthp;
		$yearp = $yeara-$yearp;
		$payed = $amount-$payed;
		



$response['error'] = false; 
$response['message'] = 'data fetched successfull'; 


$response['amount'] = $amount; 
$response['payed'] = $payed; 
$response['montha'] = $montha; 
$response['monthp'] = $monthp; 
$response['yeara'] = $yeara; 
$response['yearp'] = $yearp; 
$response['bill'] = $bill; 
$response['billp'] = $billp; 
}else{
$response['error'] = false; 
$response['message'] = 'data not fetched';

}


break; 


default: 
$response['error'] = true; 
$response['message'] = 'Invalid Operation Called';
}

}else{
$response['error'] = true; 
$response['message'] = 'Invalid API Call';
}

echo json_encode($response);

function isTheseParametersAvailable($params){

foreach($params as $param){
if(!isset($_POST[$param])){
return false; 
}
}
return true; 
}