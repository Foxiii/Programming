<?php
session_start();
?>

<!Doctype html>


<html>

    <?php include ("head.php"); ?>
    <body>

        <?php include ("header.php"); ?>

        <?php include ("navc.php"); ?>

        <?php
        include_once("language.php");
        echo checkLang(7, htmlspecialchars($_COOKIE['lang']));
        ?>

        <?php include ("footer.php"); ?>

    </body>
</html>