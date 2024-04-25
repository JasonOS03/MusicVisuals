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
My code creates animations by generating branching structures. I used recursion and visualization principles to achieve the cool visual effects. 
At the core of the code are branches, which represent the basic building blocks of the branching structures. Each branch has properties like where it starts, how far it extends (amplitude), and its angle. It also has smaller branches growing from it, creating a tree-like effect.
My code uses a recursive approach to create these branches. The branch() method keeps generating smaller branches until it reaches a specified limit.
In the AimeeVisual Class  the color mode, stroke weight, and background color for the visual display is set up.
I created a loop to iterate through a range of values to create multiple instances of branching visuals.The orientation and movement of branches are influenced by variables like rotationSpeedFactor, clockwise, and audio input, which affect the rotation, translation, and amplitude of the branches.
When showing the viusal of the bracnches, my code utilizes methods like show() to draw them on the screen. It uses rotation to position the branches, drawing lines to represent each segment of the branch, and calling itself recursively to draw smaller branches.
Additionally, my code responds to audio input, i did this by adjusting the branches based on sound levels. This adds an extra layer of motion to the visuals, making them react to changes in sound.
Over the course of this project i made sure to commit every change I made to doccument my codes development and evolvement throughout the creating process.

## Neil
Constructor:
The NeilVisual class has a constructor that takes a MainVisual object mv as a parameter. This constructor initializes the mv field, which allows NeilVisual to interact with the main visual component of the system.
Fields:
The class has several fields to manage visual elements, such as the positions of stars (starX and starY arrays tnhat controls star location), colors (colourArray and prevColours arrays to control colour information), radius, and beat count to control shapes size and how they interact with the music. 
Render Method:
The render() method is responsible for drawing the visual elements on the screen.
It sets the background color to black and move the starting point to the middle of the canvas using background() and translate() functions.
The method then updates the beat count based on kick detection, adjusting the size of shapes accordingly. This allows the shaopes to move with the beat of the music.
Shapes are filled with a transparant color and drawn using ellipse() and rect() methods. These shapes include a circle, square and a spiral centerpiece. 
Stars are drawn on the canvas at random and are also affecnted by the music which is my personal favourite effect. 

## Jade
This code creates a visual display that moves to music. It creates a screen where shapes and colors change with the beat of a song.

The background colour changes depending on how loud the music is. Softer music will make the background pink, while louder music will make it darker. I used an if statement here so when the msuic is below 300Hz the screen is pink.

I created a visual along the bottom of the screen that is triangles moving up and down on the screen. Each triangle represents the bass or high notes. They get taller or shorter based on how loud each part of the music is. 

I also added stars which are located  by using the random function in java. They appear and disappear and their size changes with the musics volume. When the music is loud you'll see bigger stars. For this I had to intialise arrays and a for loop to find the position and then a for loop to draw the stars.

## Jason
My first role in this project was to set up the GitHub repository. I created the repository and then sent invitations to the rest of the group to join.I also had to make sure my visual worked in coordination with the other visuals. I created and worked on one visual which was constantly updated and committed.

The visual I created was what I would describe as a vortex. The first part of the visual I created was the the vortex itself , spanning around the sides of the screen. This vortex contains the colors from green all the way to red , and I did this using the map function.The vortex reacts to the audio by swirling around in a circular motion and pulsating. The vortex was created using lines, and these lines represent the gusts of wind.

The next part of the visual I created was the inner rings , which are a bright pink color. these circles rotates by the amplitude value in radians and also pulsate by the amplitude amount.The inner rings are supposed to represent the center of the vortex. The color also changes sporadically as the beat tempo / amplitude increases. The final part of the visual I created was a ring of circles rotating around the inner circle. These circles are also a bright pink color , and the colors also change at peak amplitude. This ring of circles is essentially pulled around the inside of the vortex.

## Chris
So I was in charge of designing the software first and foremost. I setup all the necessary main files and dictated how many branches we'd need. I also made the visual menu and was responsible for the UI and UX. I wanted to make the visuals interactive. I was also just a glorified project manager.

In my own visual ChrisVisual.java, I brainstormed many ideas such as an idea for a visual that resembled a black hole with atoms surrounding it. I implemented this and then decided to take my visual another direction.

The java class responds dynamically to audio input, implementing beat detection and manipulating shapes and colors based on amplitude and beat presence. Through the utilization of spiral patterns (using simple cos and sin Papplet functions) and various shapes like triangles and ellipses, the visualization generates captivating visual effects that synchronize seamlessly with the audio. The code emphasizes creativity, technical proficiency, and user experience, requiring a cohesive and well-structured implementation with a focus on responsiveness and aesthetic appeal.

The end result of my visual shows growing triangles facing each other and growing in a loop that resets once the triangles hit the border of the screen. I used mirrored triangles to form other shapes over time such as diamonds, prisms and abstract looking hour glasses. This same logic is used for a drawn circle in the centre of the screen. I also run for loops that create interesting sin and cos spirals that grow and shrink with the beat.

In terms of resources, I used Github Copilot for any minor syntax errors, formatting and some formal commenting on code. I initially used this video as inspiration for a start on my visual https://www.youtube.com/watch?v=283rmgvFDE0. Used processing for learning how to utilize cos and sin functions, growing shapes based on amplitude and beats and colour shifting based on time. https://processing.org/.

# Instructions

## Main Menu

Once you have ran the program, a separate menu window opens with the following options:
- Play Tune
- Neil
- Aimee
- Jade
- Jason
- Chris
- AudioBands

1. To start the visual, press the Play Tune button.
2. Neil's visual will start, synchronized with the song.
3. You can then click on other name's to see their visuals.
4. You can click back on previously seen visuals that are running in the background.
5. Click the play tune button again at any time. Don't worry, the visuals will all stay in sync.

# How it works

## Aimee

## Neil

## Jade
This creates the star effect
```Java
    for (int i = 0; i < NUM_STARS; i++) {
        starX[i] = random(0, mv.width); //random x position within the width of the screen
        starY[i] = random(0, mv.height); //random y position within the height of the screen
    }

    for (int i = 0; i < NUM_STARS; i++) {
        // Set the size of the stars based on music's amplitude
        float starSize = random(5, 20) * createSpace; // Increase the size range for bigger stars
        mv.fill(255); // Set star color to white
        mv.ellipse(starX[i], starY[i], starSize, starSize); // Draw the star
    }
```
Creating the stabbing chord affect
```Java
    for(int i = 0 ; i < (mv.getBands().length) ; i++)
    {   
        mv.fill(120, 20);
        float x1 = gap * i;
        float y1 = mv.height;
        float x2 = x1 + gap;
        float y2 = mv.height;
        float x3 = x1 + (gap / 2);
        float y3 = mv.height - mv.getSmoothedBands()[i] * 0.1f; // multiplied by a float of 0.1

        mv.triangle(x1, y1, x2, y2, x3, y3);
    }
```
drawing my triangles and setting a amx radius
```Java
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
```
This maps the range of colours to the amplitude of the music
```Java
mv.stroke(map(mv.getAmplitude(), 0, 1, 0, 255),255,255);
```
This is the logic for the stars
```Java
    //number of stars
    final int NUM_STARS = 100;
    //arrays to store the x and y positions of the stars
    float[] starX = new float[NUM_STARS];
    float[] starY = new float[NUM_STARS];

    for (int i = 0; i < NUM_STARS; i++) {
            starX[i] = random(0, mv.width); //random x position within the width of the screen
            starY[i] = random(0, mv.height); //random y position within the height of the screen
    } 
```
## Jason
This is the code for the initialisation of the relevant variables , for creating the circles , ensuring a smooth rotation etc
```Java
mv.background(0); // Black background

        float sum = 0;
        float smooth = getSmoothedAmplitude();// function to make the amplitude smoother

        // Iterate until the audio buffer size is reached
        for (int i = 0; i < ab.size(); i++) {
            sum += abs(ab.get(i)); // Get the values in the buffer and add the values to the sum
        }
        float average = sum / (float) ab.size(); // Calculate the average buffer value 
        float amplitude = average * 800; // Amplitude is average times a certain number, in this case it's 800   
        float smoothrotation = lerp(0, radians(amplitude), 0.05f); // Interpolate from 0 to the amplitude in radians at an amount of 0.05
        float circlerotation = lerp(0, radians(360), 0.05f); // Interpolates from 0 to 360 degrees in radians, allowing the circles to move around in a circle 
        float CenterY = mv.height / 2; // Center of screen Y value
        float CenterX = mv.width / 2; // Center of screen X value
        float CircleX = 200; // Circle x axis position
        float CircleY = 200;
         // Circle y axis position

        mv.translate(CenterX, CenterY); // Move (0,0) to the center

        int num_lines = (int) map(amplitude, 0, 1, 0, 4); // Ensures that if the amplitude is 1, there are 4 lines
        int num_circles = (int) map(amplitude, 0, 1, 0, 3); // If the amplitude is 1, there will be 3 circles



```
this is my code to create the lines rotating round the circles
```Java

for (int i = 0; i < num_lines; i++) {
            float hue = map(i, 0, num_lines - 1, 0, 255); // Map the lines to the color spectrum for the hue

            float y_axis = map(i, 0, num_lines, -CenterY/2, CenterY/2);// y_axis variable mapped from 0 to the number of lines to - height/4 to the height/4 
            mv.rotate(smooth + smoothrotation); // Rotate the lines 

            mv.stroke(hue, 100, 100); // Set the color of the stroke
            mv.strokeWeight(4); // Thickness of the lines
            mv.noFill();
            mv.line(-CenterX, y_axis, CenterX, -y_axis); // Create the lines starting from -CenterX on the X axis and the Y axis value, spanning to CenterX on the X axis and -y_axis on the y axis
        }


```
this is my code to create the rotating outer circles as well as the inner circles

``` Java

for (int i = 0; i < num_circles; i++) {
            float hue = map(i, 0, num_lines - 1, 150, 255); // map the circles to the color spectrum
            mv.stroke(hue, 255, 255);
            mv.noFill();
            mv.rotate(smooth + smoothrotation); // rotate the circles

            mv.strokeWeight(4);
            mv.ellipse(0, 0, CenterX/2, smooth + smoothrotation); // Create circles starting at the origin, with a diameter of CenterX and the height being the smoothedAmplitude + the lerp function to smoothen the visuals 

            mv.stroke(hue, 255, 255);
            mv.noFill();
            mv.rotate(smooth + circlerotation); // Rotate in a circular motion

            mv.strokeWeight(4);
            mv.ellipse(CircleX - CenterX/2, CircleY - CenterY/2, CenterX/2, CenterY/2); // create smaller  circles rotating around the center
        }

```





## Chris

This is the code for detecting beats
```Java

        if (mv.beat.isKick()) // Checking if there's a kick in the audio
        {
            kickCounter++; // Incrementing kick counter
        }
```
This is the code for the basic logic of changing shape colours.
```Java
    float[] currentColours = new float[]{random(0,255),random(0,255),random(0,255)}; // Array to store current colors
    float[] previousColours = new float[]{0,0,0}; // Array to store previous colors

    // Method to generate random colors and replace current colors
    public float[] replacingColours(float[] currentColours)
    {
        float[] colours = new float[]{random(0,255),random(0,255),random(0,255)}; // Generating random colors
        for(int i = 0; i < 3; i++) // Looping through color channels
        {
            currentColours[i] = colours[i]; // Replacing current colors with new random colors
        }
        return currentColours; // Returning the updated colors
    }
```
This is the code for the basic logic of resetting the size of the triangles and circle as well as changing colours.
```Java
        // Resetting values if radius exceeds half of the screen width
        if (radius > (float)mv.width / 2)
        {
            // Storing current colors as previous colors
            for (int i = 0; i < 3; i++)
            {
                previousColours[i] = currentColours[i];
            }
            // Generating and replacing new colors
            replacingColours(currentColours);
            kickCounter = 0; // Resetting kick counter
            radius = 20; // Resetting radius
        }
```
This is the code for drawing the centre circle and for increasing the size of it.
```Java
        radius = 40*kickCounter; // Adjusting radius based on kick counter
        mv.ellipse(0,0,radius,radius); // Drawing ellipse at the center
```

This is the code for drawing the sets of mirrored triangles and for increasing the size of them.
```Java
        radius = 15*kickCounter; // Adjusting radius based on kick counter
        // Drawing triangles
        radius = 15*kickCounter; // Adjusting radius based on kick counter
        mv.triangle(-200, -100, -140+(float)0.6*radius, radius, (-260-(float)0.6*radius), radius); 
        mv.triangle(200, -100, 260+(float)0.6*radius, radius, (140-(float)0.6*radius), radius);
        mv.triangle(-400, -100, -340+(float)0.6*radius, radius, (-460-(float)0.6*radius), radius); 
        mv.triangle(400, -100, 460+(float)0.6*radius, radius, (340-(float)0.6*radius), radius);
        mv.triangle(-600, -100, -540+(float)0.6*radius, radius, (-660-(float)0.6*radius), radius); 
        mv.triangle(600, -100, 660+(float)0.6*radius, radius, (540-(float)0.6*radius), radius);
        
        // Drawing mirrored triangles
        mv.triangle(-200, 100, -140+(float)0.6*radius, -radius, (-260-(float)0.6*radius), -radius); 
        mv.triangle(200, 100, 260+(float)0.6*radius, -radius, (140-(float)0.6*radius), -radius);
        mv.triangle(-400, 100, -340+(float)0.6*radius, -radius, (-460-(float)0.6*radius), -radius); 
        mv.triangle(400, 100, 460+(float)0.6*radius, -radius, (340-(float)0.6*radius), -radius);
        mv.triangle(-600, 100, -540+(float)0.6*radius, -radius, (-660-(float)0.6*radius), -radius); 
        mv.triangle(600, 100, 660+(float)0.6*radius, -radius, (540-(float)0.6*radius), -radius);
```

This is the code for drawing the spirals.
```Java
        // Drawing points in a spiral pattern
        for (float i = 0; i < mv.width; i += 0.3)
        {
            float x1 = (PApplet.cos(i) * smooth * i);
            float y1 = (PApplet.sin(i) * smooth * i);
            mv.point(x1, y1);
        }

        // Drawing points in a spiral pattern with center at (-400, 0)
        for (float i = 0; i < mv.width; i += 0.3)
        {
            float centerX2 = -400; 
            float centerY2 = 0; 
            float x2 = centerX2 + (PApplet.cos(i) * smooth * i);
            float y2 = centerY2 + (PApplet.sin(i) * smooth * i);
            mv.point(x2, y2);
        }

        // Drawing points in a spiral pattern with center at (400, 0)
        for (float i = 0; i < mv.width; i += 0.3)
        {
            float centerX3 = +400; 
            float centerY3 = 0; 
            float x3 = centerX3 + (PApplet.cos(i) * smooth * i);
            float y3 = centerY3 + (PApplet.sin(i) * smooth * i);
            mv.point(x3, y3);
        }
```

# What I am most proud of in the assignment

## Aimee
I'm proud to share my visual project, which makes cool animations. It creates colourful, tree-like shapes that grow and change over time. What's intersting about my code is that it reacts to sound, so when the music gets louder, the animations change too.
What makes me proud about my code  is that it's easy to understand. I made sure to keep the code simple and clear, so anyone can see how it works. It's not just about the visuals; it's also about making coding understandable and accessible to everyone.
I am happy about how my viusal turned out,As my code produces visually appealing animations with vibrant colors and smooth movements. The rendering of branching structures adds an artistic touch to the visual display, making it visually captivating and aesthetically pleasing.
For this project to gain ideas I used online resources such as youtube to gain ideas for my code. here is a youtbe video i used to get ideas off https://youtu.be/l7PetueD1_c?si=fWYtMLATU_C666GU. I am proud how i was able to take ideas from online sources but implement my own creative version.
Overall, I'm really proud of what I've created. It's a blend of art and technology, showing how coding can be both creative and interesting to implement.

## Neil
Personally my favourite thing i made was the stars as i love space and i think it fits the theme very well as well as adding some layers to the visual while being relativly simple to implement. The spiral however is what i am most proud of as it was hard to figure out. It was hard in general to come up with what to put in the center but after messing about and using AI for ideas it created a center line that rotated around like a radar. I then messed around with the code and while in class sin and cos was mentioned and so i got an idea to create a visual with that. This was challanging to get working but eventually i figured it out after messing around with the code. The maths aspect was definatly the hardest aspect getting the rotating working. I used some tutorials online (https://www.youtube.com/watch?v=OqQE3Z87uuU) and searched some websites (such as https://stackoverflow.com/questions/17596003/something-like-collections-rotate-for-map) to try learn the bascis on how to rotate. While I didnt completly copy their code i did use github copilot which was recomended in class to help assist on this which i found very useful. For the circle and square I got the idea from the labs as we had used these functions before. Another suprisingly hard part was starting the code as I had to spend a bit of time looking over the main visual and the funciton to understand them. However once i had momemtum I found myself enjoying the project alot and being proud of the visual i made as it may not be the most flashy or impressive but i personally think it turned out very well.

## Jade
I was most proud of how far I had came from the beginning of the project. I found this a big challenge and im very happy with the end result. The hardest challenge I overcame was the stabbing effect at the bottom of the screen, it was very difficult to figure out the variables and the positioning of this. I was very happy with the outcome of this section of the visual because I thought this idea would be out of my depths but I achieved it with research and time. The next thing im most proud of is the stars, this was a joint effort between me and another member of the team, neil, the reason we curated this aspect of the visual was to create a sense of unity between our visuals, and in the end i was very impressed with the outcome. I took inspiration from a youtube video 'https://youtu.be/nj5XM3YQusE?si=rKFYjB1bG7ySZXfZ', I got my idea for the pulsing triangles in the centre and the idea of stars from this video. From this video I gained inspirtaion to make an almost night sky looking visual. From this experience Ive learned a lot about java as a whole throughout this project, structuring code, intialising variables and creating shapes. I gained a lot of knowledge from this video on youtube which details shapes and loops also it covers the basics again which was a huge help as i found I started to overcomplicate the code 'https://youtu.be/SQBrJEalWYo?si=ONtS0Gvw4yFxxl_w'. Overall it was a great learning experience and im happy with the outcome of the assignment, although stressful it tought me a lot. Another source i used was github co pilot to help with syntax errors, formatting and any logical errors i ran into.

## Jason
In this assignment I am most proud of my creative thinking to come up with an interesting visual. This creative thinking continued throughout the whole project , leading to the visual constantly evolving and changing over time. I was able to constantly think of new ideas which I am very proud of. 

I really felt that I learned a lot during the creation of this visual. One thing I really got a good understanding of is how to make the objects rotate and respond well to the audio buffer. I gained a better understanding of how the parameters and coordinates work in the PApplet functions , such as the circle and the rotate function. This project really helped to enhance my skills in using PApplet and also further improved my Java coding skills and my understanding of the Java language

This project also helped to enhance my group working skills and communication as we had to spend a lot of time co-ordinating our visuals and grouping them together. This co-ordination required constant communication the full way through the project. I also learned the importance of working bit by bit instead of trying to tackle the entire project in a very short amount of time.

The part of the assignment I found the most challenging was trying to coordinate each part of the visual to not interfere with each other and trying to get the visuals to move around and pulsate smoothly. Trying to ensure that the visuals were not jumpy proved to be quite challenging, and unfortunately the jumpiness of the inner circles could not be fully fixed. 

## Chris
I'm most proud of a lot of things. I took the initiative with this project and designed and implemented a lot of fundamental elements of the software such as the menu, main file structures, branches and was in charge of solving merge conflicts and fixing any common bugs amongst other members of the team. I also ensured all members of the group made contributions, tracking them by looking at commits.

I wouldn't call myself a creative person but I enjoyed making my simple visual. I enjoyed managing a team more and maintaining good code standards, structure and organising meet ups with my group. Working with a team gave me great experience as well as collaborating on an industry used platform (Github). I'm proud that everything fell into place because of good organisation and teamwork. 

I'm proud of the menu structure, creating interactivity with the user. I think that makes this project stand out a bit because most projects probably ran through all the visuals with no menu. Our menu structure creates interesting opportunities for unpredictability since users can swap between visuals at any time during the song.

For my visual, I wanted to make something that would grow and make new shapes and I thought interlocking triangles would do that beautifully to the beat of a techno song. The triangles form other incredible shapes. Every visual in the project follows that techno theme we were going for.

I'm also proud of how familiar I became with git. Helped others in the group with any queries or issues with using git, especiallg during the merging process when we all merged the individual developer branches. 

# Youtube video

![YouTube]

