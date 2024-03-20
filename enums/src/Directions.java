public enum Directions {

    NORTH("észak"),
    SOUTH("dél"),
    EAST("kelet"),
    WEST("nyugat");

    private String name;
    Directions(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
