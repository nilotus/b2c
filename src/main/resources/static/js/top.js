	$(function(){
	 		var back = $('.back');
	 		back.click(function(){
	 			var timer = setInterval(function(){
	 				$(window).scrollTop($(window).scrollTop()-60);
	 				if($(window).scrollTop() == 0){
	 					clearInterval(timer);
	 				}
	 			},20);
	 		});
	 	})