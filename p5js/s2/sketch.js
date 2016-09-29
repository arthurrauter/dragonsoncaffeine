var particles = [];
var N = 2;

function setup() {
    createCanvas(windowWidth, windowHeight);
    createCanvas(400, 400);
    for (var i = 0; i < N; i++) {
        var p = new Particle();
        p.size = 10;
        p.pos = createVector(random(width), random(height));
        particles.push(p);
        particles[i].applyForce(createVector(random(30),random(30)));
    }
}

function draw() {
    //background(255);
    for (var i = 0; i < N; i++) {
        particles[i].update();
        particles[i].bounceOnEdge();
        particles[i].draw();
    }
}
