package C22454222;

import ie.tudublin.*;

public class AudioBandsVisual extends Visual{

    MainVisual mv;

    public AudioBandsVisual(MainVisual mv){
        this.mv = mv;
    }

    public void render()
    {
        mv.beat.detect(mv.as.mix);
        mv.beat.detectMode(0);
        mv.background(255);
        float a = map(mv.eRadius,20,80,60,255);
        mv.fill(60,255,0,a);
        if (mv.beat.isSnare())
        {
            mv.eRadius = 80;
        }
        mv.ellipse(width/2,height/2,mv.eRadius,mv.eRadius);
        mv.eRadius *= 0.95;

        if (mv.eRadius < 20)
        {
            mv.eRadius = 20;
        }
    }

}
