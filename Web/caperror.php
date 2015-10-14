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

            <h1>Hups Caption error!</h1>

            <form >                
                <input type="button" onclick="goback()" value="Home">
            </form>

            <script>function goback() {
                    window.history.back();
                }
            </script>

        </div>

    </section>

    <?php include ("footer.php"); ?>

</body>
</html>