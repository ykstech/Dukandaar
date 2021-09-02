<?php
 
class DbOperation
{
    //Database connection link
    private $con;
 
    //Class constructor
    function __construct()
    {
        //Getting the DbConnect.php file
        require_once dirname(__FILE__) . '/DbConnect.php';
 
        //Creating a DbConnect object to connect to the database
        $db = new DbConnect();
 
        //Initializing our connection link of this class
        //by calling the method connect of DbConnect class
        $this->con = $db->connect();
    }
	
	/*
	* The create operation
	* When this method is called a new record is created in the database
	*/
	function createHero($name, $phone, $address,$pid, $bill, $creation, $description, $type, $reference, $amount, $payed, $updated){
		$stmt = $this->con->prepare("INSERT INTO heroes (name, phone, address,pid, bill, creation, description, type, reference, amount, payed, updated) VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
		$stmt->bind_param("ssssssssssss", $name, $phone, $address, $pid, $bill, $creation, $description, $type, $reference, $amount, $payed, $updated);
		if($stmt->execute())
			return true; 
		return false; 
	}
	
	


	/*
	* The read operation
	* When this method is called it is returning all the existing record of the database
	*/
	function getHeroes($pid,$pid2, $name,$payed,$updated){
		if($pid2 == 1){
			$stmt = $this->con->prepare("SELECT id,name, payed, updated  FROM heroes2  WHERE pid = $pid ");
 $stmt->execute();
 $stmt->bind_result($id2,$name2, $payed2, $updated2);

$heroes = array(); 
 
 while($stmt->fetch()){
 $hero  = array();
 $hero['id'] = $id2; 
 $hero['name'] = $name2; 
 $hero['phone'] = ""; 
 $hero['address'] = ""; 
 $hero['bill'] = ""; 
 $hero['creation'] = ""; 
 $hero['description'] = ""; 
 $hero['type'] = ""; 
 $hero['reference'] = ""; 
 $hero['amount'] = 0;
 $hero['payed'] = $payed2; 
 $hero['updated'] = $updated2; 
 
  
 
 array_push($heroes, $hero); 
 }
 return $heroes; 


		} else if($pid2 == 4){
		$stmt = $this->con->prepare("INSERT INTO heroes2 (name, payed, updated,pid) VALUES (?, ?, ?, ?)");
		$stmt->bind_param("ssss", $name, $payed, $updated, $pid);
		if($stmt->execute())
			return true; 
		return false; 

		}
		else{
 $stmt = $this->con->prepare("SELECT id, name,phone, address, bill, creation, description, type, reference, amount, payed, updated  FROM heroes  WHERE pid = $pid ");
 $stmt->execute();
 $stmt->bind_result($id1, $name1, $phone1, $address1,$bill2, $creation1, $description1, $type1, $reference1, $amount1, $payed1, $updated1);
	
 $heroes = array(); 
 
 while($stmt->fetch()){
 $hero  = array();
 $hero['id'] = $id1; 
 $hero['name'] = $name1; 
 $hero['phone'] = $phone1; 
 $hero['address'] = $address1; 
 $hero['bill'] = $bill2; 
 $hero['creation'] = $creation1; 
 $hero['description'] = $description1; 
 $hero['type'] = $type1; 
 $hero['reference'] = $reference1; 
 $hero['amount'] = $amount1; 
 $hero['payed'] = $payed1; 
 $hero['updated'] = $updated1; 
 
  
 
 array_push($heroes, $hero); 
 }
 return $heroes; 
		}
		
 
 
 }
 
	/*
	* The update operation
	* When this method is called the record with the given id is updated with the new given values
	*/
	function updateHero($id, $name, $phone, $address, $bill, $creation, $description, $type, $reference, $amount, $payed, $updated){
		$stmt = $this->con->prepare("UPDATE heroes SET name = ?, phone = ?, address = ?, bill = ?,creation = ?,description = ?,type = ?,reference = ?,amount = ?,payed = ?,updated = ? WHERE id = ?");
		$stmt->bind_param("sssssssssssi", $name, $phone, $address, $bill, $creation, $description, $type, $reference, $amount, $payed, $updated, $id);
		if($stmt->execute())
			return true; 
		return false; 
	}
	/*function updateHero($id, $name){
 $stmt = $this->con->prepare("UPDATE heroes SET name = ? WHERE id = ?");
 $stmt->bind_param("ssisi", $name, $realname, $rating, $teamaffiliation, $id);
 if($stmt->execute())
 return true; 
 return false; 
 } */
	
	/*
	* The delete operation
	* When this method is called record is deleted for the given id 
	*/
	function deleteHero($id){
		$stmt = $this->con->prepare("DELETE FROM heroes WHERE id = ? ");
		$stmt->bind_param("i", $id);
		if($stmt->execute())
			return true; 
		
		return false; 
	}
	
	function deleteHero2($id){
		$stmt = $this->con->prepare("DELETE FROM heroes2 WHERE id = ? ");
		$stmt->bind_param("i", $id);
		if($stmt->execute())
			return true; 
		
		return false; 
	}
}