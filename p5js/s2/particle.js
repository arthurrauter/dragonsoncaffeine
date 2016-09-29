var Particle = function() {

this.pos = createVector(0,0);
this.vel = createVector(0,0);
this.accel = createVector(0,0);
this.force = createVector(0,0);
this.mass = 1;

this.color = [random(255), random(255), random(255)];
this.size = 100;

this.applyForce = function(force) {
    this.force.add(force);
};

this.bounceOnEdge = function() {
    if (this.pos.x + this.size/2 >= width || this.pos.x - this.size/2 <= 0) {
        this.vel.x *= -1;
        if (this.pos.x + this.size/2 >= width) {
           this.pos.x = width - this.size/2; 
        }
        if (this.pos.x - this.size/2 <= 0) {
           this.pos.x = 0 + this.size/2; 
        }
    }

    if (this.pos.y + this.size/2 >= height || this.pos.y - this.size/2 <= 0) {
        this.vel.y *= -1;
        if (this.pos.y + this.size/2 >= height) {
           this.pos.y = height - this.size/2; 
        }
        if (this.pos.y - this.size/2 <= 0) {
           this.pos.y = 0 + this.size/2; 
        }
    }
};

this.update = function() {
    this.accel.add(p5.Vector.div(this.force, this.mass));
    this.vel.add(p5.Vector.mult(this.accel, 1));
    this.pos.add(p5.Vector.mult(this.vel, 1));
    this.accel = createVector(0,0);
    this.force = createVector(0,0);
};

var jitter = 0.5;
this.draw = function() {
    stroke(0);
    strokeWeight(1);
    noStroke();
    fill(this.color);
    ellipse(this.pos.x + jitter, this.pos.y + jitter, this.size, this.size);
    jitter *= -1;
};
}
