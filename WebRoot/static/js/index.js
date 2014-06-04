$(function(){
			
	$("#index-slides").slidesjs({
		width: 970,
		height: 515,
		navigation:{
			active:false
			},
		play:{
			auto:true,
			interval: 2500
		},
		effect: {
	        slide: {
	          speed: 3000
	        },
	        fade: {
	          speed: 100,
	          crossfade: true
	        }
	      }
	});
	$("body").on("click", function(event){
		var target = event.target;
		if($(target).parents().is(".index-shopping") || $(target).is(".index-shopping")){
			$(".shopping-contaiter").show();
		}else{
			$(".shopping-contaiter").hide();
		}
	});
	
	$(".video-pic").on("click", function(){
		$("#video-play").appendTo($("body"));
		$("#video-play").show();
	});
	$(".right-video-side").on("click", function(){
		$("#video-play").hide();
	});
})