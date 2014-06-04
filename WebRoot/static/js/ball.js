function Ball(radius, point, color){
	this.radius = radius;
	this.point = point;
	this.color = color;
}
Ball.prototype.draw = function(context){
	context.save();
	context.lineWidth = 2;
	context.fillStyle = this.color;
	context.strokeStyle = this.color;
	context.beginPath();
	context.arc(this.point.x, this.point.y, this.radius, 0, (Math.PI*2));
	context.closePath();
	context.fill();
	context.stroke();
	context.restore();
}
Ball.prototype.randomMove = function(context){
	var x = Math.random() * 50 - 25;
	var y = Math.random() * 50 - 25;
	this.point.x = this.point.x - x;
	this.point.y = this.point.y - y;
	var minX = this.radius;
	var maxX = this.maxX - this.radius;
	var minY = this.radius;
	var maxY = this.maxY - this.radius;
	if(this.point.x < minX){
		this.point.x = minX;
	}
	if(this.point.x > maxX){
		this.point.x = maxX;
	}
	if(this.point.y < minY){
		this.point.y = minY;
	}
	if(this.point.y > maxY){
		this.point.y = maxY;
	}
	this.draw(context);
}
Ball.prototype.maxX = 600;
Ball.prototype.maxY = 550;