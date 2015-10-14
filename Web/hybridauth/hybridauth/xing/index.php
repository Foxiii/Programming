<?php

session_start();

// config and includes
$config = dirname(__FILE__) . '/../../hybridauth/config.php'; //set the config var to the config path
require_once( "../../hybridauth/Hybrid/Auth.php" ); //necessary for the hybridauth tool
require_once ("../../../common.php"); //my DB auth file.


if ($_GET) {
    //CSFR Protection and check if user is using the right login.
    if (htmlspecialchars($_GET["xingLogin"]) === "true" && trim(htmlspecialchars($_GET["valid"])) === trim($_SESSION["csfrReqToken"])) {
        try {

            $hybridauth = new Hybrid_Auth("../config.php"); //Make new Hybrid_auth object
            $oXING = $hybridauth->authenticate('XING'); //Load the XING php API
            $oName = $oXING->getUserProfile()->displayName; //Get the whole user information. 
            $oXingname = $oXING->getUserProfile()->profileURL; //Get user profile ID for unique identification
            $oMessage = $oXING->getUserProfile()->emailVerified; //Get user email for security

            //Check and controll stuff.
            if ($oMessage == '') {
                return array(status => false, message => 'Message is empty');
            }

            // Get IP address
            if (($remote_addr = $_SERVER['REMOTE_ADDR']) == '') {
                $remote_addr = "REMOTE_ADDR_UNKNOWN";
            }

            // Get requested script
            if (($request_uri = $_SERVER['REQUEST_URI']) == '') {
                $request_uri = "REQUEST_URI_UNKNOWN";
            }
            //Add user to visited Database. PHP PDO 
            $stmt = $db->prepare("INSERT INTO my_log (remote_addr, request_uri,username,xing_name, message) VALUES(?,?,?,?,?)");
            $stmt->bindValue(1, $remote_addr, PDO::PARAM_STR);
            $stmt->bindValue(2, $request_uri, PDO::PARAM_STR);
            $stmt->bindValue(3, $oName, PDO::PARAM_STR);
            $stmt->bindValue(4, $oXingname, PDO::PARAM_STR);
            $stmt->bindValue(5, $oMessage, PDO::PARAM_STR);

            $stmt->execute();

            
            //Username is Xing whole name.
            $_SESSION["username"]["username"] = $oName;
            
           //Send user to the safe script
           $hybridauth->redirect("../../../safe.php");
        } catch (Exception $e) {
            
            //Only a bit error handling
            switch ($e->getCode()) {
                case 0 : echo "Unspecified error.";
                    break;
                case 1 : echo "Hybridauth configuration error.";
                    break;
                case 2 : echo "Provider not properly configured.";
                    break;
                case 3 : echo "Unknown or disabled provider.";
                    break;
                case 4 : echo "Missing provider application credentials.";
                    break;
                case 5 : echo "Authentication failed. "
                    . "The user has canceled the authentication or the provider refused the connection.";
                    break;
                case 6 : echo "User profile request failed. Most likely the user is not connected "
                    . "to the provider and he should to authenticate again.";
                    $xing->logout();
                    break;
                case 7 : echo "User not connected to the provider.";
                    $xing->logout();
                    break;
                case 8 : echo "Provider does not support this feature.";
                    break;
            }
        }
    }
}

