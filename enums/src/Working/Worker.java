package Working;

public class Worker extends Construction{

    @Override
    public void useTools(Tools tool) {
        System.out.println("A munkás munkaeszköze: " + tool);
    }

    @Override
    public void workingArea(String valami) {
        System.out.println("A munkás munkavégzésének fizikai helyszíne: " + valami);
    }
}
