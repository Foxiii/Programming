<?php

if (!isset($_COOKIE["lang"])) {
    header("Location: setcookie.php");
    die("Redirecting to: setcookie.php");
} else {
    setcookie("lang", "de", time() + 3600);

    header('Location:' . $_SERVER['HTTP_REFERER']);
}
?>