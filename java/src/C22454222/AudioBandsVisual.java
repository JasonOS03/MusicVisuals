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
        

    }

}
