package AbstractFactory;

public class BananaIceCreamFactory implements IceCreamFactory {
    @Override
    public BigIceCream createBigIceCream() {
        return new BigBananaIceCream();
    }

    @Override
    public SmallIceCream createSmallIceCream() {
        return new SmallBananaIceCream();
    }
}
