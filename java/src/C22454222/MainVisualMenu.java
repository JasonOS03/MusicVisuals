package C22454222;

import ie.tudublin.*;

public class MainVisualMenu extends Visual
{

    MainVisual visualMode;

public MainVisualMenu(MainVisual visualMode)
{
    this.visualMode = visualMode;
}

public int options = 5;
int boxHeight = 100;
int boxWidth = 200;

public void settings()
{
    size(400,450);
}

public void setup()
{
    colorMode(HSB);
}

public void keyPressed()
{
    if (key == ' ')
    {
        visualMode.visualSwap = (visualMode.visualSwap + 1) % options;
    }
  
}

public void draw()
{
    background(0);

    for(int i = 0; i < options + 1; i++)
    {
        if (i == 0) {
            fill(0, 100, 100); // Red
            stroke(110);
        } 
        else if (i == 1) {
            fill(30, 100, 100); // Orange
            stroke(110);
        } 
        else if (i == 2) {
            fill(210, 100, 100); // Blue
            stroke(110);
        } 
        else if (i == 3) {
            fill(60, 100, 100); // Yellow
            stroke(110);
        } 
        else if (i == 4) {
            fill(120, 100, 100); // Green
            stroke(110);
        } 
        else if (i == 5) {
            fill(270, 100, 100); // Purple
            stroke(110);
        }

        rect(0,i*boxHeight,boxWidth,boxHeight);
        
        if (mouseY >= i*boxHeight && mouseY <= (i+1)*boxHeight)
        {
            fill(255);
            rect(0,i*boxHeight,boxWidth,boxHeight);

            if (mousePressed)
            {
                if(i != 0)
                {
                    visualMode.visualSwap = i - 1;
                }

                else
                {
                    visualMode.playTune = 1;
                }
           
            }
        }
    }


    textSize(50);

    fill(0);

    textAlign(CENTER, CENTER);

    text("Play Tune", boxWidth / 2, boxHeight / 2);
    text("Aimee", boxWidth / 2, 1*boxHeight + boxHeight / 2);
    text("Neil", boxWidth / 2, 2*boxHeight + boxHeight / 2);
    text("Jade", boxWidth / 2, 3*boxHeight + boxHeight / 2);
    text("Jason", boxWidth / 2, 4*boxHeight + boxHeight / 2);
    text("Chris", boxWidth / 2, 5*boxHeight + boxHeight / 2);
}

}