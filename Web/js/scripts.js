$(document).ready(function () {
    $('#login-trigger').click(function () {
        $(this).next('#login-content').slideToggle();
        $(this).toggleClass('active');
        if ($(this).hasClass('active'))
            $(this).find('span').html('&#x25B2;');
        else
            $(this).find('span').html('&#x25BC;');
    });
    $('#menu li').ahover({moveSpeed: 100, hoverEffect: function () {
            $(this)
                    .animate({opacity: 0.5}, 750)
                    .animate({opacity: 1.0}, 750)
                    .dequeue();
            $(this).queue(arguments.callee);
        }});
});
$(window).load(function () {
    $('#slider').nivoSlider();
});

function reload(){
    location.reload();
}
