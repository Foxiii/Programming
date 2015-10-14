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

<!Doctype html>
<html>
    <?php include ("head.php"); ?>
    <body>



        <?php include ("header.php"); ?>

        <?php include ("nav.php"); ?>

        <section >


            <div class="theme-default">
                <div id="slider" class="nivoSlider">
                    <img src="image/MicrosoftWindowsServer.jpg" data-thumb="image/MicrosoftWindowsServer.jpg"/>
                    <img src="image/symantec.jpg" data-thumb="image/MicrosoftWindowsServer.jpg"/>
                    <img src="image/firewall.jpg" data-thumb="image/MicrosoftWindowsServer.jpg"/>
                    <img src="image/SAP.jpg" data-thumb="image/MicrosoftWindowsServer.jpg"/>
                    <img src="image/redhat.jpg" data-thumb="image/MicrosoftWindowsServer.jpg"/>
                    <img src="image/virtual-machines.jpg" data-thumb="image/MicrosoftWindowsServer.jpg"/>
                    <img src="image/SINA.jpg" data-thumb="image/MicrosoftWindowsServer.jpg"/>                    
                    <img src="image/Lotus.jpg" data-thumb="image/MicrosoftWindowsServer.jpg"/>

                </div>
            </div>

            <?php
            include_once("language.php");
            echo checkLang(11, htmlspecialchars($_COOKIE['lang']));
            ?>
        </section>

        <?php include ("footer.php"); ?>
    </body>
</html>