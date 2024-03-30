package C22454222;

import ie.tudublin.*;

public class MainVisualMenu extends Visual{

    MainVisual visualMode;

public MainVisualMenu(MainVisual visualMode){
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
    visualMode.visualSwap = (visualMode.visualSwap + 1) % options;
}











}