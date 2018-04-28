$(document).ready(function(){
     //jasson placeholder
    $(".SignIn .Form1 .signin").on('click',function(){
       $.ajax({
        url:'http://localhost:8080/onlinemarket/signin',
        method:"GُET",
        success:function(res){
            location.href = "LogIn.html";
        },
        error:function(res){
            alert("check your input again")
        }
     }); 
    });
    
    
    
    $(".SignUp .Form2 .signup  ").on('click',function(){
		alert("Hello");
        $.ajax({
        url:'http://localhost:8080/onlinemarket/signup',
        method:"GET",
        success:function(res){
            location.href = "signup.html";
        },
        error:function(res){
            alert("check your input again");
        }
    });
    });
    
    
    
    
    
    
    $.ajax({
        url:'localhost:8080/onlinemarket/buyproduct',
        method:"Get",
        success:function(res){
            location.href = "Administrator.html";
        },
        error:function(res){
            alert("check your input again")
        }
    });
    
    

    
    
    
    
    
    
    
    
    
    $(".admin .row .col .buttonProduct",".Store .store .row .col .buttonProduct" ).on('click',function(){
        $.ajax({
        url:'http://localhost:8080/onlinemarket/addproduct',
        method:"Get",
        success:function(res){
            location.href = "Administrator.html";
        },
        error:function(res){
            alert("check your input again")
        }
    });
    });
    
    
    
    $(".Store .store .row .col .buttonStore",".admin .row .col .buttonStore").on('click',function(){
        $.ajax({
        url:'http://localhost:8080/onlinemarket/addstore/request',
        method:"Get",
        success:function(res){
            location.href = "Administrator.html";
        },
        error:function(res){
            alert("check your input again")
        }
    });
    });
    
    
    
    
    
    
    
    $(".admin .row .col .buttonState").on('click',function(){
        $.ajax({
        url:'http://localhost:8080/onlinemarket/addStatistics/request',
        method:"Get",
        success:function(res){
            location.href = "Administrator.html";
             $.each(data,function(i,post){
                $("#ajax-data").append('<div class="st"><div class="show"> \
                                       '+ post.title+'\
                                       </div>\
                                        <div class="bodyy">'+ post.body+'</div>\
                                       </div>')
            })
        },
        error:function(res){
            alert("check your input again");
        }
    });
    
};
    });
    