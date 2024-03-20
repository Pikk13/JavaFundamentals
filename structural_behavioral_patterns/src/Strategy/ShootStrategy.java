package Strategy;

public class ShootStrategy implements AttackStrategy{
    @Override
    public void attack() {
        System.out.println("Shoot");
    }
}
