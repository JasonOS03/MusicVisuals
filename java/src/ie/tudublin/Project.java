package ie.tudublin;

import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.analysis.FFT;

public class Project extends PApplet {

    private Minim minim;
    private AudioPlayer ap;

    public void settings() {
        size(800, 800);
        background(0);
    }

    public void setup() {
        minim = new Minim(this);
        ap= minim.loadFile("C:\\Users\\Jason O'Sullivan\\OneDrive - Technological University Dublin\\Documents\\Music Project\\MusicVisuals\\java\\src\\ie\\OutKast - Hey Ya! (Lyrics).mp3");
                        
        ap.play();
    }

    public void draw() {
        background(0);

        // Check if audio player is playing
        if (ap.isPlaying()) {
            // Calculate FFT
            FFT fft = new FFT(ap.bufferSize(), ap.sampleRate());
            fft.forward(ap.mix);

            // Draw spectrum
            for (int i = 0; i < fft.specSize(); i++) {
                float colorrange = map(i, 0, fft.specSize() - 1, 0, 255);
                stroke(colorrange, 255, 255);
                line(i, height, i, height - fft.getBand(i) * 8);
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("ie.tudublin.Project");
    }
}
