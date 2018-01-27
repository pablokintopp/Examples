<?php

$conn  = new \PDO("mysql:host=localhost;dbname=test","root","root");

$query = "select * from `person` ";

$ret = $conn->query($query);

$people = $ret->fetchAll(\PDO::FETCH_BOTH);

print_r($people); 

echo "<br><br>Mysqli<br>";

$mysqli = new mysqli("localhost","root","root","test");
$query = "select * from `person` ";

foreach($q = $mysqli->query($query) as $p){
	echo $p['name']."<br>";
}
