var attractor;
var particles = [];
var N = 4;

function setup() {
    createCanvas(windowWidth, windowHeight);
    createCanvas(400, 400);
    for (var i = 0; i < N; i++) {
        var p = new Particle();
        p.size = 10;
        p.pos = createVector(random(width), random(height));
        particles.push(p);
    }

    attractorCore = new Particle();
    attractorCore.pos = createVector(width/2, height/2);
    attractorCore.color = [0,0,0];
    attractorCore.size = (100);
    attractorCore.mass = (100);

    attractor = new Attractor(attractorCore, 2);
}

var k;
function draw() {
    background(255);
    attractor.draw();
    for (var i = 0; i < N; i++) {
        attractor.pull(particles[i]);
        particles[i].update();
        particles[i].bounceOnEdge();
        particles[i].draw();
        k += particles[i].vel.mag();
    }
    console.log(k);
    k = 0;
}
