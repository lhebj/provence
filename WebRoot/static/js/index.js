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
		hideBgMusic();
		$("#video-play").appendTo($("body"));
		$("#video-play").show();
	});
	$(".right-video-side").on("click", function(){
		$("#video-play").hide();
		showBgMusic();
	});
	
	function showBgMusic(){
		if(navigator.userAgent.indexOf("MSIE")>=0 || navigator.userAgent.indexOf("rv:11.0")>=0 ) { 
			$("#bgmusic").append("<bgsound loop=\"infinite\" volume=\"-2500\" src=\"music/zhile.mp3\" >"); 
		}else{
			$("#bgmusic").append("<embed src=\"music/zhile.mp3\" loop=\"true\" VOLUME=0 hidden=\"true\"></embed>"); 
		} 
		
	}
	
	function hideBgMusic(){
		$("#bgmusic").empty();
	}
	
})