package Factory;

public class BananaIceCreamFactory implements IceCreamFactory {
    @Override
    public IceCream CreateIceCream() {
        return  new BananaIceCream();
    }
}
