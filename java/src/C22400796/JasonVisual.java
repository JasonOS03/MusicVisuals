package C22400796;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ie.tudublin.*;
import processing.core.PApplet;

public class JasonVisual extends PApplet 
{

        
    AudioBuffer ab;
    Minim minim;
    AudioPlayer newplayer;

    int mode = 0;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (newplayer.isPlaying()) {
                newplayer.pause();
            } else {
                newplayer.rewind();
                newplayer .play();
            }
        }
	}

    

    public void settings()
    {
        size(800,800);
    }


    public void setup()
    {
        colorMode(HSB);
        background(0);

        minim = new Minim(this);
        newplayer = minim.loadFile("Project.wav");
        newplayer.play();

        ab = newplayer.mix;
        y = height / 2;
        smoothedY = y;

        lerpedBuffer = new float[width];
    }

    public void draw()
    {
        background(0);

    
    float sum = 0;
    for (int i = 0; i < ab.size(); i++) {
        sum += abs(ab.get(i));
    }
    float average = sum / (float) ab.size();
    float amplitude = average * 800;    
    float smoothrotation = lerp(0,radians(amplitude),0.6f);
    float CenterY = height/2;
    float CenterX = width/2;

    translate(width/2,height/2);
    
    int num_diagonals = (int) map(amplitude, 0, 1, 1, 8);
    

    
    for (int i = 0; i < num_diagonals; i++) {
        float hue = map(i, 0, num_diagonals - 1, 255, 112);

        float y_axis = map(i, 0, num_diagonals, CenterY-50, CenterY+50);
        rotate(smoothrotation);

        stroke(hue, 100, 100);
        strokeWeight(4);
        noFill();
        line(0, y_axis, width, CenterY - y_axis);
    
       
    }
    stroke(122,100,100);
    noFill();
    rotate(smoothrotation);
    strokeWeight(4);
    ellipse(0,0,CenterX/2,amplitude);
    
    
    
             




}
               
        
            
    public static void main(String[] args) {
        PApplet.main("C22400796.JasonVisual");
    }
    
}
