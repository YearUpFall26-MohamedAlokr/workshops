package com.pluralsight.shapes;

import com.pluralsight.forms.Location;
import com.pluralsight.forms.Turtle;

import java.awt.*;

public abstract class Shape {
    Turtle turtle;
    Location location;
    Color color;
    int boarder;


    public abstract void paint();


}
