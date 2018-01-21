$(function() {
	var stuList = getStuList(); //设置传送信息

	//input
	$('input').eq(0).focus(function() {
		if($(this).val().length == 0) {
			$(this).parent().next("div").text("支持中文，字母，数字，'-'，'_'的多种组合");
		}
	})
	$('input').eq(1).focus(function() {
		if($(this).val().length == 0) {
			$(this).parent().next("div").text("建议使用字母、数字和符号两种以上的组合，6-20个字符");
		}
	})
	$('input').eq(2).focus(function() {
		if($(this).val().length == 0) {
			$(this).parent().next("div").text("请再次输入密码");
		}
	})
	$('input').eq(3).focus(function() {
		if($(this).val().length == 0) {
			$(this).parent().next("div").text("请输入正确邮箱");
		}

	})

	$('input').eq(4).focus(function() {
		if($(this).val().length == 0) {
			$(this).parent().next("div").text("请输入正确地址");
		}
	})
	$('input').eq(5).focus(function() {
		if($(this).val().length == 0) {
			$(this).parent().next("div").text("请输入手机号");
		}
	})


	//input各种判断
	//用户名：
	$('input').eq(0).blur(function() {
		if($(this).val().length == 0) {
			$(this).parent().next("div").text("");
			$(this).parent().next("div").css("color", '#ccc');
		} else if($(this).val().length > 0 && $(this).val().length < 4) {
			$(this).parent().next("div").text("长度只能在4-20个字符之间");
			$(this).parent().next("div").css("color", 'red');
		} else if($(this).val().length >= 4 && !isNaN($(this).val())) {
			$(this).parent().next("div").text("用户名不能为纯数字");
			$(this).parent().next("div").css("color", 'red');
		} else {
			for(var m = 0; m < stuList.length; m++) {
				if($(this).val() == stuList[m].name) {
					$(this).parent().next("div").text("该用户名已被注册");
					$(this).parent().next("div").css("color", 'red');
					return;
				}
			}
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

	//	确认密码
	$('input').eq(2).blur(function() {
		if($(this).val().length == 0) {
			$(this).parent().next("div").text("");
			$(this).parent().next("div").css("color", '#ccc');
		} else if($(this).val() != $('input').eq(1).val()) {
			$(this).parent().next("div").text("两次密码不匹配");
			$(this).parent().next("div").css("color", 'red');
		} else {
			$(this).parent().next("div").text("");
		}
	})

	// 邮箱验证
	var regEmail = /^(\w)+(\.\w+)*@(\w)+((\.\w+)+)$/;
	$('input').eq(3).blur(function() {
		if(regEmail.test($(this).val())) {
			$(this).parent().next("div").text("");
		} else {

			$(this).parent().next("div").text("邮箱格式不正确");
			$(this).parent().next("div").css("color", 'red');
		}
	});

	//地址验证	

	$('input').eq(4).blur(function() {
		if($(this).val().length == 0) {
			$(this).parent().next("div").text("");
			$(this).parent().next("div").css("color", '#ccc');
		} else if($(this).val().length > 0 && $(this).val().length < 4) {
			$(this).parent().next("div").text("长度在4个字符以上");
			$(this).parent().next("div").css("color", 'red');
		} else if($(this).val().length >= 4 && !isNaN($(this).val())) {
			$(this).parent().next("div").text("地址不能为纯数字");
			$(this).parent().next("div").css("color", 'red');
		} else {
			$(this).parent().next("div").text("");
		}
	});

	//	手机号
    $('input').eq(5).blur(function() {
        		if($(this).val().length == 0) {
         			$(this).parent().next("div").text("");
        			$(this).parent().next("div").css("color", '#ccc');
         		} else if(!(/^1[34578]\d{9}$/.test($(this).val()))) {
         			$(this).parent().next("div").text("手机号格式不正确");
         			$(this).parent().next("div").css("color", 'red');
         		} else {
         			$(this).parent().next("div").text("");
         		}
			})



	//	提交按钮
	$("#submit_btn").click(function(e) {
		 
		for(var j = 0; j < 7; j++) {
			if($('input').eq(j).val().length == 0) {
				$('input').eq(j).focus();
				if(j == 6) {
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
			stuList.push(new Student($('input').eq(0).val(), $('input').eq(1).val(), $('input').eq(3).val(), $('input').eq(4).val(),
				$('input').eq(5).val(),$('input').eq(6).val(),stuList.length + 1));
			localStorage.setItem('stuList', JSON.stringify(stuList));
			alert("注册成功");
			window.open("userlist.html", "_blank");
		} 
	})

	//  建立构造函数
	function Student(name, password, tel, id, email, address) {
		this.name = name;
		this.password = password;
		this.tel = tel;
		this.id = id;
		this.email = email;
		this.address = address;
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