package C22454222;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ie.tudublin.*;

public class JasonVisual extends Visual 
{
    AudioBuffer ab; // Initialize the buffer
    AudioPlayer newplayer;
    MainVisual mv; // Initialize the audio player

    public JasonVisual(MainVisual mv) {
        this.mv = mv;
        this.ab = mv.getAudioBuffer();
    }

    public void settings()
    {
        // Window size
        size(800, 800);
    }

    public void setup()
    {
        colorMode(HSB);
        mv.background(0); // Black background

        ab = newplayer.mix;
    }

    public void render()
    {
        mv.background(0); // Black background

        float sum = 0;

        // Iterate until the audio buffer size is reached
        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i)); // Get the values in the buffer and add the values to the sum
        }
        float average = sum / (float) ab.size(); // Calculate the average buffer value 
        float amplitude = average * 800; // Amplitude is average times a certain number, in this case it's 800   
        float smoothrotation = lerp(0, radians(amplitude), 0.1f); // Interpolate from 0 to the amplitude in radians at an amount of 0.1
        float circlerotation = lerp(0, radians(360), 0.01f); // Interpolates from 0 to 360 degrees in radians, allowing the circles to move around in a circle 
        float CenterY = height / 2; // Center of screen Y value
        float CenterX = width / 2; // Center of screen X value
        float CircleX = 200; // Circle x axis position
        float CircleY = 200; // Circle y axis position

        mv.translate(width / 2, height / 2); // Move (0,0) to the center

        int num_lines = (int) map(amplitude, 0, 1, 0, 4); // Ensures that if the amplitude is 1, there are 4 lines
        int num_circles = (int) map(amplitude, 0, 1, 0, 3); // If the amplitude is 1, there will be 3 circles

        for (int i = 0; i < num_lines; i++) {
            float hue = map(i, 0, num_lines - 1, 0, 255); // Map the lines to the color spectrum for the hue

            float y_axis = map(i, 0, num_lines, -CenterY, CenterY);
            mv.rotate(smoothrotation); // Rotate the lines 

            mv.stroke(hue, 100, 100); // Set the color of the stroke
            mv.strokeWeight(4); // Thickness of the lines
            mv.noFill();
            mv.line(-CenterX, y_axis, CenterX, - y_axis); // Create the lines starting from 0 on the X axis and the Y axis value, spanning to the width of the screen on the X axis and height/2 - the y axis on the y axis
        }

        for (int i = 0; i < num_circles; i++) {
            float hue = map(i, 0, num_lines - 1, 150, 255);// map the circles to the color spectrum
            mv.stroke(hue, 255, 255);
            mv.noFill();
            mv.rotate(smoothrotation);// rotate the circles

            mv.strokeWeight(4);
            mv.ellipse(0, 0, CenterX / 2, amplitude); // Create circles starting at the origin, with a length of CenterX/2 and the height being the amplitude 

            mv.stroke(hue, 255, 255);
            mv.noFill();
            mv.rotate(circlerotation); // Rotate in a circular motion

            mv.strokeWeight(4);
            mv.ambient(num_circles);
            mv.ellipse(CircleX, CircleY, CenterX / 4, CenterY / 4); // create smaller circles rotating around the inside circle
        }
    }
}

