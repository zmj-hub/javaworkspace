package AbstractFactory;

public class AppleIceCreamFactory implements IceCreamFactory {

    @Override
    public BigIceCream createBigIceCream() {
        return new  BigAppleIceCream();
    }

    @Override
    public SmallIceCream createSmallIceCream() {
        return new SmallAppleIceCream();
    }
}
