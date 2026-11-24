package com.pluralsight.shapes;

import com.pluralsight.forms.Location;
import com.pluralsight.forms.Turtle;

public class Circle extends Shape {
    private int radius;
    public Circle(Turtle turtle, Location location, String color, int boarder, int radius) {
        this.turtle = turtle;
        this.location = location;
        this.color=color.toUpperCase();
        this.boarder=boarder;
        this.radius=radius;
    }
    public void paint() {
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
