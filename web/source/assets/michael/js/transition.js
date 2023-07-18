
$(document).ready(function () {
    $('a.menu-link').click(function (event) {
        event.preventDefault();
        var url = $(this).attr('href');
        var parties = url.split("/");
        $('body').fadeOut(10, function () {
            window.location.href = parties[2];
        });
    });
});
       