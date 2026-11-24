package com.pluralsight.shapes;

import com.pluralsight.forms.Location;
import com.pluralsight.forms.Turtle;

public class Hexagon extends Shape {
    public Hexagon(Turtle turtle, Location location, String color, int boarder){
        this.turtle = turtle;
        this.location=location;
        this.color = color.toUpperCase();
        this.boarder=boarder;
    }
    public void paint(){
        turtle.goTo(location.getX(),location.getY());
        turtle.penDown();
        for (int i = 0; i <5 ; i++) {
            turtle.forward(boarder);
            turtle.turnRight(60);
        }
        turtle.forward(boarder);
        turtle.penUp();
    }

}
