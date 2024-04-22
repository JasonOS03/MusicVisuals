package C22454222;
import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.PApplet;
import ie.tudublin.*;

public class ChrisVisual extends Visual 
{
    MainVisual mv;
    Minim minim;
    AudioInput ai;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public ChrisVisual(MainVisual mv) 
    {
        this.mv = mv;
    }

    float[] currentColours = new float[]{random(0,255),random(0,255),random(0,255)};
    float[] previousColours = new float[]{0,0,0};
    int kickCounter = 0;
 
    public float[] replacingColours(float[] currentColours)
    {
        float[] colours = new float[]{random(0,255),random(0,255),random(0,255)};
        for(int i = 0; i < 3; i++)
        {
            currentColours[i] = colours[i];
        }
        return currentColours;
    }

    public void render()
    {
        float radius = 20;
        mv.background(0,0,0);
        mv.beat.detect(mv.as.mix);
        mv.beat.detectMode(0);
        mv.fCounter++;
        mv.translate(mv.width/2, mv.height/2);

        float smooth = mv.getSmoothedAmplitude();

        if (mv.beat.isKick())
        {
            kickCounter++;
        }

        mv.fill(currentColours[0],currentColours[1],currentColours[2], 50);

        radius = 5*kickCounter;
        mv.ellipse(0,0,radius,radius);

        mv.fill(previousColours[0],previousColours[1],previousColours[2], 25);
        
        mv.stroke(map(mv.getAmplitude(), 0, 1, 0,255),255,255);   
        
            mv.eRadius = 5*kickCounter;
            mv.triangle(0, -100, 60+(float)0.6*radius,radius, (-60-(float)0.6*radius), radius); 

            if (radius > (float)mv.width / 2)
            {
                for (int i = 0; i < 3; i++)
                {
                    previousColours[i] = currentColours[i];
                }
                replacingColours(currentColours);
                kickCounter = 0;
                mv.eRadius = 20;
            }
    }
}
