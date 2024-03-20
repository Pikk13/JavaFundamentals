package Bridge;

public abstract class Shape {
    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }
    public Shape(){

    }
    public abstract void applyColor();

}
