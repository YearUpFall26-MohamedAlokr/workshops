package com.pluralsight.shapes;

import com.pluralsight.forms.Location;
import com.pluralsight.forms.Turtle;


public class Square extends Shape {
    public Square(Turtle turtle, Location location, String color, int boarder){
        this.turtle = turtle;
        this.location=location;
        this.color = color.toUpperCase();
        this.boarder=boarder;
    }
    public void paint(){
        turtle.goTo(location.getX(),location.getY());
        turtle.penDown();
        for (int i = 0; i <3 ; i++) {
            turtle.forward(boarder);
            turtle.turnRight(90);
        }
        turtle.forward(boarder);
        turtle.penUp();
    }

}
