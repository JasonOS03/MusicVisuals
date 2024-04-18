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
    void show(){
        mainVisual.rotate(this.angle);
        mainVisual.line(0,0,0,amplitude);
        if(branches != null){
            mainVisual.translate(0, amplitude);
            mainVisual.pushMatrix();
            branches[0].show();
            mainVisual.popMatrix();
            branches[1].show();

        }
    }
    void branch (int branchAmt){

    }

}


public class AimeeVisual extends Visual{
    MainVisual mainVisual;
    boolean clockwise =true;

    Branch branch1;
    Branch branch2;
    Branch branch3;


    public AimeeVisual(MainVisual mainVisual){
        this.mainVisual=mainVisual;
    }



    public void render(){
        mainVisual.colorMode(MainVisual.HSB);//setting colour mode
        mainVisual.strokeWeight(1);
        mainVisual.fill(0,40);

        mainVisual.rect(-1, -1, mainVisual.width + 1, mainVisual.height + 1);

        mainVisual.fill(255);
        mainVisual.stroke(255);





        float amplitude= mainVisual.getSmoothedAmplitude();
        branch1= new Branch (mainVisual,0f,MainVisual.map(amplitude,0,.4f,-mainVisual.height/10f,-mainVisual.height/4f),0,14);
        branch2= new Branch (mainVisual,0f,MainVisual.map(amplitude,0,.4f,-mainVisual.height/30f,-mainVisual.height/4f),0,18);
        branch3= new Branch (mainVisual,0f,MainVisual.map(amplitude,0,.4f,-mainVisual.height/15f,-mainVisual.height/4f),0,5);


    }
}
