<?php
$servername = "localhost";
$database = "qedy1629_qedai";
$username = "qedy1629_admin";
$password = "qedai032";

// untuk tulisan bercetak tebal silakan sesuaikan dengan detail database Anda
// membuat koneksi
$connect = mysqli_connect($servername, $username, $password, $database);
// mengecek koneksi
if (!$connect) {
    die("Koneksi gagal: " . mysqli_connect_error());
}
?>
