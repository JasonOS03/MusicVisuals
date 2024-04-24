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
        float smooth = getSmoothedAmplitude();// function to make the amplitude smoother

        // Iterate until the audio buffer size is reached
        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i)); // Get the values in the buffer and add the values to the sum
        }
        float average = sum / (float) ab.size(); // Calculate the average buffer value 
        float amplitude = average * 800; // Amplitude is average times a certain number, in this case it's 800   
        float smoothrotation = lerp(0, radians(amplitude), 0.05f); // Interpolate from 0 to the amplitude in radians at an amount of 0.05
        float circlerotation = lerp(0, radians(360), 0.05f); // Interpolates from 0 to 360 degrees in radians, allowing the circles to move around in a circle 
        float CenterY = mv.height / 2; // Center of screen Y value
        float CenterX = mv.width / 2; // Center of screen X value
        float CircleX = 200; // Circle x axis position
        float CircleY = 200;
         // Circle y axis position

        mv.translate(CenterX, CenterY); // Move (0,0) to the center

        int num_lines = (int) map(amplitude, 0, 1, 0, 4); // Ensures that if the amplitude is 1, there are 4 lines
        int num_circles = (int) map(amplitude, 0, 1, 0, 3); // If the amplitude is 1, there will be 3 circles

        for (int i = 0; i < num_lines; i++) {
            float hue = map(i, 0, num_lines - 1, 0, 255); // Map the lines to the color spectrum for the hue

            float y_axis = map(i, 0, num_lines, -CenterY/2, CenterY/2);// y_axis variable mapped from 0 to the number of lines to - height/4 to the height/4 
            mv.rotate(smooth + smoothrotation); // Rotate the lines 

            mv.stroke(hue, 100, 100); // Set the color of the stroke
            mv.strokeWeight(4); // Thickness of the lines
            mv.noFill();
            mv.line(-CenterX, y_axis, CenterX, -y_axis); // Create the lines starting from -CenterX on the X axis and the Y axis value, spanning to CenterX on the X axis and -y_axis on the y axis
        }

        for (int i = 0; i < num_circles; i++) {
            float hue = map(i, 0, num_lines - 1, 150, 255); // map the circles to the color spectrum
            mv.stroke(hue, 255, 255);
            mv.noFill();
            mv.rotate(smooth + smoothrotation); // rotate the circles

            mv.strokeWeight(4);
            mv.ellipse(0, 0, CenterX/2, smooth + smoothrotation); // Create circles starting at the origin, with a diameter of CenterX and the height being the amplitude 

            mv.stroke(hue, 255, 255);
            mv.noFill();
            mv.rotate(smooth + circlerotation); // Rotate in a circular motion

            mv.strokeWeight(4);
            mv.ellipse(CircleX - CenterX/2, CircleY - CenterY/2, CenterX/2, CenterY/2); // create smaller  circles rotating around the center
        }
    }
}
