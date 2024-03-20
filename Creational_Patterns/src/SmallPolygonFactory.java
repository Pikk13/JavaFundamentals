public class SmallPolygonFactory extends AbstractPolygonFactory {

    public Polygon getPolygon(int sides){
        switch (sides){
            case 3:
                return new Triangle();
            case 4:
                return new Square();
            case 5:
                return new Pentagon();
            default: return null;
        }
    }
}
