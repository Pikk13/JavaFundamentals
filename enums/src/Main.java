import Months.Months;
import Working.Manager;
import Working.Tools;
import Working.Worker;
import Working.WorkingArea;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;


public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager();

        manager.useTools(Tools.PAPER);
        manager.workingArea(WorkingArea.IRODA);

        Worker worker = new Worker();

        worker.useTools(Tools.HAMMER);
        worker.workingArea(WorkingArea.ELSO_EMELET);

        System.out.println();
        System.out.println("SEASONS");
        System.out.println();
//******************************************************************SEASONS
        Scanner scanner = new Scanner(System.in);

        System.out.println("Az év hanyadik hónapjának adatait szeretnéd látni?");
        int whichMonth = scanner.nextInt();


        Months month = Months.JANUARY;



        month.getMonthByNumber(whichMonth);


        System.out.println();
        System.out.println("DIRECTIONS");
        System.out.println();

        System.out.println(Directions.WEST);
        System.out.println(Directions.NORTH.getName());
        System.out.println();

        System.out.println("Órai gyakorlás **********************");
        System.out.println();

        System.out.println("A nap magyar neve: " + DaysOfTheWeek.FRIDAY.getName() + ", az adott nap hanyadik a héten? " + DaysOfTheWeek.FRIDAY.getWhichDay() + "-ik.");
        System.out.println();

       DaysOfTheWeek[] days = DaysOfTheWeek.values();
        List<DaysOfTheWeek> daysList = new ArrayList<>(List.of(days));
        for (DaysOfTheWeek day: days) {
            System.out.println(day.getWhichDay() + ". " + day.getName());
        }


    }
}