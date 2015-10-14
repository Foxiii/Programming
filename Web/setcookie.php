<?php
session_start();

if (isset($_COOKIE['lang'])) {
    header("Location: index.php");
    die("Redirecting to: index.php");
}
if (!isset($_SESSION['csfrReqToken'])) {
    $_SESSION['csfrReqToken'] = md5(uniqid());
}

if ($_GET) {
    if (isset($_GET['cookieOk']) && trim(htmlspecialchars($_GET["valid"])) === trim($_SESSION["csfrReqToken"])) {
        setcookie("lang", "de", time() + 3600, "/");
        header("Location: /setcookie.php");
        die("Redirecting to: /setcookie.php");
        ok();
    }
}

function ok() {
    if (!isset($_COOKIE['lang'])) {
        echo "No Cookies accepted";
    } else {
        header("Location: index.php");
        die("Redirecting to: index.php");
    }
}
?>

<!Doctype html>


<html>
    <?php include_once ("head.php"); ?>
    <body>

        <?php include ("header.php"); ?>

        <nav>
            <ul id="menu" >
                <a href="lebenslauf.php" > <li>LEBENSLAUF</li> </a>
                <a href="administration.php"><li>NETZWERK/ADMINISTRATION</li></a>
                <a href="programmierung.php" ><li>PROGRAMMIERUNG</li></a>
                <a href="studium.php" ><li>STUDIUM</li></a>
               

                </li>

            </ul>


        </nav>

        <section >

            <h1>Bitte beachten Sie das diese Website nur mit Cookies funktioniert. </h1>

            <p>Da diese Website eine Präsentation unter möglichst vielen Aspekten sein soll, müssen sie Cookies aktiveren um weiter zu gelangen.
                Vielen Dank.</p>

            <br/>
            <br/>
            <h1>Please note that this site will only work with cookies accepted. </h1>

            <p> Because this Website has to be a presentation under as many aspects as possible, you need to accept cookies on this Website.
                Many thanks.</p>


            <form action="<?= ($_SERVER['PHP_SELF']) ?>" method="GET">
                <input type="hidden" name="valid" value="<?php echo $_SESSION["csfrReqToken"] ?> "/>
                <input type="submit" name="cookieOk" value="Cookies akzeptieren(accept)" width="100px"/>

            </form>




        </div>

    </section>

    <footer>
        <ul id="foot">
            <li><a href="impressum.php">Impressum</a></li>
            <li><a href="recht.php">Rechtliche Hinweise</a></li>
        </ul>
    </footer>

</body>
</html>

