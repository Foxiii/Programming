// This function makes a random number for rotating.
$(window).load(function () {
    var eins = (Math.floor((Math.random() * 360)));
    var zwei = -1 * (Math.floor((Math.random() * 360)));
    var drei = (Math.floor((Math.random() * 360)));

//Rotate right

    var rotation1 = function () {
        var r = $.Deferred();
        $("#schloss").rotate({
            angle: 0,
            animateTo: eins,
            duration: 2000
        });



    };
    
    //Rotate left
    var rotation2 = function () {
        $("#schloss").rotate({
            angle: eins,
            animateTo: zwei,
            duration: 2000

        });
    };
    //Rotate right
    var rotation3 = function () {
        $("#schloss").rotate({
            angle: zwei,
            animateTo: drei,
            duration: 2000
        });
    };

    //Execute and wait a moment
    rotation1();
    setTimeout(function () {
        rotation2();
    }, 2500);

    setTimeout(function () {
        rotation3();
    }, 5000);

    setTimeout(function () {
        $("#hintergrund").hide("slow");
        $("#rand").hide("slow");
        $("#schloss").hide("slow");

    }, 8000);
//Send back to index.php after finishing the script
    setTimeout(function () {
        function goToURL() {
            location.href = 'index.php';

        }
        goToURL();

    }, 9000);

});


    