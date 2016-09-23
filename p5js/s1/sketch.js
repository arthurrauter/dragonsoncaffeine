//Random Walker
var BALLS = [];
var CRAZYBALLS = [];
var STROKEBALLS = 0;
var STROKETEXT = 20;

function setup() {
	createCanvas(windowWidth, windowHeight);

	for (var i=0; i<1000; i++) {
		BALLS[i] = new Ball();
	}

	for (var i=0; i<4; i++) {
		CRAZYBALLS[i] = new CrazyBall();
	}

}

function draw() {
	textSize(60);
	stroke(0);
	strokeWeight(STROKETEXT);
	textAlign(CENTER);
	text("THIS PAGE WAS NOT FOUND", width/2, height/2);
	for (var i=0; i<CRAZYBALLS.length; i++) {
		CRAZYBALLS[i].update();
		CRAZYBALLS[i].draw();
	}
	strokeWeight(random(STROKEBALLS));
	for (var i=0; i<BALLS.length; i++) {
		BALLS[i].update();
		BALLS[i].draw();
	}
}

var offset = 0.0;
function CrazyBall() {
	this.reset = function() {
		this.size = 10;
		this.color = [random(255), random(255), random(255)];
		this.pos = createVector(width/4, height/4);
		this.vel = createVector(0,0);
		this.acel = createVector(0,0);
	}

	this.reset();
	
	this.update = function() {
        this.acel = createVector(random(-1,1), random(-1,1));
		this.vel.add(p5.Vector.mult(this.acel, 1));
		this.pos.add(p5.Vector.mult(this.vel, 1));

		if (this.pos.x > width || this.pos.y > height || this.pos.x < 0 || this.pos.y < 0) {
			this.reset();
		}
	}

	this.draw = function() {
		fill(this.color);
		text("404", this.pos.x, this.pos.y);
	}
}

function Ball() {

	this.reset = function() {
		this.size = 20;
		this.color = [random(255), random(255), random(255)];
		this.pos = createVector(width/4, height/4);
		this.vel = createVector(0,0);
		this.acel = createVector(random(-1,1), random(-1,1));
		this.acel.setMag(0.1);

	}

	this.reset();

	this.update = function() {
		this.pos.add(this.vel);
		this.vel.add(this.acel);
		if (this.pos.x > width || this.pos.y > height || this.pos.x < -width || this.pos.y < -height) {
			this.reset();
		}
	}

	this.draw = function() {
			fill(this.color);
			ellipse(this.pos.x, this.pos.y, this.size, this.size);
	}
}

