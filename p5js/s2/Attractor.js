var Attractor = function(particle, gravitationalConstant) {
    this.G = gravitationalConstant;
    this.particle = particle;
    this.lastr;

    
    this.pull = function(particle) {
        var d = p5.Vector.sub(this.particle.pos, particle.pos);
        var forceDirection = d.copy().normalize();
        var r = d.mag();
        var forceMagnitude = (this.G * this.particle.mass * particle.mass) / (r * r);

        if (forceMagnitude > 1) {
            forceMagnitude = 1;
        }
        //forceMagnitude = constrain(forceMagnitude, 0.0001, 25);

        var g = p5.Vector.mult(forceDirection, forceMagnitude);
        this.lastr = r;
        particle.applyForce(g);
    }

    this.update = function() {
        this.particle.update();
    }

    this.draw = function() {
        this.particle.draw();
    }
}
