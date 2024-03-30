package C22454222;

import ie.tudublin.*;

import ddf.minim.AudioBuffer;

// This is an example of a visual that uses the audio bands
public class AudioBandsVisual extends Visual
{
    MainVisual mv;
    AudioBuffer ab;
    float[] lerpedBuffer;
    float smoothedAmplitude = 0;
    

    public AudioBandsVisual(MainVisual mv)
    {
        this.mv = mv;
        ab = mv.getAudioBuffer(); 
        lerpedBuffer = new float[ab.size()]; 
    }

    public void render()
    {
        mv.beat.detect(mv.as.mix);
        mv.beat.detectMode(0);
        mv.background(0);
        

        float average = 0;
        float sum = 0;

        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
            lerpedBuffer[i] = lerp(lerpedBuffer[i], ab.get(i), 0.1f); 
        }
        average = sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        
        // Draw the visual using lerpedBuffer
        for(int i = 0; i < ab.size(); i ++)
        {
            float c = map(i, 0, ab.size(), 0, 255);
            mv.stroke(c, 255, 255);
            float f = lerpedBuffer[i] * mv.height / 2 * 4.0f;
            mv.line(i, mv.height / 2 + f, i, mv.height / 2 - f);
        }
    }
}
