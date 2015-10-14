<?php
session_start();
require("common.php");
require ("cookie.php");
?>

<!Doctype html>
<html>
    <?php include ("head.php"); ?>
    <body>



        <?php include ("header.php"); ?>

        <?php include ("navc.php"); ?>

        <?php
        include_once("language.php");
        echo checkLang(9, htmlspecialchars($_COOKIE['lang']));
        ?>

        <?php include ("footer.php"); ?>

    </body>
</html>