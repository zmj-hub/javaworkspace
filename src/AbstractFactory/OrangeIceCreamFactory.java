package AbstractFactory;

public class OrangeIceCreamFactory implements IceCreamFactory {
    @Override
    public BigIceCream createBigIceCream() {
        return new BigOrangeIceCream();
    }

    @Override
    public SmallIceCream createSmallIceCream() {
        return new SmallOrangeIceCream();
    }
}
