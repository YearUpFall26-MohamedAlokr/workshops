package com.pluralsight.shapes;

import com.pluralsight.forms.Location;
import com.pluralsight.forms.Turtle;

public abstract class Shape {
    Turtle turtle;
    Location location;
    String color;
    int boarder;


    public abstract void paint();


}
