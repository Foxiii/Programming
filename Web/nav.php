<nav>
    <ul id="menu" >
        <?php
        include_once("language.php");
        echo checkLang(4, htmlspecialchars($_COOKIE['lang']));
        ?>
        <a id="logout-action"  href="logout.php"><li id ="logout">LOGOUT</li></a>
        
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