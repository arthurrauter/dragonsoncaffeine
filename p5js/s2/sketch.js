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

    attractor = new Attractor(attractorCore, 0.02);
}

var k;
var v;
var e;
function draw() {
    background(255);
    attractor.update();
    attractor.particle.bounceOnEdge();
    attractor.draw();
    k = 0;
    e = 0;
    for (var i = 0; i < N; i++) {
        attractor.pull(particles[i]);
        particles[i].update();
        particles[i].bounceOnEdge();
        particles[i].draw();
        v = particles[i].vel.mag();
        var k = (particles[i].mass * (v * v))/2
        var e = (attractor.particle.mass * particles[i].mass * attractor.G)/attractor.lastr;
        var totalE = k + e
        console.log("p", i, " ", totalE);
    }
   // console.log(k);
   // console.log(e);
}
