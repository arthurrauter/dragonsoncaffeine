var Attractor = function(particle, gravitationalConstant) {
    this.G = gravitationalConstant;
    this.particle = particle;
    this.initialSize = particle.size;
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

    this.wiggle = -1;
    this.draw = function() {
        this.particle.size += this.wiggle;
        if (this.particle.size <= 0 || this.particle.size >= this.initialSize) {
            this.wiggle *= -1;
        }
        this.particle.draw();
    }
}
