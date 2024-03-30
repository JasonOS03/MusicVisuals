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
    size(200,600);
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
    background(0); // Set background to black

    for(int i = 0; i < options + 1; i++)
    {
        if (i == 0) {
            fill(25, 255, 255); // Red
            stroke(110);
        } 
        else if (i == 1) {
            fill(180, 255, 255); // Green
            stroke(110);
        } 
        else if (i == 2) {
            fill(0, 255, 255); // Blue
            stroke(110);
        } 
        else if (i == 3) {
            fill(90, 255, 255); // Yellow
            stroke(110);
        } 
        else if (i == 4) {
            fill(60, 255, 255); // Orange
            stroke(110);
        } 
        else if (i == 5) {
            fill(180, 255, 255); // Purple (adjust hue to fit within spectrum)
            stroke(110);
        }

        rect(0, i * boxHeight, boxWidth, boxHeight);
        
        if (mouseY >= i * boxHeight && mouseY <= (i + 1) * boxHeight)
        {
            fill(255); // Set text color to white
            rect(0, i * boxHeight, boxWidth, boxHeight);

            if (mousePressed)
            {
                if (i != 0)
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
    fill(255); // Set text color to white
    textAlign(CENTER, CENTER);

    text("Play Tune", boxWidth / 2, boxHeight / 2);
    text("Aimee", boxWidth / 2, 1 * boxHeight + boxHeight / 2);
    text("Neil", boxWidth / 2, 2 * boxHeight + boxHeight / 2);
    text("Jade", boxWidth / 2, 3 * boxHeight + boxHeight / 2);
    text("Jason", boxWidth / 2, 4 * boxHeight + boxHeight / 2);
    text("Chris", boxWidth / 2, 5 * boxHeight + boxHeight / 2);
}



}