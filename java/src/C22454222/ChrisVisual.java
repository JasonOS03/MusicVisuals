package C22454222;

import ie.tudublin.*;
// import processing.core.PApplet;

public class ChrisVisual extends Visual 
{
    MainVisual mv;

    public ChrisVisual(MainVisual mv) 
    {
        this.mv = mv;
    }

    public void render()
    {
        mv.beat.detect(mv.as.mix);
        mv.beat.detectMode(0);
        mv.background(0);
        mv.textSize(25);
        mv.fill(255);
        mv.textAlign(CENTER,CENTER);

        mv.fCounter++;

        mv.translate(mv.width/2, mv.height/2);

        if (mv.chrisOption == 1)
        {

        }

        if (mv.chrisOption == 2)
        {
            
        }
        
        if (mv.chrisOption == 3)
        {
            
        }

    }
}