package EeayFactory;

public class IceCreamFactory {
    public static IceCream CreateIceCream(String test) {
        IceCream iceCream = null;

        switch (test) {
            case "Apple":
                iceCream = new AppleIceCream();
                break;
            case "Banana":
                iceCream = new BananaIceCream();
                break;
            case "Orange":
                iceCream = new OrangeIceCream();
                break;
            default:
                break;
        }
        return iceCream;
    }
}
