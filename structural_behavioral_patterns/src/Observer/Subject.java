package Observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state; // az állapot amit a feliratkozottak figyelnek

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    public void notifyAllObservers(){
        for (Observer obs: observers) {
        obs.update();
        }
    }
    public void attach(Observer obs){
       this.observers.add(obs);
    }
}
