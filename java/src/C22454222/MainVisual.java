package C22454222; // Package declaration

import ie.tudublin.*; // Importing necessary classes from the ie.tudublin package
import ddf.minim.AudioPlayer;

// MainVisual class extending Visual class
public class MainVisual extends Visual 
{
    AudioPlayer ap; // Reference to AudioPlayer class
    int visualSwap = 0; // Variable to control visual swapping
    int playTune = 0; // Variable to control playing tune
    int stopPlay = 0; // Variable to control stopping playback
    
    NeilVisual neil;
    AimeeVisual aimee;
    JadeVisual jade;
    JasonVisual jason;
    ChrisVisual chris;

    public float fCounter = 0; // Variable to store a floating-point counter value
    public int branchCounter=0;
    public int smoothedAmplitude=1;

    // Method to set initial settings
    public void settings() 
    {
        // Setting window size
        fullScreen();
        // fullScreen(P3D,SPAN);
    }

    // Method to perform initial setup
    public void setup() 
    {
        startMinim(); // Starting Minim audio library
        loadAudio("Project.wav"); // Loading audio file
        BeatDetect(); // Initializing beat detection
        colorMode(HSB); // Setting color mode
        
        neil = new NeilVisual(this);
        aimee = new AimeeVisual(this);
        jade = new JadeVisual(this);
        jason = new JasonVisual(this);
        chris = new ChrisVisual(this);
    }

    // Method to draw visuals
    public void draw() 
    {
        if (playTune == 1) 
        { // If playTune flag is set
            as.stop(); // Stop audio playback
            as.trigger(); // Trigger audio playback
            playTune = 0; // Reset playTune flag
        }

        try 
        {
            calculateFFT(); // Calculate Fast Fourier Transform
        }

        catch (VisualException e) 
        { // Catch any VisualExceptions
            e.printStackTrace(); // Print stack trace of the exception
        }

        calculateFrequencyBands(); // Calculate frequency bands
        calculateAverageAmplitude(); // Calculate average amplitude

        // Switch statement to determine which visual to render
        switch (visualSwap) 
        {
            case 0:
                neil.render();
                break;
            case 1:
                aimee.render();
                break;
            case 2:
                jade.render();
                break;
            case 3:
                 jason.render(); 
                break;
            case 4:
                chris.render();
                break;
            default:
                background(0); // Set background color to black by default
                break;
        }
    }
}