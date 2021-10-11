# Depth of Field Calculator
Calculate the camera len's depth of field with this text UI calculator.
Choose lens and enter valid aperture and distance to subject to start the calculator.
It will output the focus distance range, depth of field distance, and hyperfocal point.

## Installation
1. Download, install and run [IntellJ Community Edition](https://www.jetbrains.com/idea/download/)
2. Click "Get from VCS" or File->New->Project From Version Control
3. Insert the following URL:
```
https://github.com/Tooo/Depth-of-Field-Calculator.git
```
4. Run Main

## Calculator
The Depth of Field Calculator will calculate these following things:
- Focal Distance Range
- Depth of Field Distance
- Hyperfocal Point

### Testing
JUnit testing is used for this calculator.
Each calculator function is tested to ensure that the four function results the correct values.
The unit tests are in [DOFCalculatorTest.java](/src/test/java/test/DOFCalculatorTest.java).

## Lens
These are sample lens for the calculator
- Canon 50m F1.8
- Tamron 90m F2.8
- Sigma 200m F2.8
- Nikon 200m F4.0

### Custom Lens
To add additional lens, you must modify a java file.
In [CameraTextUI](/src/main/java/camera/ui/CameraTextUI.java) insert the following code after line 29.
```java
manager.add(new Lens("Canon", 1.8, 50));
```
Modify the three arguments of the lens:
1. Make (Canon)
2. Max Aperture (1.8)
3. Focal length in mm (50)

## Android App
An Android app version is also avaliable [here](https://github.com/Toooo123/Depth-of-Field-Calculator-Android) 

## Sample Run
With this run, the Canon lens is choosen with aperture of 1.8 and distance of 1.1.
```
Lenses to pick from:
  0. Canon 50mm F1.8
  1. Tamron 90mm F2.8
  2. Sigma 200mm F2.8
  3. Nikon 200mm F4.0
  (-1 to exit)
```
Input: ```0```
```
Aperture [the F number]:
```
Input: ```1.8```
```
Distance to subject [m]:
```
Input: ```1.1```
```
  In focus: 1.08m to 1.12m [DoF = 0.05m]
  Hyperfocal point: 47.89m
  
  Lenses to pick from:
  0. Canon 50mm F1.8
  1. Tamron 90mm F2.8
  2. Sigma 200mm F2.8
  3. Nikon 200mm F4.0
  (-1 to exit)
```
Input: ```-1```
