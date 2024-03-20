package Working;

public class Manager extends Construction{


    @Override
    public void useTools(Tools tool) {
        System.out.println("A menedzser munkaeszköze: " + tool);
    }

    @Override
    public void workingArea(String valami) {
        System.out.println("A menedzser munkavégzésének fizikai helyszíne: " + valami);
    }
}
