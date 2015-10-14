<?php
session_start();
?>



<!Doctype html>

<html>

    <?php include ("head.php"); ?>

    <body>

        <?php include ("header.php"); ?>

        <?php include ("navc.php"); ?>

        <section >

            <h1>Falscher Username / Passwort </h1>
            <br/>
            <h1>Wrong Username / Password </h1>
            <form method="GET" action="prevpage.php">    
                <input type="hidden" name="valid" value="<?php echo $_SESSION['csfrReqToken'] ?>"/>
                <input type="submit" value="Home">
            </form>



        </div>

    </section>

    <?php include ("footer.php"); ?>

</body>
</html>

