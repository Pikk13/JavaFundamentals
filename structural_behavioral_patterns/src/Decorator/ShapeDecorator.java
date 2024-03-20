package Decorator;


import Bridge.Shape;

public class ShapeDecorator extends Shape {

    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
     public void applyColor() {
      shape.applyColor();
    }
}
