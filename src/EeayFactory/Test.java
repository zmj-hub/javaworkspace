package EeayFactory;

public class Test {
    public static void main(String[] args) {
        IceCream appleIceCream = IceCreamFactory.CreateIceCream("Apple");
        appleIceCream.test();
        IceCream bananaIceCream = IceCreamFactory.CreateIceCream("Banana");
        bananaIceCream.test();
        IceCream orangeIceCream = IceCreamFactory.CreateIceCream("Orange");
        orangeIceCream.test();
    }
}
