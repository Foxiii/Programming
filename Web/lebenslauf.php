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
    <body>

        <?php include ("header.php"); ?>

        <?php include ("nav.php"); ?>


        <section >


            <div class=WordSection1>


                <?php
                include_once("language.php");
                echo checkLang(2, htmlspecialchars($_COOKIE['lang']));
                ?>
            </div>

        </section>

        <?php include ("footer.php"); ?>

    </body>
</html>