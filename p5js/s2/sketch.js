var attractor;
var particles = [];
var N = 2000;

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
    attractorCore.size = (10);
    attractorCore.mass = (100);

    attractor = new Attractor(attractorCore, 30);
}

var k;
var v;
var e;
function draw() {
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
        var vToCenter = p5.Vector.sub(particles[i].pos, createVector(width/2, height/2));
        var distFromCenter = vToCenter.mag()
        if (distFromCenter < 10) {
            particles[i].pos = createVector(random(-1000,1000),random(-1000,1000));
            particles[i].vel = createVector(0,0);
            particles[i].accel = createVector(0,0);
            particles[i].force = createVector(0,0);
            particles[i].color = [random(255), random(255), random(255)];
        }
        //v = particles[i].vel.mag();
        //var k = (particles[i].mass * (v * v))/2
        //var e = (attractor.particle.mass * particles[i].mass * attractor.G)/attractor.lastr;
        //var totalE = k + e
        //console.log("p", i, " ", totalE);
    }
   // console.log(k);
   // console.log(e);
}
