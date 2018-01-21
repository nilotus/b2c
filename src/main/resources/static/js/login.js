$(function() {
    var stuList = getStuList(); //设置传送信息

    //input
    $('input').eq(0).focus(function() {
        if($(this).val().length == 0) {
            $(this).parent().next("div").text("建议使用手机号登录");
        }
    })
    $('input').eq(1).focus(function() {
        if($(this).val().length == 0) {
            $(this).parent().next("div").text("建议使用字母、数字和符号两种以上的组合，6-20个字符");
        }
    })


    //input各种判断
    //用户名:手机号
    $('input').eq(0).blur(function() {
        if($(this).val().length == 0) {
            $(this).parent().next("div").text("");
            $(this).parent().next("div").css("color", '#ccc');
        } else if($(this).val().substr(0, 3) != 138 && $(this).val().substr(0, 3) != 189 &&
            $(this).val().substr(0, 3) != 139 && $(this).val().substr(0, 3) != 158 &&
            $(this).val().substr(0, 3) != 132 && $(this).val().substr(0, 3) != 131 &&
            $(this).val().substr(0, 3) != 188 && $(this).val().substr(0, 3) != 157 &&
            $(this).val().substr(0, 3) != 159 || $(this).val().length != 11) {
            $(this).parent().next("div").text("手机号格式不正确");
            $(this).parent().next("div").css("color", 'red');
        } else {
            $(this).parent().next("div").text("");
        }
    })

    //密码
    $('input').eq(1).blur(function() {
        if($(this).val().length == 0) {
            $(this).parent().next("div").text("");
            $(this).parent().next("div").css("color", '#ccc');
        } else if($(this).val().length > 1 && $(this).val().length < 6) {
            $(this).parent().next("div").text("长度只能在6-20个字符之间");
            $(this).parent().next("div").css("color", 'red');
        } else {
            $(this).parent().next("div").text("");
        }
    })


    //	提交按钮
    $("#submit_btn").click(function(e) {

        for(var j = 0; j < 2; j++) {
            if($('input').eq(j).val().length == 0) {
                $('input').eq(j).focus();
                if(j == 1) {
                    $('input').eq(j).parent().next().next("div").text("此处不能为空");
                    $('input').eq(j).parent().next().next("div").css("color", 'red');
                    e.preventDefault();
                    return;
                }
                $('input').eq(j).parent().next(".tips").text("此处不能为空");
                $('input').eq(j).parent().next(".tips").css("color", 'red');
                e.preventDefault();
                return;
            }
        }

        if($("#xieyi")[0].checked) {

            //发送用户信息
            stuList.push(new Student($('input').eq(0).val(), $('input').eq(1).val(),stuList.length + 1));
            localStorage.setItem('stuList', JSON.stringify(stuList));
            alert("登录成功");
            window.open("userlist.html", "_blank");
        }
    })

    //  建立构造函数
    function Student(name, password ) {
        this.name = name;
        this.password = password;

    }
    //	获取之前所有已经注册的用户集合
    function getStuList() {
        var list = localStorage.getItem('stuList');
        if(list != null) {
            return JSON.parse(list);
        } else {
            return new Array();
        }
    }

})