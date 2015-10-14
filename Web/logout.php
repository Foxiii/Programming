<?php

session_start();
session_destroy();
echo "Logout erfolgreich <a href=\"index.html\">weiter</a>";
header('Location:index.php');
