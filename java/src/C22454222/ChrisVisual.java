package C22454222;
import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.Minim;
import processing.core.PApplet;
import ie.tudublin.*;

public class ChrisVisual extends Visual 
{
    MainVisual mv;
    Minim minim;
    AudioInput ai;
    AudioBuffer ab;

    float[] lerpedBuffer;
    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public ChrisVisual(MainVisual mv) 
    {
        this.mv = mv;
        ab = mv.getAudioBuffer();
        lerpedBuffer = new float[ab.size()]; 
    }

    public void setup() 
    {
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

        for(int i = 0 ; i < ab.size() ; i ++)
        {
            lerpedBuffer[i] = ab.get(i); // Initialize the array with the initial values from the buffer
        }
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

        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f); // Lerp the samples to each element in the buffer
        }
        average = sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);

        if (mv.beat.isKick())
        {
            kickCounter++;
        }

        mv.fill(currentColours[0],currentColours[1],currentColours[2], 200);
        mv.eRadius = 5*kickCounter;
        
        mv.stroke(map(mv.getAmplitude(), 0, 1, 0,255),255,255);   
        
        if (mv.chrisOption == 1)
        {
            mv.background(0, 0, 0);
            mv.textSize(20);
            mv.fill(255);
            mv.textAlign(CENTER,CENTER);
            mv.beat.detect(mv.as.mix);
            mv.beat.detectMode(0);
            //counting framerate
            mv.fCounter++;
            //translate so that the centre of the screen is (0, 0)
            mv.translate(mv.width/2, mv.height/2);
    
            
            mv.eRadius = 5*kickCounter;
            mv.triangle(0, -100, 60+(float)0.6*mv.eRadius, mv.eRadius, (-60-(float)0.6*mv.eRadius), mv.eRadius); 

            if (mv.eRadius > (float)mv.width / 2)
            {
                for (int i = 0; i< ab.size(); i++)
                {
                    previousColours[i] = currentColours[i];
                }
                replacingColours(currentColours);
                kickCounter = 0;
                mv.eRadius = 20;
            }
            
        }

        if (mv.chrisOption == 2)
        {
            background(0);
            for (int i = 0; i < ab.size(); i++) {
                float c3 = random(0, 255);
                float size = lerpedBuffer[i] * 200;
                float x = random(width);
                float y = random(height);
                float rotation = random(TWO_PI);
                pushMatrix();
                translate(x, y);
                rotate(rotation);
                fill(c3, 255, 255);
                rectMode(CENTER);
                rect(0, 0, size, size);
                popMatrix();
            }
        }
    }
}
