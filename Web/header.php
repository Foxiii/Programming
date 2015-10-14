<?php
require ("language.php");
?>


<header>
<!-- The image with my name  -->
    <div id="name">
        <a href="index.php">
            <img src="image/name.png" alt="Thorsten Weber"  height="60" />
        </a>





<?php
//only if cookies are set you have the choice tho change the language.
if (isset($_COOKIE['lang'])) {
    echo '<img id="picDE"src="image/de.png" onclick="document.location.href=&apos;setdecookie.php&apos;;" />
        <img id="picEN"src="image/en.png" onclick="document.location.href=&apos;setencookie.php&apos;;" />';
}
?>


    </div>
    <div id="login-sign"><?php
    //this shows the loged in user.
        if (!isset($_SESSION['username'])) {
            
        } else {
            include_once("language.php");
            echo checkLang(8, htmlspecialchars($_COOKIE['lang'])) . strtoupper($_SESSION['username']['username']);
        }
        ?>

    </div>


</header>