package C22454222; // Package declaration

import ie.tudublin.*;
import processing.core.PApplet;

public class NeilVisual extends Visual {

    MainVisual mv;

    public NeilVisual(MainVisual mv) {
        this.mv = mv;
    }

    float radius = 50;
    int beatCount = 0;

    public void render() {
        mv.background(0, 0, 0);
        float space = mv.getSmoothedAmplitude();
        radius= 5 * beatCount;
        mv.beat.detect(mv.as.mix);
        mv.beat.detectMode(0); // Setting beat detection mode
        mv.ellipse(0,0,radius,radius);
    }
}