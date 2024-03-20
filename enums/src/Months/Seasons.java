package Months;

public enum Seasons {

    SPRING("tavasz"), SUMMER("nyár"), AUTUMN("ősz"), WINTER("tél");

    private String name;

    Seasons(String name) {
        this.name = name;

    }



    public String getName(){
        return this.name;
    }

}
