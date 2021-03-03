

<?php

  // echo $Idnya;
include "db.php";
  $Idnya=$_POST['IDnya'];
$totJualKmrn;
$totJualSkrg;
$totPengeluaran;


$transdate = date('m-d-Y', time());
$d = date_parse_from_format("m-d-y",$transdate);
$month = $d["month"];
if ($month==1) {
  // code...
  $month=13;
}


$query = mysqli_query($con, 'SELECT `id`, `nama`, `image`, `harga`, `qty`, `sell`, `lastUpdate` FROM `dt_prod` ');
while ($rowx = mysqli_fetch_assoc($query)) {
	$datax[] = $rowx;
}

$dataProd = json_encode($datax);



echo strval($dataProd)."|@|";




// $dataProd = json_encode($data);




 ?>
