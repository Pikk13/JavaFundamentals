import java.time.ZonedDateTime;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

public class TimeSingleton {

    ZonedDateTime ido = ZonedDateTime.now();

    private static TimeSingleton instance;
    private static ZonedDateTime timeNow;



    private TimeSingleton(ZonedDateTime timeNow){
        this.timeNow = timeNow;
    }

    public static TimeSingleton getInstance(){
        if (instance == null){
            instance = new TimeSingleton(timeNow);
        }
        return instance;
    }

    public static ZonedDateTime getTimeNow() {
        return timeNow;
    }


    @Override
    public String toString() {
        return "TimeSingleton{" +
                "ido=" + ido +
                '}';
    }
}
