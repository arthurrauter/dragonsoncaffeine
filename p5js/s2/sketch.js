var particle;
function setup() {
    createCanvas(200, 200);
    particle = new Particle();
    particle.pos = createVector(width/2, height/2);
    particle.vel = createVector(0.7, 1);
}

function draw() {
    background(255);
    particle.update();
    particle.checkEdges();
    particle.draw();
}
