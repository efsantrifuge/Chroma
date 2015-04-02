*Documentation is work in progress.*

![Chroma](http://i.imgur.com/KqxeSEC.png)

# Chroma
Chroma is color conversion library that implements perceptually linear color spaces such as CIELab &amp; CIE-LCH. This library borrows CIE conversions from the very popular Chroma.js JavaScript color conversion library - [Github Link](https://github.com/gka/chroma.js "Github Link")

Download it here: [Chroma](http://neil.engineer/index.php?/pages/chroma/ "Chroma")

## Motivation

Artists & designers benefit tremendously from being able to control luminosity in a linear color space. In order to conceive visual distraction, emphasis, phase, depth, importance, or an abstract artistic visual hierarchy; the ability to control luminisity is indispensible.

The human vision has evolved to prioritize luminosity information during the object recognition process. Color spaces such as **HSL**, **HSV/HSB** and **RGB** are optimized for digital displays and lack luminosity control. For example, varying Hue while keeping Saturation and Lightness constant in HSL colorspace produces perceptually non-uniform colors. Moreover, Lightness is a non-linear function of both - Saturation and Hue. This severely limits the ability to predict the apparent and perceptual luminosity.

Chroma library allows for color production in **CIE-Lab** and **CIE-LCH** (cyclindrical transfomration of CIE-Lab) which are better suited for human vision and perceptual predictibility. Chroma objects can be instantiated with CIE color parameters, but represented and drawn in RGB color space.

![alt tag](http://i.imgur.com/MnwRKHA.png)

As a demonstration, the swatches shown above exemplify the drawbacks of HSL colorspace. The top row of swatches are generated by changing the Hue `[H = {0, 72, 144, 216, 288}]` while keeping Saturation `[S = 50]` and Lightness `[L = 50]` constant. The bottom row is generated in CIE-LCH color space by setting Luminosity `[L = 80]` and Chroma `[C = 50]` while changing the Hue `[H = {0, 72, 144, 216, 288}]`. The result is a perceptually uniform palette and as a consequence, it is visually pleasant.

## Code Sample

```processing

import com.chroma.*; // Import Chroma library

int l = 50; // Luminosity, Range: 0-100
int c = 50; // Chroma, Range: 0-128
int h = 200; // Hue, Range: 0-360


Chroma testColor; // Declare a chroma object

void setup() {

    size(1280, 720);
    rectMode(CENTER);
    noStroke();

    testColor = new Chroma(l,c,h,ColorSpace.LCH); // Create a chroma object
}

void draw() {

    background(255);


    fill(testColor.getRGB()); // To fetch RGB color, use the getRGB method.
    rect(width/2, height/2, 100, 100); // Draw a cyan square
}
```

## API Reference

*Work in progress*

```processing
Chroma(50,50,200,ColorSpace.LCH);		// LCH Color space
```

## Tests

Chroma includes several tests & examples and they are can be loaded within the Processing IDE by clicking: `File > Examples > Library Examples > Chroma`.

Alternatively, you can find the example source code under `Processing/libraries/Chroma/examples`.

## Installation

###### How to install library Chroma


Install with the "Add Library..." tool

New for Processing 2.0: Add contributed libraries by selecting "Add Library..."
from the "Import Library..." submenu within the Sketch menu. Not all available
libraries have been converted to show up in this menu. If a library isn't there,
it will need to be installed manually by following the instructions below.


###### Manual Install

Contributed libraries may be downloaded separately and manually placed within
the "libraries" folder of your Processing sketchbook. To find (and change) the
Processing sketchbook location on your computer, open the Preferences window
from the Processing application (PDE) and look for the "Sketchbook location"
item at the top.

Copy the contributed library's folder into the "libraries" folder at this
location. You will need to create the "libraries" folder if this is your first
contributed library.

By default the following locations are used for your sketchbook folder:
For Mac users, the sketchbook folder is located inside `~/Documents/Processing`.
For Windows users, the sketchbook folder is located inside
`My Documents/Processing`.

The folder structure for library Chroma should be as follows:

```
Processing
	libraries
		Chroma
			  examples
			  library
				    Chroma.jar
			  reference
			  src
```

Some folders like "examples" or "src" might be missing. After library
Chroma has been successfully installed, restart the Processing
application.


If you're having trouble, have a look at the Processing Wiki for more
information: http://wiki.processing.org/w/How_to_Install_a_Contributed_Library

## License

The MIT License (MIT)

Copyright (c) 2015 Neil Panchal, http://neil.engineer

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

