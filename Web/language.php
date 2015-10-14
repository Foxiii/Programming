<?php
//this function is for security. If someone enters something else then de or en the function makes standard language de (german)
function checkLang($id, $lang = "de") {

    $lang_array = array("de", "en");

    if (in_array($lang, $lang_array)) {
        if ($lang === "en" && isset($_COOKIE['lang'])) {
            
            return $lang = LoadLang($id, htmlspecialchars($_COOKIE['lang']));
        } else {
            
            return $lang = LoadLang($id, htmlspecialchars($_COOKIE['lang']));
        }
    } else {
        return $lang = LoadLang($id, "de");
    }
}

function LoadLang($id, $lang) {


    $mysqli = new mysqli("", "", "", "");
    /* check connection */
    if (mysqli_connect_errno()) {
        printf("Connect failed: %s\n", mysqli_connect_error());
        exit();
    }


    $query = "select $lang FROM lang WHERE id = $id";
    $mysqli->set_charset("utf8");
    if ($result = $mysqli->query($query)) {

        /* fetch object array */
        while ($row = $result->fetch_row()) {
            $text = sprintf("%s\n", $row[0]);
        }

        /* free result set */

        $result->close();
        return $text;
    } else {
        echo "Fehler in der Abfrage";
    }

    /* close connection */
    $mysqli->close();
}

?>