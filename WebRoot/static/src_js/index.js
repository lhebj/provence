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
		var vid = $("#vid")[0].value;
		showVideo(vid);
	});
	$(".right-video-side").on("click", function(){
		pauseVideo();
		$("#video-play").hide();
		showBgMusic();
	});
	
	//ipad 循环播放
	var onEnded = function() {
	    this.play();
	};

	//ipad touch事件
	function touch(){
		var audio = document.getElementById('audio');
		audio.play();
		audio.addEventListener('ended', onEnded, false);
	}
	
	//播放音频
	function audioPlay(){
		var audio = document.getElementById('audio');
		audio.play();
		
		audio.addEventListener('ended', onEnded, false);
		document.addEventListener('touchstart',touch, false);
	}
	
	function showBgMusic(){
		if(navigator.userAgent.indexOf("MSIE")>=0 || navigator.userAgent.indexOf("rv:11.0")>=0 ) { 
			$("#bgmusic").append("<bgsound loop=\"infinite\" volume=\"-2500\" src=\"music/zhile.mp3\" >"); 
		}else{
			//$("#bgmusic").append("<embed src=\"music/zhile.mp3\" loop=\"true\" VOLUME=0 hidden=\"true\"></embed>");
			$("#bgmusic").append("<audio id=\"audio\" src=\"music/zhile.mp3\" hidden=\"hidden\" autoplay=\"autoplay\" loop=\"loop\"></audio>");
			audioPlay();
		} 
		
	}
	
	function hideBgMusic(){
		$("#bgmusic").empty();
	}
	
	function showVideo(myvid){
		player = new YKU.Player('youkuplayer',{
			styleid: '0',
			client_id: 'YOUR YOUKUOPENAPI CLIENT_ID',
			vid: myvid
		});
	}
	
	function pauseVideo(){
		player.pauseVideo();
	}	
	
	if(navigator.userAgent.indexOf("MSIE")>=0 || navigator.userAgent.indexOf("rv:11.0")>=0 ) { 
		
	}else{
		//解决ipad对于audio标签不能自动播放的问题，使用touch事件
		audioPlay();
	}
	
})