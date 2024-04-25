# Music Visualiser Project

Names: Aimee Mcgrane, Neil Fitzgerald, Jade Thornton, Jason O Sullivan, Chris Noblett 

Student Numbers: C22393606, C22405604, C22394466, C22400796, C22454222

## Instructions
- Fork this repository and use it a starter project for your assignment
- Create a new package named your student number and put all your code in this package.
- You should start by creating a subclass of ie.tudublin.Visual
- There is an example visualiser called MyVisual in the example package
- Check out the WaveForm and AudioBandsVisual for examples of how to call the Processing functions from other classes that are not subclasses of PApplet

# Description of the assignment

## Aimee
my code creates animations by generating branching structures. I used recursion and visualization principles to achieve the cool visual effects. 
At the core of the code are branches, which represent the basic building blocks of the branching structures. Each branch has properties like where it starts, how far it extends (amplitude), and its angle. It also has smaller branches growing from it, creating a tree-like effect.
My code uses a recursive approach to create these branches. The branch() method keeps generating smaller branches until it reaches a specified limit.
In the AimeeVisual Class  the color mode, stroke weight, and background color for the visual display is set up.
I created a loop to iterate through a range of values to create multiple instances of branching visuals.The orientation and movement of branches are influenced by variables like rotationSpeedFactor, clockwise, and audio input, which affect the rotation, translation, and amplitude of the branches.
When showing the viusal of the bracnches, my code utilizes methods like show() to draw them on the screen. It uses rotation to position the branches, drawing lines to represent each segment of the branch, and calling itself recursively to draw smaller branches.
Additionally, my code responds to audio input, i did this by adjusting the branches based on sound levels. This adds an extra layer of motion to the visuals, making them react to changes in sound.
Over the course of this project i made sure to commit every change I made to doccument my codes development and evolvement throughout the creating process.


## Neil

## Jade
This code creates a visual display that moves to music. It creates a screen where shapes and colors change with the beat of a song.

The background colour changes depending on how loud the music is. Softer music will make the background pink, while louder music will make it darker. I used an if statement here so when the msuic is below 300Hz the screen is pink.

I created a visual along the bottom of the screen that is triangles moving up and down on the screen. Each triangle represents the bass or high notes. They get taller or shorter based on how loud each part of the music is. 

I also added stars which are located  by using the random function in java. They appear and disappear and their size changes with the musics volume. When the music is loud you'll see bigger stars. For this I had to intialise arrays and a for loop to find the position and then a for loop to draw the stars.

## Jason
My first role in this project was to set up the GitHub repository. I created the repository and then sent invitations to the rest of the group to join. It was my job to ensure that the repository was secure and maintainable. My next role was the creation of my visual. This visual has been coordinated to work with the visuals created by the others.While creating this visual , I made sure to make constant commits to show my work.The visual went through many changes over time, and eventually led to the final version. This final version is what I would describe as a vortex. The visual includes rotating lines which create the vortex shape , rotating circles around the center and circles in the center.
## Chris

# Instructions

## Main Menu

Once you have ran the program, a separate menu window opens with the following options:
- Play Tune
- Aimee
- Neil
- Jade
- Jason
- Chris

# How it works
## Aimee 
```Java
class Branch{
    MainVisual mainVisual;
    float start;
    float amplitude =0;
    float angle=0;
    Branch[] branches;
```
this is me creating a branch class and initialising variables that will be used throughout the code 

```Java
void show() {
    // Displays the branch 
    mainVisual.rotate(this.angle);
    mainVisual.line(0, 0, 0, amplitude); 
 ```

This part of the code rotates the visual context  by a certain angle (this.angle) and then draws a line from the current position (0, 0) to (0, amplitude) in the rotated context. This line represents the branch of the tree.

```Java
branches[0].show();
branches[1].show();
```

displays the branches.
this is in the show() function.

```Java
void branch (int branchAmt){//takes an int which represents thr number of subbranches to be created 

if (branchAmt > 0 ){
    branches = new Branch[2];

    float angle = MainVisual.map(mainVisual.smoothedAmplitude,0,1,3.14f/10f,3.14f/2f);//Calculates the angle for the sub-branches 
    //creates sub branch
    branches[0]= new Branch(mainVisual,start-amplitude,amplitude/1.5f,angle,branchAmt-2 );
    branches[1]= new Branch(mainVisual,start-amplitude,amplitude/1.5f,-angle,branchAmt-2 );

}
```

The branch() function generates sub-branches for a given branch based on the provided branchAmt parameter, representing the number of sub-branches to create. If branchAmt is greater than 0, it initializes an array to store the sub-branches, calculates their angles dynamically based on audio, and creates two sub-branches with positive and negative angles. These sub-branches are instantiated with parameters including visual context, starting position, branch length, angle, and a decremented branchAmt. This process continues recursively, reducing the number of sub-branches with each call until branchAmt reaches 0 or less, controlling the depth and complexity of the branching structure.

```Java
 mainVisual.fCounter++;   used to count the number of frames being rendered in the visual
```
```Java
float rotationSpeed = rotationDirection * rotationSpeedFactor * MainVisual.map(mainVisual.fCounter % 360, 0, 360, 0, MainVisual.PI * 2);

mainVisual.rotate(rotationSpeed);

mainVisual.rotate(MainVisual.map((float) i, 0f, 6f, 0f, MainVisual.PI * 2));
```

This code segment calculates and applies rotation to a visual element based on a combination of factors. First, it computes the rotationSpeed by multiplying rotationDirection, rotationSpeedFactor, and a mapped value representing the current iteration (mainVisual.fCounter % 360). This mapped value ensures smooth rotation over time. Then, it rotates the visual element by the calculated rotationSpeed. 

```Java
branch1 = new Branch(mainVisual, 0f, MainVisual.map(amplitude, 0, .4f, -mainVisual.height / 10f, -mainVisual.height / 4f), 0, 6);
branch2 = new Branch(mainVisual, 0f, MainVisual.map(amplitude, 0, .4f, -mainVisual.height / 50f, -mainVisual.height / 4f), 0, 5);
```

These lines of code initiate two branches. The Branch constructor takes several parameters: the visual context , the starting position (0f for both branches, indicating they originate from the same point), the length of the branch, the angle of the branch , and a parameter that may control the number of sub-branches (set to 6 for branch1 and 5 for branch2). The length of each branch is dynamically mapped based on the amplitude variable. The mapped values shows that branch1 is longer and covers a wider range of the visual space compared to branch2, which creates a hierarchical structure. 

```Java
float hue1 = (mainVisual.fCounter / 10) % 255;
float hue2 = (mainVisual.fCounter / 2) % 255;

mainVisual.fill(hue1, 255, 255); // Calculating hue for branch 1
mainVisual.stroke(hue1, 255, 255);
branch1.show(); // Displays branch 1

mainVisual.fill(hue2, 255, 255);
mainVisual.stroke(hue2, 255, 255); 
branch2.show(); // Displays branch 2
```

This code segment aims to add visual variety by assigning different colors to the branches. It achieves this by dynamically calculating hues based on the mainVisual.fCounter variable.







# What I am most proud of in the assignment

## Aimee
I'm proud to share my visual project, which makes cool animations. It creates colourful, tree-like shapes that grow and change over time. What's intersting about my code is that it reacts to sound, so when the music gets louder, the animations change too.
What makes me proud about my code  is that it's easy to understand. I made sure to keep the code simple and clear, so anyone can see how it works. It's not just about the visuals; it's also about making coding understandable and accessible to everyone.
I am happy about how my viusal turned out,As my code produces visually appealing animations with vibrant colors and smooth movements. The rendering of branching structures adds an artistic touch to the visual display, making it visually captivating and aesthetically pleasing.
For this project to gain ideas I used online resources such as youtube to gain ideas for my code. here is a youtbe video i used to get ideas off https://youtu.be/l7PetueD1_c?si=fWYtMLATU_C666GU. I am proud how i was able to take ideas from online sources but implement my own creative version.
Overall, I'm really proud of what I've created. It's a blend of art and technology, showing how coding can be both creative and interesting to implement.



## Neil

## Jade
I was most proud of how far I had came from the beginning of the project. I found this a big challenge and im very happy with the end result. The hardest challenge I overcame was the stabbing effect at the bottom of the screen, it was very difficult to figure out the variables and the positioning of this. I was very happy with the outcome of this section of the visual because I thought this idea would be out of my depths but I achieved it with research and time. The next thing im most proud of is the stars, this was a joint effort between me and another member of the team, neil, the reason we curated this aspect of the visual was to create a sense of unity between our visuals, and in the end i was very impressed with the outcome. 
(sources, what u learened tutorials yt web , )
## Jason
In this assignment I am most proud of my creative thinking to come up with an interesting visual. This creative thinking continued throughout the whole project , leading to the visual constantly evolving and changing over time. I was able to constantly think of new ideas which I am very proud of.

## Chris

# Markdown Tutorial

This is *emphasis*

This is a bulleted list

- Item
- Item

This is a numbered list

1. Item
1. Item

This is a [hyperlink]

# Headings
## Headings
#### Headings
##### Headings

This is code:

```Java
```

This is an image using a relative URL:

![An image]

This is an image using an absolute URL:

![A different image]

This is a youtube video:

![YouTube]
This is a table:

| Heading 1 | Heading 2 |
|-----------|-----------|
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |
|Some stuff | Some more stuff in this column |

