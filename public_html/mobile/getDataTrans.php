<?php


  $Idnya=$_POST['IDnya'];

include "db.php";


// $query = mysqli_query($con, 'SELECT `id`, `transKode`, `itemId`, `dateUpdate`, `itemName`, `itemPrice`, `status`, SUM(itemPrice) as total, COUNT(*) as item  FROM `dt_trans` WHERE `transKode` = "'.$Idnya.'" GROUP BY itemId');
$query = mysqli_query($con, 'SELECT tr.transKode, tr.itemId, tr.dateUpdate, SUM(tr.itemPrice) as total, COUNT(tr.itemName) as item, tr.itemName, tr.itemPrice, tr.status, pr.id, pr.nama, pr.image, pr.harga, pr.qty, pr.sell, pr.lastUpdate
  FROM dt_trans as tr INNER JOIN dt_prod as pr ON tr.itemId=pr.id WHERE tr.transKode = "'.$Idnya.'" GROUP BY tr.itemId');

while ($row = mysqli_fetch_assoc($query)) {
	$data[] = $row;
}

$dataProd = json_encode($data);

echo $dataProd;



 ?>
