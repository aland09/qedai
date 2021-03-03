<?php
include "db.php";

$prodnya=$_POST['prodnya'];
$idtrans=$_POST['idtrans'];

// $prodnya="1|@|Green Tea|@|10000|@|||@@||2|@|Red Velvet|@|10000|@|||@@||7|@|Tubruk Coffee|@|16000|@|||@@||5|@|Taro Latte|@|10000|@|||@@||";
// $idtrans="afbsb";
$hasil="";

$trans = explode("||@@||",$prodnya);
//
for ($i=0; $i < count($trans)-1; $i++) {
  // code...
  // $randomid = mt_rand(0,9999);
  // echo "<br>".$trans[$i];
  $datDetails = explode("|@|",$trans[$i]);
  $sql = "INSERT INTO dt_trans(transKode, itemId, dateUpdate, itemName, itemPrice,status) VALUES ('".$idtrans."','".$datDetails[0]."',NOW(),'".$datDetails[1]."','".$datDetails[2]."','Order');";
  if ($con->query($sql) === TRUE) {

      $hasil= "success";

  } else {
    $hasil = "Error: " . $sql . "<br>" . $con->error;
  }
}
//
//
//
echo $hasil;

$con->close();

 ?>
