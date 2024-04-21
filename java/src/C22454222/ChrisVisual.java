package C22454222;

import ie.tudublin.*;
import ddf.minim.*;
import ddf.minim.AudioBuffer; 
import ddf.minim.AudioSample; 

public class ChrisVisual extends Visual 
{
    MainVisual mv;
    Minim minim;
    AudioBuffer ab;
    AudioSample as;

    float[] lerpedBuffer[];
    float y = 0;
    float smoothedAmplitude = 0;

    public ChrisVisual(MainVisual mv) 
    {
        this.mv = mv;
        ab = mv.getAudioBuffer();
        as = mv.getAudioSample();
    }

    public void setup()
    {
        noCursor();
        smooth();
        colorMode(HSB);

        y = height / 2;
        lerpedBuffer = new float[ab.size()][];
        
        for (int i = 0; i < ab.size(); i++)
        {
            lerpedBuffer[i] = new float[]{ab.get(i)};
        }
    }

    public void render()
    {
        float lerpedAmplitude = 0;
        lerpedAmplitude = lerp(lerpedAmplitude, smoothedAmplitude,0.1f);

        if (mv.chrisOption == 1)
        {
            mv.fill(0,50);  
            mv.noStroke();
            
            mv.background(0);
            mv.beat.detect(mv.as.mix);
            mv.beat.detectMode(0);
            mv.fCounter++;
            mv.translate(mv.width/2, mv.height/2);

            float n4 = 0;
            float n6 = 0;

            for (int i = 0; i < ab.size() - 1; i++) 
            {

            float angle = sin(i+n4)* 10; 
            float angle2 = sin(i+n6)* 300; 

            float x = sin(radians(i))*(angle2+30); 
            float y = cos(radians(i))*(angle2+30);
            float x3 = sin(radians(i))*(500/angle); 
            float y3 = cos(radians(i))*(500/angle);

            mv.fill(255, 255, 0, 90); // Yellow
            mv.ellipse(x, y, lerpedAmplitude * 10, lerpedAmplitude * 10);

            mv.fill(255, 255, 255, 60); // White
            mv.rect(x3, y3, lerpedAmplitude * 20, lerpedAmplitude * 10);

            mv.fill(255, 152, 0, 90); // Orange
            mv.rect(x, y, as.right.get(i) * 10, as.left.get(i) * 10);

            mv.fill(255, 255, 255, 70); // White
            mv.rect(x3, y3, as.right.get(i) * 10, as.right.get(i) * 20);

            }
            n4+=0.008;
            n6+=0.04;
        }
    

        if (mv.chrisOption == 2)
        {

        }
    }
}