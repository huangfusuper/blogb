//加载弹出层组件
layui.use('layer',function(){

    var layer = layui.layer;

    //登录的点击事件
    $("#sub").on("click",function(){
        login();
    })

    $("body").keydown(function(){
        if(event.keyCode == "13"){
            login();
        }
    })

    //登录函数
    function login(){
        var username = $(" input[ name='username' ] ").val();
        var password = $(" input[ name='password' ] ").val();
        $.ajax({
            url:"/login",
            data:{"username":username,"password":password},
            type:"post",
            dataType:"json",
            success:function(data){
                if(data.code=='200'){
                    window.location = "/test.html";
                }else{
                    layer.msg(data.msg);
                }
            }
        })
    }
})
