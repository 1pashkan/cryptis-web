<?php
/**
 * Created by JetBrains PhpStorm.
 * User: mibbim
 * Date: 19.01.14
 * Time: 23:16
 * To change this template use File | Settings | File Templates.
 */
$hostname = "localhost";
$username = "cryptis";
$password = "GucOH9bVQqfG7FUTGPa7";
$databaseName = "cryptis";

mysql_connect($hostname,$username,$password) or die("Can't connect DB");
mysql_select_db($databaseName) or die(mysql_error());