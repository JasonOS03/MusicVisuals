// This file contains the Main class which serves as the entry point for the application

package ie.tudublin;

import C22400796.JasonVisual;
import C22454222.*;

import processing.core.PApplet;

public class Main {

    // The startUI method initializes the visualizer and runs the sketches
    public void startUI() 
    {
        MainVisual visualizer = new MainVisual();
        String[] a = { "MAIN" };
        processing.core.PApplet.runSketch(a, new JasonVisual());
    }

    // The main method creates an instance of the Main class and calls the startUI method
    public static void main(String[] args) 
    {
        Main main = new Main();
        main.startUI();
    }
}