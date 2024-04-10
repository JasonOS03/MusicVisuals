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
    }

    public void draw()
    {

    }
    
}
