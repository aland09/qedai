
<?php
//these are the server details
//the username is root by default in case of xampp
//password is nothing by default
//and lastly we have the database named android. if your database name is different you have to change it
// $servername = "localhost";
// $database = "qedy1629_test";
// $username = "qedy1629_admin";
// $password = "qedai032";
//
//
// //creating a new connection object using mysqli
// $conn = new mysqli($servername, $username, $password, $database);
//
// //if there is some error connecting to the database
// //with die we will stop the further execution by displaying a message causing the error
// if ($conn->connect_error) {
//     die("Connection failed: " . $conn->connect_error);
// }
//
// //if everything is fine
//
// //creating an array for storing the data
// $heroes = array();
//
// //this is our sql query
// $sql = "SELECT id, QTY_ROLL, DOCNO, PURPOSE, PRODTYPE, TYPE, THICK, WIDTH_JUMBO, NOLOT, TS, PROD_LINE, JUMBO_ID, KTF, BB_WEIGTH_ACT, BB_LENGTH, PROD_DATE, RCV_WEIGHT, RCV_LENGTH, CLASS, SO_REQUEST, DIVISI FROM datapbr2 ";

// //creating an statment with the query
// $stmt = $conn->prepare($sql);
//
// //executing that statment
// $stmt->execute();
//
// //binding results for that statment
// $stmt->bind_result($id, $name);
//
// //looping through all the records
// while($stmt->fetch()){
//
//  //pushing fetched data in an array
//  $temp = [
//  'id'=>$id,
//  'QTY_ROLL'=>$name
//  ];
//
//  //pushing the array inside the hero array
//  array_push($heroes, $temp);
// }
//
// //displaying the data in json format
// echo json_encode($heroes);



$conn = mysqli_connect('localhost', 'qedy1629_admin', 'qedai032', 'qedy1629_test');
$query = mysqli_query($conn, 'SELECT id, QTY_ROLL, DOCNO, PURPOSE, PRODTYPE, TYPE, THICK, WIDTH_JUMBO, NOLOT, TS, PROD_LINE, JUMBO_ID, KTF, BB_WEIGTH_ACT, BB_LENGTH, PROD_DATE, RCV_WEIGHT, RCV_LENGTH, CLASS, SO_REQUEST, DIVISI FROM datapbr2');
while ($row = mysqli_fetch_assoc($query)) {
	$data[] = $row;
}
// echo '<pre>'; print_r($data); echo '</pre>';
echo json_encode($data);

// $fixingdata = str_replace("[","",json_encode($data));
// $fixingdata = str_replace("]","",$fixingdata);
// echo $fixingdata;
?>
