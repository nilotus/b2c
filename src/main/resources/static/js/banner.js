		$('.navigation').on('mouseenter', function() {
			console.log('move');
			$(".nav_right").removeClass('hide');
			
		});
		$('.navigation').on('mouseleave', function() {
			$(".nav_right").addClass('hide');
			$(".sub").addClass('hide');
		});
		$('.navigation').on('mouseenter', 'li', function(e) {
			var li_data = $(this).attr('data-id');
			$(".sub").addClass('hide');
			$('.sub[data-id="' + li_data + '"]').removeClass('hide');
		});