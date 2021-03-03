<?php

/* ===== www.dedykuncoro.com ===== */

	include 'koneksi.php';

class usr{}



$namked = $_POST["namked"];

$loked = $_POST["loked"];

$usrid = $_POST["userid"];

// $alamatkedai = $_POST["alamatkedai"];





      $query = mysqli_query($connect, "INSERT INTO `dt_regkedai`( `userID`,`namakedai`, `alamatkedai`, `status`, `dateupdate`)
                                        VALUES ('".$usrid."','".$namked."','".$loked."',0,now())");



      if ($query){

        $response = new usr();

        $response->success = 1;

        $response->message = "Register Kedai berhasil, Silahkan Menunggu Aktifasi Dari Pihak Qedai.id.";

        die(json_encode($response));



      } else {

        $response = new usr();

        $response->success = 0;

        $response->message = "Registrasi Gagal.";

        die(json_encode($response));

      }

    // } else {

    // 	$response = new usr();

    // 	$response->success = 0;

    // 	$response->message = "Username sudah ada";

    // 	die(json_encode($response));

    // }





mysqli_close($connect);




?>
