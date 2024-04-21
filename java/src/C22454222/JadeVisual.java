package C22454222;

import ie.tudublin.*;

public class JadeVisual {

    MainVisual mv;
    public JadeVisual(MainVisual mv) 
    {
        this.mv = mv;
        for (int i = 0; i < NUM_STARS; i++) {
            starX[i] = random(0, mv.width); // Random x position within the width of the screen
            starY[i] = random(0, mv.height); // Random y position within the height of the screen
        }
    }
    
    final int NUM_STARS = 100;
    
    float[] starX = new float[NUM_STARS];
    float[] starY = new float[NUM_STARS];
    


    void render(){
        //initialisation
        float[] sb = mv.getSmoothedBands();
        float r = mv.getSmoothedAmplitude();//getting the amplitude
        float r2 = map(r, 0, 1 , 0, 40);
        float ba = map(sb[0], 0, 50, 0, 200);//bass frequencies
        float lm = map(sb[1], 0, 400, 0, 400 ); //low-mid frequencies
        float hh = sb[4]; //high high frequencies
        //basics
       int midX = mv.width/2; 
       int midY = mv.height/2;
       //have a normal background when the mapped bass frequencies are below 300Hz
       if(ba < 300)
       {
           //dark grey background
           mv.background(255,92,205); 
       }

       else
       {   
           //this makes the background turn into different dark colours based on the low-mids, bass, and high highs of the music
           mv.background(map(lm, 0, 2500, 0, 255), map(ba, 0, 200, 0, 50), map(hh, 0, 2500, 0, 50));
       }

       //the radius of the main triangles
       float mainTri1 = lerp(map(ba, 0, 300, 0, 300), 100, (float) 0.5); //triangle 1 - the bigger triangle
       float mainTri2 = r2 * 6; //triangle 2 - the smaller triangle

       float gap = mv.width / (float) mv.getBands().length; //to get he gaps that are needed by equally dividing the number of bands (11 bands) by the width of the application
       //mv.noStroke();
       
        // a loop that loops all the way to the length of the amount of bands which is 11  
        for(int i = 0 ; i < (mv.getBands().length) ; i++)
        {   
            mv.fill(120, 20);//fill the triangles with white and a bit of transparency
            // each triangle represents a band, where the x-coordinate is calculated based on the gap, 
            // the y-coordinate uses the full height of the application,
            // and the height of the triangle is based on the smoothed bands
            float x1 = gap * i;
            float y1 = mv.height;
            float x2 = x1 + gap;
            float y2 = mv.height;
            float x3 = x1 + (gap / 2);
            float y3 = mv.height - mv.getSmoothedBands()[i] * 0.1f; // multiplied by a float of 0.1
            
            // calculate the new y-coordinate for the second triangle
            y3 = mv.height - mv.getSmoothedBands()[i] * 0.2f; // multiplied by a float of 0.2
            
            // draw the second triangle
            mv.triangle(x1, y1, x2, y2, x3, y3);
        }//end for loop
    }
    
}
