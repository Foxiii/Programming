<?php

include_once("language.php");
echo checkLang(6, htmlspecialchars($_COOKIE['lang']));
?>