$(function(){
	$(".menu .first").click(function(){
		$(this).find(".menu_s").toggle();
		$(this).siblings().find(".menu_s").hide();
	});   
	$(".menu01 .first").click(function(){
		$(this).find(".menu_sa").toggle();
		$(this).siblings().find(".menu_sa").hide();
	}); 
	 $(document).on('click', function(e) {
	        if ($('.menu li').is(e.target) || $('.menu li').has(e.target).length) {
	          return;
	        }
	        $('.menu_s').hide();
			if ($('.menu01 li').is(e.target) || $('.menu01 li').has(e.target).length) {
	          return;
	        }
	        $('.menu_sa').hide();
	      }); 
});