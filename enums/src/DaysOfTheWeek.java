public enum DaysOfTheWeek {

    MONDAY("hétfő", 1),
    TUESDAY("kedd", 2),
    WEDNESDAY("szerda", 3),
    THURSDAY("csütörtök", 4),
    FRIDAY("péntek", 5),
    SATURDAY("szombat", 6),
    SUNDAY("vasárnap", 7);

    private String name;
    private int whichDay;

    DaysOfTheWeek(String name, int whichDay) {
        this.name = name;
        this.whichDay = whichDay;
    }

    public String getName() {
        return name;
    }

    public int getWhichDay() {
        return whichDay;
    }
}
