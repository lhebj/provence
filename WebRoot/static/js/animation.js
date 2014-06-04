//页面内所有球的初始化的数据
ballConfig = [
				{ radius : 115, point : {x:121, y:106}, color : '#f2eff8'},
				{ radius : 88,  point : {x:169, y:179}, color : 'ebebe9'},
				{ radius : 88,  point : {x:169, y:221}, color : 'ebebe9'},
				{ radius : 120,  point : {x:294, y:200}, color : 'f4ebf0'},
				{ radius : 120,  point : {x:231, y:271}, color : 'ebebe9'}
				];
window.onload = function(){
	init();
	ballInit();
}
//页面全局变量初始化
function init(){
	window.canvas = document.getElementById("canvas");
	window.context = canvas.getContext("2d");
	window.canvas1 = document.createElement("canvas");//创建一个模拟canvas用于动画
	window.context1 = canvas1.getContext("2d");
	window.canvas1.width = window.canvas.width;
	window.canvas1.height = window.canvas.height;
	context.globalCompositeOperation = "destination-over";
	context1.globalCompositeOperation = "destination-over";
	window.ballPool = [];//页面内所有球的信息数据
	Ball.prototype.maxX = window.canvas.width;
	Ball.prototype.maxY = window.canvas.height;
}
function ballFactory(obj){
	var radius = obj.radius || 100;
	var point =  obj.point || {x: 230,y: 100}
	var color = obj.color || 'red';
	var ball = new Ball(radius, point, color);
	ball.draw(window.context);
	window.ballPool.push(ball);
	return ball;
}
(function(){
	index = 0;//记录已经初始化第几个球
	ballInit = function(){
		ballFactory(ballConfig[index]);
		index++;
		if( index < ballConfig.length ){
			setTimeout(ballInit, 1500);
		}else{
			ballConfig = [];
			ballAnimation();
			delete ballConfig;
		}
	}
})();
(function(){
	var pool, context, context1;
	var width, height;
	function initAmi(){
		pool = pool || window.ballPool;
		context = context || window.context;
		context1 = context1 || window.context1;
		canvas1 = canvas1 || window.canvas1;
		width = canvas1.width;
		height = canvas1.height;
	}
	ballAnimation = function(){
		if(pool == undefined){
			initAmi();
		}
		context.clearRect(0, 0, width, height);
		context1.clearRect(0, 0, width, height);
		for(var i in pool){
			pool[i].randomMove(context1);
		}
		context.drawImage(canvas1, 0, 0, canvas1.width, canvas1.height);
		setTimeout(ballAnimation, 1500);
	}
})();