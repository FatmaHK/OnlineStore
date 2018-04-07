$(document).ready(function(){
    //for image
   $(".head").height($(window).height());
    
    
    
    //for links in header
    $(".head .navbar .links ul li").on('mouseenter', function () {
       $(this).addClass("active").siblings().removeClass("active"); 
    });
    
    
    
    //for paragraph in header
    $(".head .header h2").animate({
        marginLeft: "280"
    }, 1200);
    
    
    
    /*start sign in*/
    
    //for sign In
    $(".SignIn").height($(window).height());
    
    
    
    //for links in sign In
    $(".SignIn .navbar .links ul li").on('mouseenter', function () {
       $(this).addClass("active").siblings().removeClass("active"); 
    });
    
    
    
    //for buttons in sign in
    $(".SignIn .Form1 .signin  ").hover(function () {
        $(this).css({
            color: "black",
            backgroundColor: "#17b0ca"
        });
    }, function () {
        $(this).css({
            color: "#1d1d86;",
            backgroundColor: "#bfe8d7"
        });
    });
    
    
    $(".SignIn .Form1 .signup  ").hover(function () {
        $(this).css({
            color: "black",
            backgroundColor: "#17b0ca"
        });
    }, function () {
        $(this).css({
            color: "#1d1d86;",
            backgroundColor: "#bfe8d7"
        });
    });
    
    /*end sign in*/
    
    
    
    
    
    /*start sign up*/
     //for sign up
    $(".SignUp").height($(window).height());
    
    
    
    //for links in sign up
    $(".SignUp .navbar .links ul li").on('mouseenter', function () {
       $(this).addClass("active").siblings().removeClass("active"); 
    });
    
    
    
    //for buttons in sign up
    $(".SignUp .Form2 .signin  ").hover(function () {
        $(this).css({
            color: "black",
            backgroundColor: "#17b0ca"
        });
    }, function () {
        $(this).css({
            color: "#1d1d86;",
            backgroundColor: "#bfe8d7"
        });
    });
    
    
    /*end sign up*/
    
    
    
    
    
    
    /*start select*/
    $(".select").height($(window).height());
    
    
    
    $(".select .navbar .links ul li").on('mouseenter', function () {
       $(this).addClass("active").siblings().removeClass("active"); 
    });
    /*end select*/
    
    
    
    
    
    /*start admin*/
    $(".Admin").height($(window).height());
    
    
    
    $(".Admin .navbar .links ul li").on('mouseenter', function () {
       $(this).addClass("active").siblings().removeClass("active"); 
    });
    
    
    
    $(".Admin .admin h1").animate({
        marginLeft: "500"
    }, 1200);
    /*end admin*/
    
    
    
    
    /*start store owner*/
    $(".Store").height($(window).height());
    
    
    
    $(".Store .navbar .links ul li").on('mouseenter', function () {
       $(this).addClass("active").siblings().removeClass("active"); 
    });
    
    
    
    $(".Store .store h1").animate({
        marginLeft: "500"
    }, 1200);
    /*end store owner*/
    
    
    
    
    /*start buy*/
    $(".Buy").height($(window).height());
    
    
    
    $(".Buy .navbar .links ul li").on('mouseenter', function () {
       $(this).addClass("active").siblings().removeClass("active"); 
    });
    
    
    
    
    $(".Buy .buy h1").animate({
        marginLeft: "350"
    }, 1200);
    
    
    
    
    $(".Buy .buy .row .col .buttonbuy1").on("click" , function(){
         $(".buy .sidebar1").slideToggle(800)                              
     });
    
    
    $(".Buy .buy .row .col .buttonbuy2").on("click" , function(){
         $(".buy .sidebar2").slideToggle(800)                              
     });
    
    
    $(".Buy .buy .row .col .buttonbuy3").on("click" , function(){
         $(".buy .sidebar3").slideToggle(800)                              
     });
    

    
    
    
    /*end buy*/
});