package C22454222;

import ie.tudublin.*;

public class JadeVisual {

    MainVisual mv;
    public JadeVisual(MainVisual mv) 
    {
        this.mv = mv;
    }


    void render(){
        //initialisation
        float[] sb = mv.getSmoothedBands();
        float r = mv.getSmoothedAmplitude();//getting the amplitude
        float r2 = map(r, 0, 1 , 0, 40);
        float ba = map(sb[0], 0, 50, 0, 200);//bass frequencies
        float lm = map(sb[1], 0, 400, 0, 400 ); //low-mid frequencies
        float hh = sb[4]; //high high frequencies
    }
    
}
