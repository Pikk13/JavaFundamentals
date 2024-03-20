public class Akita extends Dog implements Dogstats{
    @Override
    public void height() {
        System.out.println("Marmagasság: 70 cm");
    }

    @Override
    public void name() {
        System.out.println("Mázli");
    }

    @Override
    Dogstats dogstats(Dog dog) {
        return null;
    }
}
