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

## Jason

## Chris

# Instructions

## Main Menu

Once you have ran the program, a separate menu window opens with the following options:
- Play Tune
- Neil
- Aimee
- Jade
- Jason
- Chris

## Chris's Visual Option
Chris's visual has further visual change options based on keypress.
Press a corresponding number on your keyboard to change the visual.

| Keycode | Visual |
|---------|-----------|
| '1' | |
| '2' | |
| '3' | |

# How it works

# What I am most proud of in the assignment

## Aimee

## Neil
Personally my favourite thing i made was the stars as i love space and i think it fits the theme very well as well as adding some layers to the visual while being relativly simple to implement. The spiral however is what i am most proud of as it was hard to figure out. It was hard in general to come up with what to put in the center but after messing about and using AI for ideas it created a center line that rotated around like a radar. I then messed around with the code and while in class sin and cos was mentioned and so i got an idea to create a visual with that. This was challanging to get working but eventually i figured it out after messing around with the code. The maths aspect was definatly the hardest aspect getting the rotating working. I used some tutorials online (https://www.youtube.com/watch?v=OqQE3Z87uuU) and searched some websites (such as https://stackoverflow.com/questions/17596003/something-like-collections-rotate-for-map) to try learn the bascis on how to rotate. While I didnt completly copy their code i did use github copilot which was recomended in class to help assist on this which i found very useful. For the circle and square I got the idea from the labs as we had used these functions before. Another suprisingly hard part was starting the code as I had to spend a bit of time looking over the main visual and the funciton to understand them. However once i had momemtum I found myself enjoying the project alot and being proud of the visual i made as it may not be the most flashy or impressive but i personally think it turned out very well.
## Jade

## Jason

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

