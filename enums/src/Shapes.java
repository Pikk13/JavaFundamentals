public enum Shapes {
    CIRCLE("kör", 0),
    TRIANGLE("háromszög", 3),
    RECTANGLE("négyszög", 4),
    HEXAGON("hatszög", 6);

    private String name;
    private int sides;

    Shapes(String name, int sides) {
        this.name = name;
        this.sides = sides;
    }
}
