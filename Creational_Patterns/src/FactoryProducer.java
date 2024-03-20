public class FactoryProducer {
    public static AbstractPolygonFactory getFactory(boolean isBig){
        if (isBig){
            return new BigPolygonFactory();
        }else {
            return new SmallPolygonFactory();
        }
    }
}
