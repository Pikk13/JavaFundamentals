import java.util.concurrent.ThreadLocalRandom;

public class MySingleton {

    private static  MySingleton instance;
    private int myRandomNumber;

    private MySingleton(int myRandomNumber){
        this.myRandomNumber = myRandomNumber;
    }

    public static MySingleton getInstance(){
     if (instance == null){
         instance = new MySingleton(ThreadLocalRandom.current().nextInt(1, 100));
     }
        return instance;
    }

    public int getMyRandomNumber() {
        return myRandomNumber;
    }

    public void setMyRandomNumber(int myRandomNumber) {
        this.myRandomNumber = myRandomNumber;
    }

    @Override
    public String toString() {
        return "MySingleton{" +
                "myRandomNumber=" + myRandomNumber +
                '}';
    }
}
