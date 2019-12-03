package Factory;


public class AppleIceCreamFactory implements IceCreamFactory{
    @Override
    public IceCream CreateIceCream() {
        return  new AppleIceCream();
    }
}
