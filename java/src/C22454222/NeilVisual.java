package C22454222; // Package declaration

import ie.tudublin.*;
import processing.core.PApplet;

public class NeilVisual extends Visual {

    MainVisual mv;

    public NeilVisual(MainVisual mv) {
        this.mv = mv;
        // Generate the positions of the stars only once
        for (int i = 0; i < NUM_STARS; i++) {
            starX[i] = random(-mv.width / 2, mv.width);
            starY[i] = random(-mv.height, mv.height);
        }
    }
    // Number of stars
    final int NUM_STARS = 100;

    float[] starX = new float[NUM_STARS];
    float[] starY = new float[NUM_STARS];

    float[] colourArray = new float[] { random(0, 255), random(0, 255), random(0, 255) };
    float[] prevColours = new float[] { 0, 0, 0 };

    float radius = 50;
    int beatCount = 0;

    public float[] reassignColours(float[] colourArray) {
        float[] colours = new float[] { random(0, 255), random(0, 255), random(0, 255) };
        for (int i = 0; i < 3; i++) {
            colourArray[i] = colours[i];
        }
        return colourArray;
    }

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
        //fill shapes with colour 
        mv.fill(colourArray[0], colourArray[1], colourArray[2], 40);
         // increase radius of shape with beatCount
        radius= 5 * beatCount;
        mv.ellipse(0,0,radius,radius);

        if (radius > ((float) mv.width) / 2) 
        {
            for (int i = 0; i < 3; i++) {
                prevColours[i] = colourArray[i];
            }

            reassignColours(colourArray);
            beatCount = 0;
            radius = 20;
        }

        mv.rotate(MainVisual.map(mv.fCounter % 360, 0, 360, 0, MainVisual.PI * 2));
        mv.rect(-radius / 2, -radius / 2, radius, radius);

        for (int i = 0; i < NUM_STARS; i++) {
            // Set the size of the stars based on music's amplitude
            float starSize = random(5, 20) * space; // Increase the size range for bigger stars
            mv.fill(255); // Set star color to white
            mv.ellipse(starX[i], starY[i], starSize, starSize); // Draw the star
        }
    }
}