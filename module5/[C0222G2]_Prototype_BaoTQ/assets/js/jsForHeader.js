$(window).on("scroll", function () {
    scrollFunction();
})

function scrollFunction() {
    if ($("html").scrollTop() > 80) {
        $("#navbarSupportedContent a").css("color", "rgb(255,255,255)");
        $("#menu").css("backgroundColor", "rgba(0,0,0,0.90)");
    } else {
        $("a").css("color", "rgb(255,255,255)")
        $("#menu").css("backgroundColor", "rgba(0,0,0,0)");
    }
}
