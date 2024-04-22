package C22454222; // Package declaration

import ie.tudublin.*;
import processing.core.PApplet;

public class NeilVisual extends Visual {

 // Reference to the MainVisual class
    MainVisual mv;

    // Constructor
    public NeilVisual(MainVisual mv) {
        // Initialize the MainVisual object
        this.mv = mv;
        // Generate the positions of the stars only once
        for (int i = 0; i < NUM_STARS; i++) {
            starX[i] = random(-mv.width / 2, mv.width);
            starY[i] = random(-mv.height, mv.height);
        }
    }

    // Number of stars
    final int NUM_STARS = 100;

    // Arrays to store star positions
    float[] starX = new float[NUM_STARS];
    float[] starY = new float[NUM_STARS];

    // Arrays to store color information
    float[] colourArray = new float[] { random(0, 255), random(0, 255), random(0, 255) };
    float[] prevColours = new float[] { 0, 0, 0 };

     // Radius of shapes and beat count
    float radius = 20;
    int beatCount = 0;

 // Method to reassign colors
    public float[] reassignColours(float[] colourArray) {
        float[] colours = new float[] { random(0, 255), random(0, 255), random(0, 255) };
        for (int i = 0; i < 3; i++) {
            colourArray[i] = colours[i];
        }
        return colourArray;
    }

 // Method to render visual elements
    public void render() {
        // Set background color to black
        mv.background(0, 0, 0);
        // Increment the frame counter
        mv.fCounter++;
         // Translate origin to the center of the canvas
        mv.translate(mv.width/2, mv.height/2);
        // Get smoothed amplitude of audio signal
        float space = mv.getSmoothedAmplitude();
        // Detect beats in the audio
        mv.beat.detect(mv.as.mix); // Setting beat detection mode
        mv.beat.detectMode(0); // Setting beat detection mode

         // Check if a kick is detected
        if (mv.beat.isKick())
        {
            // Increment beat count
            beatCount++;
        }
        //fill shapes with colour
        mv.fill(colourArray[0], colourArray[1], colourArray[2], 40);

        //increase radius of shape with beatCount
        radius = 5 * beatCount;
        mv.ellipse(0,0,radius,radius);

        // Rotate and fill shapes with previous colors
        mv.rotate(MainVisual.map(mv.fCounter % 360, 0, 360, 0, MainVisual.PI * 2));
        mv.fill(prevColours[0], prevColours[1], prevColours[2], 25);
        mv.rect(-radius / 2, -radius / 2, radius, radius);

        // Set stroke color based on amplitude
        mv.stroke(map(mv.getAmplitude(), 0, 1, 0, 255), 255, 255);

         // Check if shape size exceeds window size
        if (radius > ((float) mv.width) / 2) 
        {
            // Update previous colors, reassign colors, reset beat count, and reset radius
            for (int i = 0; i < 3; i++) {
                prevColours[i] = colourArray[i];
            }
            reassignColours(colourArray);
            beatCount = 0;
            radius = 20;
        }
         // Loop through the width of the canvas with a step of 0.1
        for (float i = 0; i < mv.width; i += 0.1) {
            // Calculate the x and y coordinates based on cosine and sine functions
            float x = (PApplet.cos(i) * space * i); // Using PApplet's cos function to modulate the x-coordinate of points based on the music amplitude
            float y = (PApplet.sin(i) * space * i); // Using PApplet's sin function to modulate the y-coordinate of points based on the music amplitude
            mv.point(x, y); // draw point at x and y 
        }

         // Loop through the array of stars
        for (int i = 0; i < NUM_STARS; i++) {
            // Set the size of the stars based on music's amplitude
            float starSize = random(5, 20) * space; 
            // Set star color to white as default 
            mv.fill(255); 
            // Draw the star
            mv.ellipse(starX[i], starY[i], starSize, starSize);
        }
    }
}
