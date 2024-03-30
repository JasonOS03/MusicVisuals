package C22454222;

import ie.tudublin.*;

public class MainVisual extends Visual{
    int visualSwap = 0;
    int playTune = 0;
    int stopPlay = 0;
    public float eRadius;

    // Initialize each visual object

    /* 

    AimeeVisual aimee;
    NeilVisual neil;
    JadeVisual jade;
    JasonVisual jason;
    
   
    

    */
    ChrisVisual chris;
    AudioBandsVisual example;

    public float fCounter = 0;
    public int branchCounter = 0;
    public int chrisOption = 1;
    public Object[] stars;

    public void settings()
    {
        size(1024, 500);

        // fullScreen();

        // fullScreen(P3D,SPAN);
    }

    public void setup()
    {
        startMinim();

        loadAudio("Project.wav");
         BeatDetect();
        ellipseMode(RADIUS);
        eRadius = width * 0.5f;
        colorMode(HSB);
        // Initialize each visual object

        /*

        aimee = new AimeeVisual(this);
        neil = new NeilVisual(this);
        jade = new JadeVisual(this);
        jason = new JasonVisual(this);
    
        */
        chris = new ChrisVisual(this);
        example = new AudioBandsVisual(this);
    }

    public void keyPressed()
    {
        if (key == ' ')
        {
            as.stop();
            as.trigger();
        }
    }

    public void draw()
    {
        if (playTune == 1)
        {
            as.stop();
            as.trigger();
            playTune = 0;
        }

        try
        {
            calculateFFT();

        }

        catch(VisualException e)
        {
            e.printStackTrace();
        }

        calculateFrequencyBands();
        
        calculateAverageAmplitude();    

        switch(visualSwap)
        {
            case 0:
                // aimee.render();
                break;
            case 1:
                // neil.render();
                break;
            case 2:
                // jade.render();
                break;
            case 3:
                // jason.render();
                break;
            case 4:
                chris.render();
                break;

            case 5:
                example.render();
                break;

            default:
                background(0);
                break;
        }
    }
}
