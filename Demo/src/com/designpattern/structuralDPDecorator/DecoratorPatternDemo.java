package com.designpattern.structuralDPDecorator;

public class DecoratorPatternDemo {
    // Main driver method
    public static void main(String[] args)
    {
        Shape circle = new Circle();
        Shape redCircle
                = new RedShapeDecorator(new Circle());
        Shape redRectangle
                = new RedShapeDecorator(new Rectangle());
        // Display message
        System.out.println("Circle with normal border");
        circle.draw();
        // Display message
        System.out.println("\nCircle of red border");
        // Call 2
        redCircle.draw();
        // Display message
        System.out.println("\nRectangle of red border");
        // Call 3
        redRectangle.draw();
    }
}

