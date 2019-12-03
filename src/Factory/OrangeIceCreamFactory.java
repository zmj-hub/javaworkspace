package Factory;

public class OrangeIceCreamFactory implements IceCreamFactory {
    @Override
    public IceCream CreateIceCream() {
        return  new OrangeIceCream();
    }
}
