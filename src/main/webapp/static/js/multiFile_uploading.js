$(function () {
    $(".fill_area").load("multiFile_1");
    $(".mfu_1").css("background-color","#e29c1b");
    $(".mfu_1").click(function () {
        $(".index_btn").css("background-color","#5CB85C");
        $(this).css("background-color","#e29c1b");
        $(".fill_area").load("multiFile_1");
    });
    $(".mfu_2").click(function () {
        $(".index_btn").css("background-color","#5CB85C");
        $(this).css("background-color","#e29c1b");
        $(".fill_area").load("multiFile_2");
    });
    $(".mfu").click(function () {
        $(".index_btn").css("background-color","#5CB85C");
        $(this).css("background-color","#e29c1b");
        $(".fill_area").load("monoFile");
    });
});