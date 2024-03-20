package Strategy;

public class Player {

    private AttackStrategy strategy; //kívülről megkapja a használandó implementációt

    public void setAttackStrategy(AttackStrategy strategy) {
        this.strategy = strategy;
    }
    public void performAttack(){
        this.strategy.attack();  // nem is tudja, ez melyik implementáció, az interfészen keresztül mégis eléri
    }
}
