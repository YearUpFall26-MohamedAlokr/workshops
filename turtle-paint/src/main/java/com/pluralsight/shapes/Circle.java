package com.pluralsight.shapes;

import com.pluralsight.forms.Location;
import com.pluralsight.forms.Turtle;

import java.awt.*;

public class Circle extends Shape {
    private double radius;
    public Circle(Turtle turtle, Location location, Color color, int boarder, double radius) {
        this.turtle = turtle;
        this.location = location;
        this.color=color;
        this.boarder=boarder;
        this.radius=radius;
    }
    public void paint() {
        turtle.setColor(color);
        turtle.setDelay(0);
        turtle.goTo(location.getX(), location.getY());
        turtle.penDown();
        turtle.turnRight(90);

        //draw  circle loop
        for (int i = 0; i < 360; i++) {
            turtle.forward(2);
            turtle.turnRight(1);
        }
        turtle.penUp();
    }
}
