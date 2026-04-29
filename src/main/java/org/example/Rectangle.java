package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Rectangle {
    private double length;
    private double width;

    public Rectangle(double length, double width){
        this.length=length;
        this.width=width;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getArea(){
        return length*width;
    }
}
