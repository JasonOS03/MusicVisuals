package C22454222;

import ie.tudublin.*;
import processing.core.PApplet;

public class ChrisVisual extends Visual {

    MainVisual mainVisual;

    public ChrisVisual(MainVisual mainVisual) {
        this.mainVisual = mainVisual;
    }

    public void render() {
        float[] bands = mainVisual.getSmoothedBands();
        float volume = mainVisual.getAmplitude();

        float waveHeight = 100; // Height of the wave
        float waveSpacing = 20; // Spacing between waves
        float waveSpeed = 0.05f; // Speed of wave animation

        float startX = 100; // Starting x position of waves
        float startY = height / 2; // Y position of the waves

        for (int i = 0; i < bands.length; i++) {
            float x = startX + (i * waveSpacing);
            float y = startY + (waveHeight * bands[i] * 5 * volume) * sin(frameCount * waveSpeed);
            line(x, startY, x, y);
        }
    }
}
