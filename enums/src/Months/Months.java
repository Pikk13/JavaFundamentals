package Months;

public enum Months {
    JANUARY("január", 1, 31, false, Seasons.WINTER),
    FEBRUARY("február", 2, 28, false, Seasons.WINTER),
    MART("március", 3, 31, false, Seasons.SPRING),
    APRIL("április", 4, 30, true, Seasons.SPRING),
    MAY("május", 5, 31, false, Seasons.SPRING),
    JUNE("június", 6, 30, false, Seasons.SUMMER),
    JULY("július", 7, 31, false, Seasons.SUMMER),
    AUGUST("augusztus", 8, 31, false, Seasons.SUMMER),
    SEPTEMBER("szeptember", 9, 30, false, Seasons.AUTUMN),
    OKTOBER("október", 10, 31, false, Seasons.AUTUMN),
    NOVEMBER("november", 11, 30, false, Seasons.AUTUMN),
    DECEMBER("december", 12, 31, true, Seasons.WINTER);


    private String name;
    private int whichMonthOfTheYear;
    private int numberOfDays;
    private boolean hasHolidays;
    Seasons season;


    Months(String name, int whichMonthOfTheYear,
           int numberOfDays, boolean hasHolidays, Seasons season) {

        this.name = name;
        this.whichMonthOfTheYear = whichMonthOfTheYear;
        this.numberOfDays = numberOfDays;
        this.hasHolidays = hasHolidays;
        this.season = season;
    }



    public Months getMonthByNumber(int whichMonth) {
        switch (whichMonth) {
            case 1:
                System.out.println(JANUARY);
                return JANUARY;
            case 2:
                System.out.println(FEBRUARY);
                return FEBRUARY;
            case 3:
                System.out.println(MART);
                return MART;
            case 4:
                System.out.println(APRIL);
                return APRIL;
            case 5:
                System.out.println(MAY);
                return MAY;
            case 6:
                System.out.println(JUNE);
                return JUNE;
            case 7:
                System.out.println(JULY);
                return JULY;
            case 8:
                System.out.println(AUGUST);
                return AUGUST;
            case 9:
                System.out.println(SEPTEMBER);
                return SEPTEMBER;
            case 10:
                System.out.println(OKTOBER);
                return OKTOBER;
            case 11:
                System.out.println(NOVEMBER);
                return NOVEMBER;
            case 12:
                System.out.println(DECEMBER);
                return DECEMBER;
            default:
                throw new IllegalArgumentException("Nincs ilyen sorszámú hónap");
        }
    }

//    public String getName() {
//        return name;
//    }

    public int getWhichMonthOfTheYear() {
        return whichMonthOfTheYear;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public boolean isHasHolidays() {
        return hasHolidays;
    }

//    public Seasons getSeason() {
//        return season;
//    }



    @Override
    public String toString() {
        return "A választott hónap neve: " + name +
                ", Hanyadik hónapról van szó az évben? " + whichMonthOfTheYear +
                ", napjainak száma: " + numberOfDays + " Van-e nagy ünnepe? " +
                (hasHolidays ? "Van ünnepe. " : "Nincs karácsony, se húsvét. ") +
                 season.getName() + " évszak van ebben a hónapban.";

    }
}
