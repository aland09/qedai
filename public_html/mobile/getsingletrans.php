<?php


// $Idtrans="u2HARh";
// $iditem="1";

$Idtrans=$_POST['IDnya'];
$iditem=$_POST['iditem'];

include "db.php";


$query = mysqli_query($con, 'SELECT tr.transKode, tr.itemId, tr.dateUpdate, tr.itemName, tr.itemPrice, tr.status, pr.id, pr.nama, pr.image, pr.harga, pr.qty, pr.sell, pr.lastUpdate
  FROM dt_trans as tr INNER JOIN dt_prod as pr ON tr.itemId=pr.id WHERE tr.transKode = "'.$Idtrans.'" AND tr.itemId = "'.$iditem.'"');
while ($row = mysqli_fetch_assoc($query)) {
	$data[] = $row;
}

$dataProd = json_encode($data);

echo $dataProd;



 ?>
