<?php

session_start();


if ($_GET) {
    if (htmlspecialchars($_GET["valid"]) === $_SESSION["csfrReqToken"]) {

        if (isset($_SERVER["HTTP_REFERER"])) {
            header("Location: index.php");
            die("Redirecting to: index.php");
        }
    }
}