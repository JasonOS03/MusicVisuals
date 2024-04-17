package C22454222;
import ie.tudublin.*;

class Branch{
    MainVisual mainVisual;
    float start;
    float amplitude =0;
    float angle=0;


    Branch[] branches;//branch array 

    Branch (MainVisual mainVisual,float start, float amplitude,float angle ,int branches  ){
        this.mainVisual=mainVisual;
        this.start = start;
        this.amplitude=amplitude;
        this.angle=angle;

        branch(branches);
    }

}


public class AimeeVisual extends Visual{
    MainVisual mainVisual;

    public AimeeVisual(MainVisual mainVisual){
        this.mainVisual=mainVisual;
    }



    public void render(){

    }
}
