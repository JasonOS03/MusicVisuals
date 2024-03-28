package C22454222;

import ie.tudublin.*;

public class MainVisual extends Visual{
    int visualSwap = 0;
    int playTune = 0;
    int stopPlay = 0;
    public float eRadius;

    // Initialize each visual object

    /* 

    AimeeVisual.java aimee;
    NeilVisual.java neil;
    JadeVisual.java jade;
    JasonVisual.java jason;
    ChrisVisual.java chris;
    AudioBandsVisual.java audioBandsVisual;

    */

    public float fCounter = 0;
    public int branchCounter = 0;

    public void settings()
    {
        size(1024, 500);
    }

    public void setup()
    {
        startMinim();
        loadAudio("Song.m4a");
        // BeatDetect();
        eRadius = width * 0.5f;
        colorMode(HSB);
        // Initialize each visual object

        /*

        aimee = new AimeeVisual(this);
        neil = new NeilVisual(this);
        jade = new JadeVisual(this);
        jason = new JasonVisual(this);
        chris = new ChrisVisual(this);
        audioBandsVisual = new AudioBandsVisual(this);

        */
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            as.stop();
            as.trigger();
        }

    }


    
}
