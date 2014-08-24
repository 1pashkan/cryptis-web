<?php
/**
 * Created by JetBrains PhpStorm.
 * User: mibbim
 * Date: 19.01.14
 * Time: 23:15
 * To change this template use File | Settings | File Templates.
 */
include "../data/mysql.php";

header('Content-Type: application/json');

$email = $_GET['email'];
$email = mysql_real_escape_string($email);

$query = "insert into subscriptions (email) values ('".$email."')";
mysql_query($query) or die('{"success":false}');

mysql_close();

echo '{"success":true}';