import java.time.Clock;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {


        MySingleton ms = MySingleton.getInstance();
        System.out.println(ms);
        System.out.println(MySingleton.getInstance());
        System.out.println(MySingleton.getInstance());
        MySingleton.getInstance().setMyRandomNumber(20);
        System.out.println(MySingleton.getInstance());
        System.out.println(MySingleton.getInstance());

        BankAccount ba = new BankAccount.BankAccountBuilder("Vili", "1234")
                .withEmail("valami@gmail.com")
                .wantNewsLetter(false)
                .build();

        System.out.println(ba);


        Polygon myPoly = new SmallPolygonFactory().getPolygon(5);
        myPoly.draw();
        var pentagon = myPoly instanceof Pentagon ? ((Pentagon) myPoly) : null;
        pentagon.draw();

        AbstractPolygonFactory fact = FactoryProducer.getFactory(false);
        fact.getPolygon(3).draw();


//    FELADATOK

//1. Készíts egy TimeSingleton osztályt, amely tartalmazzon egy String-et timeNow néven.
//
//2. Az osztály legyen singleton.
//
//            3. Létrehozásakor tárolja el a jelenlegi dátumot és időt a timeNow változóba.
//
//4. Készíts getter-t a timeNow-hoz.
//
//5. Main függvényben írasd ki a getter függvénnyel a tárolt értéket konzolra. Ha jól dolgoztál, mindig ugyanazt az időt kapod.


        TimeSingleton ts = TimeSingleton.getInstance();
        System.out.println(ts);


        Pizza pi = new Pizza.PizzaBuilder("Vékony")
                .withSauce("ketchup")
                .build();
        System.out.println(pi);

//        1. Készítsünk egy Dogstats interface-t, amely tartalmaz egy height és egy name függvényt.

//2. Hozzunk létre egy Dog absztarakt osztályt (implementálja a Dogstats-ot).

//3. Hozzuk létre a következő osztályokat (zárójelben a magasságuk):
// Akita(70)
//BeardedCollie(53)
//CardiganWelshCorgi(28)

//ezek az osztályok implementálják a Dogstats interface-t és a height-re visszaadják a magasságukat, name-re a nevüket.

//4. Hozzuk létre a DogFactory osztályunkat, benne egy Size enummal, amelynek értékei (SMALL, MEDIUM, LARGE).

//Készítsünk egy getDog statikus függvényt, amely bemeneti mérettől függően visszaadja a megfelelő osztályt.




    }
}