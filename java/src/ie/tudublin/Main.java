package ie.tudublin;

import C22454222.*;

public class Main {

    public void startUI() 
    {
        MainVisual visualizer = new MainVisual();
        String[] a = { "MAIN" };
        processing.core.PApplet.runSketch(a, visualizer);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startUI();
    }
}