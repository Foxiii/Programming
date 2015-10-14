<?php
session_start();
require("common.php");
require ("cookie.php");
?>


<!Doctype html>
<html>

    <?php include "head.php" ?>


    <body >



        <?php
        include ("header.php");
        $out = checkLang(1, htmlspecialchars($_COOKIE['lang']));
        ?>

        <?php include ("navc.php"); ?>
        <section>
            <!-- The Nivo Slider for the index.php-->
            <div class="theme-default">
                <div id="slider" class="nivoSliderStudy">
                    <img src="image/web-development.jpg" data-thumb="image/web-development.jpg"/>
                    <img src="image/Turing_Machine.jpg" data-thumb="image/web-development.jpg"/>
                    <img src="image/MC68HC11_microcontroller.jpg" data-thumb="image/web-development.jpg"/>
                    <img src="image/math_board.jpg" data-thumb="image/web-development.jpg"/>

                </div>
            </div>

            <?php
            echo $out;
            ?>
        </section>

        <?php include ("footer.php"); ?>

    </body>
</html>

