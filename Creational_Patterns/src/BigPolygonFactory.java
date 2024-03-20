public class BigPolygonFactory extends AbstractPolygonFactory{
    @Override
    Polygon getPolygon(int sides) {
        switch (sides){
            case 4:
                return new Square();
            case 5:
                return new Pentagon();
            default:
                return null;
        }
    }
}
