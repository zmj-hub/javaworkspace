package Factory;

public class Test {
    public static void main(String[] args) {
        //生产苹果味的冰激凌
        Factory.IceCreamFactory appleIceCreamFactory =new AppleIceCreamFactory();
        Factory.IceCream appleIceCream=appleIceCreamFactory.CreateIceCream();
        appleIceCream.test();
        //生产香蕉味的冰激凌
        Factory.IceCreamFactory bananaIceCreamFactory=new BananaIceCreamFactory();
        Factory.IceCream bananaIceCream = bananaIceCreamFactory.CreateIceCream();
        bananaIceCream.test();
        //生产橘子味的冰激凌
        Factory.IceCreamFactory orangeIceCreamFactory=new OrangeIceCreamFactory();
        IceCream orangeIceCream = orangeIceCreamFactory.CreateIceCream();
        orangeIceCream.test();
    }
}
