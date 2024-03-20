import Adapter.EnglishService;
import Adapter.GermanService;
import Adapter.GermanToEnglishAdapter;
import Bridge.*;
import Composite.Employee;
import Decorator.BoldShapeDecorator;
import Strategy.Player;
import Strategy.PunchStrategy;
import Strategy.ShootStrategy;

public class Main {
    //SZERKEZETI MINTÁK: ADAPTER, COMPOSITE, BRIDGE, DECORATOR
    //Adapter
    public static void performEnglishTask(EnglishService service){
        service.performTaskInEnglish("Hello");
    }
    //Adapter
    public static void main(String[] args) {
        System.out.println("****************ADAPTER*******************");
        GermanService gs = new GermanService();
        GermanToEnglishAdapter adapter = new GermanToEnglishAdapter(gs);
        performEnglishTask(adapter);
        System.out.println("****************COMPOSITE*******************");
        // Composite
        Employee boss = new Employee("Feri", "Boss", 100_000_000);
        Employee hr = new Employee("Géza", "HR", 10);
        Employee worker = new Employee("Jóska", "Worker", 2);
        Employee worker2 = new Employee("Nóra", "Worker", 1);

        boss.add(hr);
        hr.add(worker);
        hr.add(worker2);
        System.out.println(boss);

        //Bridge
        System.out.println("****************BRIDGE*******************");
        RedColor rc = new RedColor();
        BlueColor bc = new BlueColor();
        Triangle tl = new Triangle(rc);
        tl.applyColor();
        Square sq = new Square(bc);
        sq.applyColor();

        //Decorator
        System.out.println("****************DECORATOR*******************");
        BoldShapeDecorator bs = new BoldShapeDecorator(new Triangle(new RedColor()));
        bs.applyColor();

        //VISELKEDÉSI MINTÁK: OBSERVER, STRATEGY
        //Observer
        // BEFEJEZNI GIT-RŐL!!!!
//        System.out.println("****************OBSERVER*******************");


        //Strategy
        System.out.println("****************STRATEGY*******************");

        Player p = new Player();  // futásidőben módosíthatjuk a Player osztályunkat - változtathatjuk a stratégiát
        p.setAttackStrategy(new PunchStrategy());
        p.performAttack();
        p.setAttackStrategy(new ShootStrategy());
        p.performAttack();
    }
}