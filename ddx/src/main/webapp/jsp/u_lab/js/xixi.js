$(document).ready(function(){
	/* This code is executed after the DOM has been completely loaded */

	/* Changing thedefault easing effect - will affect the slideUp/slideDown methods: */
	//$.easing.def = "easeOutBounce";

	/* Binding a click event handler to the links: */
	$('.PartnerLabsadminqianjin_right_top a').click(function(e){
	
		/* Finding the drop down list that corresponds to the current section: */
		var PartnerLabsadminqianjin_right_middle = $(this).parent().next();
		var PartnerLabsadminqianjin_right_bottom = PartnerLabsadminqianjin_right_middle.next();
		
		/* Closing all other drop down sections, except the current one */
		$('.PartnerLabsadminqianjin_right_middle').not(PartnerLabsadminqianjin_right_middle).slideUp('slow');
		$('.PartnerLabsadminqianjin_right_bottom').not(PartnerLabsadminqianjin_right_bottom).hide();
		PartnerLabsadminqianjin_right_middle.slideToggle('slow');
		PartnerLabsadminqianjin_right_bottom.toggle();
	
		//$(".PartnerLabsadminqianjin_right_bottom").toggle();
		/* Preventing the default event (which would be to navigate the browser to the link's address) */
		e.preventDefault();
	})

	
});



 



