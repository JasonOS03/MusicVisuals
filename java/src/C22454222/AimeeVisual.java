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

    // Create branch method to populate branches array
    void branch (int branchAmt){

        if (branchAmt > 0 ){
            branches = new Branch[2];
        
            float angle = MainVisual.map(mainVisual.smoothedAmplitude,0,1,3.14f/10f,3.14f/2f);

            branches[0]= new Branch(mainVisual,start-amplitude,amplitude/1.5f,angle,branchAmt-2 );
            branches[1]= new Branch(mainVisual,start-amplitude,amplitude/1.5f,-angle,branchAmt-2 );
        
        }

    }

}


public class AimeeVisual extends Visual{
    MainVisual mainVisual;
    boolean clockwise =true;
    float rotationSpeedFactor=4;

    Branch branch1;
    Branch branch2;

    public AimeeVisual(MainVisual mainVisual){
        this.mainVisual=mainVisual;
    }

    public void render(){
        mainVisual.colorMode(MainVisual.HSB);//setting colour mode
        mainVisual.strokeWeight(2);
        mainVisual.fill(0,40);
        //creates the border
        mainVisual.rect(-2, -5, mainVisual.width + 5, mainVisual.height + 2);

        mainVisual.fill(255);
        mainVisual.stroke(255);

        mainVisual.fCounter++;


        for (int i = 0; i < 6; i++) {

            // Replace current matrix with identity matrix
            mainVisual.resetMatrix();

            // Set the visual display window size. centers the visual
            mainVisual.translate(mainVisual.width / 2, mainVisual.height / 2);

            // Set branch counter to 0
            mainVisual.branchCounter = 0;

            //set rotation direction
            float rotationDirection = clockwise ? 1:-1;

            //set rotation speed of entire visual
            float rotationSpeed=rotationDirection * rotationSpeedFactor * MainVisual.map(mainVisual.fCounter % 360,0,360,0, MainVisual.PI * 2);


            mainVisual.rotate(rotationSpeed);
            mainVisual.rotate(MainVisual.map((float) i, 0f, 6f, 0f, MainVisual.PI * 2));

            
        
            float amplitude = mainVisual.getSmoothedAmplitude();
            branch1= new Branch (mainVisual,0f,MainVisual.map(amplitude,0,.4f,-mainVisual.height/10f,-mainVisual.height/4f),0,6);
            branch2= new Branch (mainVisual,0f,MainVisual.map(amplitude,0,.4f,-mainVisual.height/50f,-mainVisual.height/4f),0,5);
            

            float hue1 = (mainVisual.fCounter / 10) % 255;
            float hue2 = (mainVisual.fCounter / 2) % 255;

            mainVisual.fill(hue1, 255, 255);
            mainVisual.stroke(hue1, 255, 255);
            branch1.show();

            mainVisual.fill(hue2, 255, 255);
            mainVisual.stroke(hue2, 255, 255);
            branch2.show();

        }
    }
}
