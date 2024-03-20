package Bridge;

public class Triangle extends Shape{

    public Triangle(Color c) {
        super(c);
    }

    @Override
   public void applyColor() {
        System.out.println("I'm a triangle with color: ");
        color.applyColor();
    }
}
