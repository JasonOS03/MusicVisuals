package C22454222;

import ie.tudublin.*;
import processing.core.PApplet;
import ddf.minim.*;
import ddf.minim.AudioBuffer; 
import ddf.minim.AudioSample; 

public class ChrisVisual extends Visual 
{
    MainVisual mv;
    Minim minim;
    AudioBuffer ab;
    AudioSample as;

    public ChrisVisual(MainVisual mv) 
    {
        this.mv = mv;
        ab = mv.getAudioBuffer();
        as = mv.getAudioSample();
    }

    int beatCount = 0;

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
            mv.fill(0,50);  
            mv.noStroke();
            mv.rect(0, 0, width, height);
            mv.translate(width/2, height/2);

            float n4 = 0;
            float n6 = 0;

            for (int i = 0; i < ab.size() - 1; i++) 
            {

            float angle = sin(i+n4)* 10; 
            float angle2 = sin(i+n6)* 300; 

            float x = sin(radians(i))*(angle2+30); 
            float y = cos(radians(i))*(angle2+30);

            float x3 = sin(radians(i))*(500/angle); 
            float y3 = cos(radians(i))*(500/angle);

            mv.fill(255, 255, 0, 90); // Yellow
            mv.ellipse(x, y, as.left.get(i) * 10, as.left.get(i) * 10);

            mv.fill(255, 255, 255, 60); // White
            mv.rect(x3, y3, as.left.get(i) * 20, as.left.get(i) * 10);

            mv.fill(255, 152, 0, 90); // Orange
            mv.rect(x, y, as.right.get(i) * 10, as.left.get(i) * 10);

            mv.fill(255, 255, 255, 70); // White
            mv.rect(x3, y3, as.right.get(i) * 10, as.right.get(i) * 20);

            }
            n4+=0.008;
            n6+=0.04;
        }
    

        if (mv.chrisOption == 2)
        {
            class Circle 
            {
                float x, y;
                float radius;

                Circle(float x, float y, float radius) 
                {
                    this.x = x;
                    this.y = y;
                    this.radius = radius;
                }

                void display() 
                {
                    mv.noFill();
                    mv.stroke(255);
                    mv.ellipseMode(RADIUS);
                    mv.ellipse(x, y, radius, radius);
                }
            }
            
            Circle[] circles;
            int numCircles = 3;
            float minRadius = 50;
            float maxRadius = 200;

            circles = new Circle[numCircles];
            for (int i = 0; i < numCircles; i++) 
            {
                float radius = mv.random(minRadius, maxRadius);
                float x = mv.random(radius, mv.width - radius);
                float y = mv.random(radius, mv.height - radius);
                circles[i] = new Circle(x, y, radius);
            }

            // Draw circles
            for (int i = 0; i < numCircles; i++) 
            {
                circles[i].display();
            }

            // Draw Venn diagram

                mv.noFill();
                mv.stroke(255);
                float overlap = circles[0].radius + circles[1].radius;
                mv.ellipseMode(RADIUS);

                // Circle 1
                mv.ellipse(circles[0].x, circles[0].y, circles[0].radius, circles[0].radius);

                // Circle 2
                mv.ellipse(circles[1].x - overlap / 2, circles[1].y, circles[1].radius, circles[1].radius);

                // Intersection
                float intersectRadius = PApplet.sqrt(PApplet.sq(circles[0].radius) + PApplet.sq(circles[1].radius));
                mv.ellipse(circles[0].x - overlap / 4, circles[0].y, intersectRadius, intersectRadius);
        }

        if (mv.chrisOption == 3)
        {
            
        }

    }
}