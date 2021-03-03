<?php

$qty=$_POST['qty'];

$idt=$_POST['idt'];
// $idt='sMkXSw';

$idItem=$_POST['idItem'];
// $idItem=1;
$itmnme="";
$itmPrice="";

include "db.php";

$query = mysqli_query($con, 'SELECT tr.transKode, tr.itemId, tr.dateUpdate, tr.itemName, tr.itemPrice, tr.status, pr.id, pr.nama, pr.image, pr.harga, pr.qty, pr.sell, pr.lastUpdate
  FROM dt_trans as tr INNER JOIN dt_prod as pr ON tr.itemId=pr.id WHERE tr.transKode = "'.$idt.'" AND tr.itemId = "'.$idItem.'"');
while ($row = mysqli_fetch_assoc($query)) {
	// $data[] = $row;

  $itmnme = $row['itemName'];
  $itmPrice = $row['itemPrice'];
}


$sql = "DELETE FROM dt_trans WHERE transKode = '".$idt."' AND itemId = '".$idItem."'";

if (mysqli_query($con, $sql)) {
  // echo "Record deleted successfully";
} else {
  // echo "Error deleting record: " . mysqli_error($con);
}

$status="";
for ($i=0; $i <$qty ; $i++) {
  // code...
  $sql = "INSERT INTO dt_trans(transKode, itemId, dateUpdate, itemName, itemPrice, status, qty) VALUES ('".$idt."','".$idItem."',now(),'".$itmnme."','".$itmPrice."','Order',0)";

  if ($con->query($sql) === TRUE) {
    $status ="success";
  } else {
    $status ="Error: " . $sql . "<br>" . $con->error;
  }
}

echo $status;




$con->close();

 ?>
