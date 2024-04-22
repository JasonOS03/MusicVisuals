package C22400796;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ie.tudublin.*;
import processing.core.PApplet;

public class JasonVisual extends PApplet 
{

        
    AudioBuffer ab;// initialise the buffer
    Minim minim;// initialise the minim
    AudioPlayer newplayer; // intialise the audio player


    public void settings()
    {
        // window size
        size(800,800);
    }


    public void setup()
    {
        colorMode(HSB);
        background(0);// black background

        minim = new Minim(this);
        newplayer = minim.loadFile("Project.wav");// load the file
        newplayer.play();// play the file

        ab = newplayer.mix;


    }

    public void draw()
    {
        background(0);// black background

    
    float sum = 0;

    // iterate until the audio buffer size is reached
    for (int i = 0; i < ab.size(); i++) {
        sum += abs(ab.get(i));// get the values in the buffer and add the values to the sum
    }
    float average = sum / (float) ab.size(); // calculate the average buffer value 
    float amplitude = average * 800; // amplitude is average times a certain number , in this case its 800   
    float smoothrotation = lerp(0,radians(amplitude),0.1f);//interpolate from 0 to the amplitude in radians at an amount of 0.1
    float circlerotation = lerp(0,radians(360),0.01f);//interpolates from 0 to 360 degrees in radians , allowing the circles to move around in a circle 
    float CenterY = height/2; // center of screen Y value
    float CenterX = width/2; // center of screen X value
    float CircleX = 200; // circle x axis position
    float CircleY = 200; // circle y axis position
   
    translate(width/2,height/2);// move (0,0) to the center
    
    int num_lines = (int) map(amplitude, 0, 1, 0,4);// ensures that if the amplitude is 1, there is 4 lines
    int num_circles = (int) map(amplitude,0,1,0,3); // if the amplitude is 1 , there will be 3 circles
    
   
    for (int i = 0; i < num_lines; i++) {
        float hue = map(i, 0, num_lines - 1, 0, 255);

        float y_axis = map(i, 0, num_lines, CenterY, CenterY);
        rotate(smoothrotation);

        stroke(hue, 100, 100);
        strokeWeight(4);
        noFill();
        line(0, y_axis, width, CenterY - y_axis);
    
       
    }
    for(int i = 0;i<num_circles;i++)
    {
        float hue = map(i, 0, num_lines - 1, 150, 255);
        stroke(hue,255,255);
        noFill();
        rotate(smoothrotation);

        strokeWeight(4);
        ellipse(0,0,CenterX/2,amplitude);

        stroke(hue,255,255);
        noFill();
        rotate(circlerotation);

        strokeWeight(4);
        ellipse(CircleX,CircleY,CenterX/4,CenterY/4);

        
    }
    
    
    

}
               
        
            
    public static void main(String[] args) {
        PApplet.main("C22400796.JasonVisual");
    }
    
}
