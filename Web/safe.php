<?php
session_start();
?>

<?php
header('Content-Type: text/html; charset=UTF-8');
if (!isset($_SESSION["username"])) {
    header("Location: forbidden.php");
    die("Redirecting to: forbidden.php");
}
?> 


<!Doctype html>
<html>
    <head>
        <!-- HTML META DATA -->
        <meta name="robots" content="noindex">
        <meta charset="UTF-8" />
        <meta name="keywords" content="Profil Thorsten Weber Programmcode Beispiele Arbeiten" />
        <meta name="description" content="Bewerbungswebsite von Thorsten Weber"/>
        <meta name="author" content="Thorsten Weber"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>

        <link rel="stylesheet" type="text/css" href="styles/safestyle.css"/> 

        <title>Portfolio Thorsten Weber</title>
        <!--[if lt IE 9]>
        <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js">
        </script>
        <![endif]-->

        <!-- JS and JQuery Link -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
        <script src="safe/jQueryRotate.js"></script> 
        <script src="safe/safescript.js"></script>

    </head>
    <body>
        <img id="rand" src="safe/rand.png" />
        <img id="hintergrund" src="safe/hintergrund.png"/>
        <img id="schloss" src="safe/schloss.png"/>

    </body>
</html>