package C22454222;

import ie.tudublin.*;

//this files main class
public class JadeVisual extends Visual {

   //MainVisual shortcut
   MainVisual mv;
    

   public JadeVisual(MainVisual mv) {
       this.mv = mv;
       //initialise the stars
       for (int i = 0; i < NUM_STARS; i++) {
        starX[i] = random(0, mv.width); //random x position within the width of the screen
        starY[i] = random(0, mv.height); //random y position within the height of the screen
    }
   }
   //number of stars
   final int NUM_STARS = 100;
   //arrays to store the x and y positions of the stars
   float[] starX = new float[NUM_STARS];
   float[] starY = new float[NUM_STARS];

   //the function where we render all of the goodness we want on the screen
   public void render() 
   {  
       //initialisation
        float[] sb = mv.getSmoothedBands();//a method that returns an array of smoothed audio frequency bands
        float createSpace = mv.getSmoothedAmplitude();//this method is expected to return a smoothed amplitude value
        float r = mv.getSmoothedAmplitude();//getting the amplitude
        float r2 = map(r, 0, 1 , 0, 40);
        float ba = map(sb[0], 0, 50, 0, 200);//bass frequencies
        float lm = map(sb[1], 0, 400, 0, 400 ); //low-mid frequencies
        float hh = sb[4]; //high high frequencies

       //calculations for the middle of the screen later used for the triangles
       int midX = mv.width/2;
       int midY = mv.height/2;

       //have a normal background when the mapped bass frequencies are below 300Hz
       if(ba < 300)
       {
           //pink background
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

       float gap = mv.width / (float) mv.getBands().length; //to get the gaps that are needed by equally dividing the number of bands (11 bands) by the width of the application
    
        // a loop that loops the amount of bands which is 11  
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
            
            // draw the triangles
            mv.triangle(x1, y1, x2, y2, x3, y3);
        }//end for loop

        //fill to make the bigger triangle transparent
        mv.fill(10, (float) 0.5);
        mv.triangle(0,0,0,0,0,0);//unsure why this line works but it was the only way i could make the middle triangles blue
        //without this line there is an extra floating triangle
            
        //this is to make sure the triangle does not get overly big, so the max radius is 400
        if(mainTri1 > 400)
        {
           mainTri1 = 400;
        }
        
        //this is triangle 1, which is slighly transparent
        mv.triangle(midX, midY - mainTri1, midX - mainTri1, midY + mainTri1, midX + mainTri1, midY + mainTri1);
           
        //this is to make sure the triangle does not get too big
        if(mainTri2 > 300)
        {
           mainTri2 = 300;
        }
        
        //this is triangle 2
        mv.triangle(midX, midY - mainTri2, midX - mainTri2, midY + mainTri2, midX + mainTri2, midY + mainTri2);
        mv.stroke(150, 200, 255); //set the stroke color to a light blue

        //for loop to draw the stars
        for (int i = 0; i < NUM_STARS; i++) {
            // Set the size of the stars based on music's amplitude
            float starSize = random(5, 20) * createSpace; // Increase the size range for bigger stars
            mv.fill(255); // Set star color to white
            mv.ellipse(starX[i], starY[i], starSize, starSize); // Draw the star
        }
    }//end render
}//end main
