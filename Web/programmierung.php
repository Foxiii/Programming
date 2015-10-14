<?php
session_start();
require("common.php");
require ("cookie.php");
header('Content-Type: text/html; charset=UTF-8');

if (!isset($_SESSION["username"])) {
    header("Location: forbidden.php");
    die("Redirecting to: forbidden.php");
}
?>


<!Doctype html>
<html>
    <?php include ("head.php"); ?>
    <link rel="stylesheet" type="text/css" href="styles/software.css"/>
    <body>

        <?php include ("header.php"); ?>

        <?php include ("nav.php"); ?>

        <?php
        include_once("language.php");
        echo checkLang(3, htmlspecialchars($_COOKIE['lang']));
        ?>
        <?php include ("footer.php"); ?>

    </body>
</html>




