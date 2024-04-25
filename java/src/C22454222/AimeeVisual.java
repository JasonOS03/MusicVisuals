package C22454222;
import ie.tudublin.*;
//define branch class 
class Branch{
    MainVisual mainVisual;
    float start;
    float amplitude =0;
    float angle=0;
    Branch[] branches;//branch array 

    Branch (MainVisual mainVisual,float start, float amplitude,float angle ,int branches  ){
        //constructor for branch class 
        this.mainVisual=mainVisual;
        this.start = start;
        this.amplitude=amplitude;
        this.angle=angle;

        branch(branches);
    }
   void show() {
    // Displays the branch 
    mainVisual.rotate(this.angle);
    mainVisual.line(0, 0, 0, amplitude); // Draws a line from current position (0, 0) to (0, amplitude)
    if (branches != null) { // Checks if the current branch has any sub-branches
        mainVisual.translate(0, amplitude); // Moves the origin of the coordinate system to the end of the current branch.
        mainVisual.pushMatrix();
        branches[0].show();
        mainVisual.popMatrix();
        branches[1].show(); // Display the second branch
    }
}


    // Create branch method to populate branches array
    void branch (int branchAmt){//takes an int which represents thr number of subbranches to be created 

        if (branchAmt > 0 ){
            branches = new Branch[2];
        
            float angle = MainVisual.map(mainVisual.smoothedAmplitude,0,1,3.14f/10f,3.14f/2f);//Calculates the angle for the sub-branches 
            //creates sub branch
            branches[0]= new Branch(mainVisual,start-amplitude,amplitude/1.5f,angle,branchAmt-2 );
            branches[1]= new Branch(mainVisual,start-amplitude,amplitude/1.5f,-angle,branchAmt-2 );
        
        }
    }
}

public class AimeeVisual extends Visual {
    MainVisual mainVisual;
    boolean clockwise = true;
    float rotationSpeedFactor = 4;

    Branch branch1;
    Branch branch2;

    public AimeeVisual(MainVisual mainVisual){
        this.mainVisual = mainVisual;
    }

    public void render(){
        // Method to render the visual 
        
        mainVisual.strokeWeight(2);
        mainVisual.fill(0, 40); // Sets background
        // Creates the border
        mainVisual.rect(-2, -5, mainVisual.width + 5, mainVisual.height + 2);

        mainVisual.fill(255); // Set fill color to white 
        mainVisual.stroke(255); // Set stroke color to white 

        // Increment frame counter
        mainVisual.fCounter++;  // Move this line here to prevent automatic incrementation
        
        for (int i = 0; i < 6; i++) {

            // Replace current matrix with identity matrix
            mainVisual.resetMatrix();

            // Set the visual display window size, centers the visual
            mainVisual.translate(mainVisual.width / 2, mainVisual.height / 2);

            // Set branch counter to 0
            mainVisual.branchCounter = 0;

            // Set rotation direction
            float rotationDirection = clockwise ? 1 : -1;

            // Set rotation speed of entire visual
            float rotationSpeed = rotationDirection * rotationSpeedFactor * MainVisual.map(mainVisual.fCounter % 360, 0, 360, 0, MainVisual.PI * 2);

            mainVisual.rotate(rotationSpeed);
            // Maps the current iteration index i to a rotation angle and rotates the visual accordingly.
            mainVisual.rotate(MainVisual.map((float) i, 0f, 6f, 0f, MainVisual.PI * 2));

            // Calculates the amplitude of the branches based on the audio input
            float amplitude = mainVisual.getSmoothedAmplitude();
            branch1 = new Branch(mainVisual, 0f, MainVisual.map(amplitude, 0, .4f, -mainVisual.height / 10f, -mainVisual.height / 4f), 0, 6);
            branch2 = new Branch(mainVisual, 0f, MainVisual.map(amplitude, 0, .4f, -mainVisual.height / 50f, -mainVisual.height / 4f), 0, 5);

            // Makes the branches different colors
            float hue1 = (mainVisual.fCounter / 10) % 255;
            float hue2 = (mainVisual.fCounter / 2) % 255;

            mainVisual.fill(hue1, 255, 255); // Calculating hue for branch 1
            mainVisual.stroke(hue1, 255, 255);
            branch1.show(); // Displays branch 1

            mainVisual.fill(hue2, 255, 255);
            mainVisual.stroke(hue2, 255, 255); // Sets stroke color for branch 2
            branch2.show(); // Displays branch 2
        }
    }
}
