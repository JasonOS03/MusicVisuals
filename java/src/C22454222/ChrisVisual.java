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

    public void settings()
    {
        mv.fullScreen();;
    }

    public void setup()
    {
        noCursor();
        smooth();
        mv.colorMode(HSB);
        frameRate(24);

        y = mv.height / 2;
        lerpedBuffer = new float[ab.size()][];
        
        for (int i = 0; i < ab.size(); i++)
        {
            lerpedBuffer[i] = new float[]{ab.get(i)};
        }
    }

    public void render()
    {
        float lerpedAmplitude = 0;
        lerpedAmplitude = lerp(lerpedAmplitude,smoothedAmplitude,0.1f);

        if (mv.chrisOption == 1)
        {   
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

            float scaledAmplitude = lerpedAmplitude * 10;

            mv.fill(lerpedAmplitude * 255, 255, 255, 90);
            mv.ellipse(x, y, scaledAmplitude, scaledAmplitude);

            mv.fill(lerpedAmplitude * 255, 255, 255, 60); 
            mv.ellipse(x3, y3, scaledAmplitude * 2, scaledAmplitude);

            mv.fill(lerpedAmplitude * 255, 255, 255, 90); 
            mv.ellipse(x, y, as.right.get(i) * 10, as.left.get(i) * 10);

            mv.fill(lerpedAmplitude * 255, 255, 255, 70); 
            mv.ellipse(x3, y3, as.right.get(i) * 10, as.right.get(i) * 20);

            }
            n4+=1;
            n6+=1;
        }
    

        if (mv.chrisOption == 2)
        {

        }
    }
}