<?php
//check if cookies are set if not, redirect to setcookie.php
if (!isset($_COOKIE["lang"])) {
    header("Location: setcookie.php");
    die("Redirecting to: setcookie.php");
}

//Important if the csfr token is not set yet now it will !
if (!isset($_SESSION['csfrReqToken'])) {
    $_SESSION['csfrReqToken'] = md5(uniqid());
   
}