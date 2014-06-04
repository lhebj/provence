$(function(){
	var height = $('.banner').height();
	var width = $('.banner').width();
	$('#banner-slides').slidesjs({
		width: width,
		height: height,
		navigation: {
	        active: false
	     },
	      pagination: {
	        active: false
	     },
	     play: {
	         effect: "slide",
	         interval: 5000,
	         auto: true,
	         pauseOnHover: false,
	         restartDelay: 2500
	     } 
	});
});