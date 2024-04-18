package C22454222; // Package declaration

import ie.tudublin.*;
import processing.core.PApplet;

public class NeilVisual extends Visual {

    MainVisual mv;

    public NeilVisual(MainVisual mv) {
        this.mv = mv;
        // Generate the positions of the stars only once
        for (int i = 0; i < NUM_STARS; i++) {
            starX[i] = random(-mv.width / 2, mv.width / 2);
            starY[i] = random(-mv.height / 2, mv.height / 2);
        }
    }
    // Number of stars
    final int NUM_STARS = 100;

    float[] starX = new float[NUM_STARS];
    float[] starY = new float[NUM_STARS];

    float radius = 50;
    int beatCount = 0;

    public void render() {
        mv.background(0, 0, 0);
        mv.fCounter++;
        mv.translate(mv.width/2, mv.height/2);
        float space = mv.getSmoothedAmplitude();
        mv.beat.detect(mv.as.mix);
        mv.beat.detectMode(0); // Setting beat detection mode

        if (mv.beat.isKick())
        {
            beatCount++;
        }
        radius= 5 * beatCount;
        mv.ellipse(0,0,radius,radius);

        for (int i = 0; i < NUM_STARS; i++) {
            // Set the size of the stars based on music's amplitude
            float starSize = random(5, 20) * space; // Increase the size range for bigger stars
            mv.fill(255); // Set star color to white
            mv.ellipse(starX[i], starY[i], starSize, starSize); // Draw the star
        }
    }
}