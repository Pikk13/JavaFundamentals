import java.util.Comparator;

public class MyComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {

        if ((int) o1 > (int) o2) return 1;
        else if ((int) o1 < (int) o2) return -1;
        else return 0;
    }


}
