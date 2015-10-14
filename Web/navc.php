<?php
if ($_SESSION == true) {
    include("captcha/simple-php-captcha.php");
    $_SESSION['captcha'] = simple_php_captcha();
} else {
    session_start();
}
?>

<nav>
    <ul id="menu" >
        <?php
        include_once("language.php");
        echo checkLang(4, htmlspecialchars($_COOKIE['lang']));
        ?>
        <?php if (!isset($_SESSION["username"])): ?>

            <li id ="login"><a id="login-trigger" href="#">LOGIN <span>&#9660;</span></a>
                <div id="login-content">
                    <form action="login.php" method="post" id="testForm">

                        <fieldset id="inputs" >


                            <input type="hidden" name="valid" value="<?php echo $_SESSION['csfrReqToken'] ?>"/>
                            Username:<br>

                            <input type="text" size="24" maxlength="50"
                                   name="username" placeholder="Username" required /><br><br>

                            Password:<br>
                            <input type="Password" id="Password" size="24" maxlength="50" autocomplete="off"
                                   name="password" placeholder="Password" required /><br>
                            <br/>
                            <img src="<?php echo $_SESSION['captcha']['image_src'] ?>" alt="CAPTCHA code"/>
                            <input type="text" size="24" maxlength="5"
                                   name="captcha" placeholder="Captcha" required /><br><br>
                            <input type="submit" id="submit" value="Login" style="margin:5px" />
                            <br/>

                        </fieldset>

                    </form>

                    <form method="GET" action="hybridauth/hybridauth/xing/">
                        <input type="hidden" name="valid" value="<?php echo $_SESSION['csfrReqToken'] ?>"/>
                        <input type="image" src="image/XINGSignup.png" name="xingLogin" value="true" />
                    </form>






                </div></li>
        <?php else: ?>


            <li id ="logout"><a id="logout-action"  href="logout.php">LOGOUT</a> 


            <?php endif; ?>
        </li>

    </ul>
    
    <div id="divMail">
        <a id="email"></a>
    </div>


</nav>

<script>
    var part1 = "info";
    var part2 = Math.pow(2, 6);
    var part3 = String.fromCharCode(part2);
    var part4 = "thorstenweber.io";
    var part5 = part1 + String.fromCharCode(part2) + part4;
    var part6 = "src='image/email.png'";
    document.getElementById("email").innerHTML = "<a href=" + "mai" + "lto" + ":" + part5 + ">" + '<img   src="image/email.png" width="55px" height="55px"/>'+ "</a>";


</script>

