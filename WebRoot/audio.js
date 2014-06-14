//var audio = $("#audio");
var audio = document.getElementById('audio');
audio.play();
var onEnded = function() {
    this.play();
};

audio.addEventListener('ended', onEnded, false);

document.addEventListener('touchstart',touch, false);

function touch(){
	var audio = document.getElementById('audio');
	audio.play();
	audio.addEventListener('ended', onEnded, false);
}