$(function(){		
	 
	$(".menu_all .first").click(function() {
			$('.menuu_s').hide();
			$(this).find(".menuu_s").toggle();
			$(".menu_all .first1").find(".menuu_s").hide();
		});
		$(document).on(
				'click',
				function(e) {
					if ($('.menu_all li').is(e.target)
							|| $('.menu_all li').has(e.target).length) {
						return;
					}
					$('.menuu_s').hide();

				});
	});