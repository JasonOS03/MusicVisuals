package C22454222;
import ddf.minim.Minim;
import processing.core.PApplet; 
import ie.tudublin.*;

public class ChrisVisual extends Visual 
{
    MainVisual mv; // Reference to the main visual class
    Minim minim; // Minim object for audio processing

    public ChrisVisual(MainVisual mv) 
    {
        this.mv = mv; // Assigning the reference to the main visual class
    }

    int kickCounter = 0; // Counter for kick detection
    
    float[] currentColours = new float[]{random(0,255),random(0,255),random(0,255)}; // Array to store current colors
    float[] previousColours = new float[]{0,0,0}; // Array to store previous colors

    // Method to generate random colors and replace current colors
    public float[] replacingColours(float[] currentColours)
    {
        float[] colours = new float[]{random(0,255),random(0,255),random(0,255)}; // Generating random colors
        for(int i = 0; i < 3; i++) // Looping through color channels
        {
            currentColours[i] = colours[i]; // Replacing current colors with new random colors
        }
        return currentColours; // Returning the updated colors
    }

    // Method to render visual effects
    public void render()
    {
        float radius = 20; // Initial radius for shapes
        mv.background(0,0,0); // Setting background color
        mv.beat.detect(mv.as.mix); // Detecting beats in the audio
        mv.beat.detectMode(0); // Setting beat detection mode
        mv.fCounter++; // Incrementing frame counter
        mv.translate(mv.width/2, mv.height/2); // Translating to the center of the screen

        float smooth = mv.getSmoothedAmplitude(); // Getting smoothed amplitude of the audio

        if (mv.beat.isKick()) // Checking if there's a kick in the audio
        {
            kickCounter++; // Incrementing kick counter
        }

        mv.fill(currentColours[0],currentColours[1],currentColours[2], 50); // Setting fill color with transparency

        radius = 40*kickCounter; // Adjusting radius based on kick counter
        mv.ellipse(0,0,radius,radius); // Drawing ellipse at the center

        mv.fill(previousColours[0],previousColours[1],previousColours[2], 25); // Setting fill color for previous shapes
        
        mv.stroke(map(mv.getAmplitude(), 0, 1, 0,255),255,255); // Setting stroke color based on amplitude   
        
        // Drawing triangles
        radius = 15*kickCounter; // Adjusting radius based on kick counter
        mv.triangle(-200, -100, -140+(float)0.6*radius, radius, (-260-(float)0.6*radius), radius); 
        mv.triangle(200, -100, 260+(float)0.6*radius, radius, (140-(float)0.6*radius), radius);
        mv.triangle(-400, -100, -340+(float)0.6*radius, radius, (-460-(float)0.6*radius), radius); 
        mv.triangle(400, -100, 460+(float)0.6*radius, radius, (340-(float)0.6*radius), radius);
        mv.triangle(-600, -100, -540+(float)0.6*radius, radius, (-660-(float)0.6*radius), radius); 
        mv.triangle(600, -100, 660+(float)0.6*radius, radius, (540-(float)0.6*radius), radius);
        
        // Drawing mirrored triangles
        mv.triangle(-200, 100, -140+(float)0.6*radius, -radius, (-260-(float)0.6*radius), -radius); 
        mv.triangle(200, 100, 260+(float)0.6*radius, -radius, (140-(float)0.6*radius), -radius);
        mv.triangle(-400, 100, -340+(float)0.6*radius, -radius, (-460-(float)0.6*radius), -radius); 
        mv.triangle(400, 100, 460+(float)0.6*radius, -radius, (340-(float)0.6*radius), -radius);
        mv.triangle(-600, 100, -540+(float)0.6*radius, -radius, (-660-(float)0.6*radius), -radius); 
        mv.triangle(600, 100, 660+(float)0.6*radius, -radius, (540-(float)0.6*radius), -radius);

        // Resetting values if radius exceeds half of the screen width
        if (radius > (float)mv.width / 2)
        {
            // Storing current colors as previous colors
            for (int i = 0; i < 3; i++)
            {
                previousColours[i] = currentColours[i];
            }
            // Generating and replacing new colors
            replacingColours(currentColours);
            kickCounter = 0; // Resetting kick counter
            radius = 20; // Resetting radius
        }

        // Drawing points in a spiral pattern
        for (float i = 0; i < mv.width; i += 0.3)
        {
            float x1 = (PApplet.cos(i) * smooth * i);
            float y1 = (PApplet.sin(i) * smooth * i);
            mv.point(x1, y1);
        }

        // Drawing points in a spiral pattern with center at (-400, 0)
        for (float i = 0; i < mv.width; i += 0.3)
        {
            float centerX2 = -400; 
            float centerY2 = 0; 
            float x2 = centerX2 + (PApplet.cos(i) * smooth * i);
            float y2 = centerY2 + (PApplet.sin(i) * smooth * i);
            mv.point(x2, y2);
        }

        // Drawing points in a spiral pattern with center at (400, 0)
        for (float i = 0; i < mv.width; i += 0.3)
        {
            float centerX3 = +400; 
            float centerY3 = 0; 
            float x3 = centerX3 + (PApplet.cos(i) * smooth * i);
            float y3 = centerY3 + (PApplet.sin(i) * smooth * i);
            mv.point(x3, y3);
        }
    }
}
