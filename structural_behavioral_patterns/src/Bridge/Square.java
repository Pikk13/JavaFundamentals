package Bridge;

public class Square extends Shape{
    public Square(Color c) {
        super(c);
    }

    @Override
   public void applyColor() {
        System.out.println("I'm a square with color: ");
        color.applyColor();
    }
}
