package Decorator;

import Bridge.Shape;
import Decorator.ShapeDecorator;

public class BoldShapeDecorator extends ShapeDecorator {

    public BoldShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void applyColor() {
        shape.applyColor();
        System.out.println("Aaand it's bold!");
    }
}
