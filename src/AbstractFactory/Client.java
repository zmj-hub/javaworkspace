package AbstractFactory;

public class Client {
    public static void main(String[] args) {
        //生产苹果味的冰激凌
        IceCreamFactory appleIceCreamFactory=new AppleIceCreamFactory();
        BigIceCream appleBigIceCream=appleIceCreamFactory.createBigIceCream();
        SmallIceCream appleSmallIceCream=appleIceCreamFactory.createSmallIceCream();
        appleBigIceCream.taste();
        appleSmallIceCream.taste();

        //生产香蕉味冰激凌
        IceCreamFactory bananaIceCreamFactory = new BananaIceCreamFactory();
        BigIceCream bananaBigIceCream = bananaIceCreamFactory.createBigIceCream();
        SmallIceCream bananaSmallIceCream = bananaIceCreamFactory.createSmallIceCream();
        bananaBigIceCream.taste();
        bananaSmallIceCream.taste();

        //生产橘子味冰激凌
        IceCreamFactory orangeIceCreamFactory = new OrangeIceCreamFactory();
        BigIceCream orangeBigIceCream = orangeIceCreamFactory.createBigIceCream();
        SmallIceCream orangeSmallIceCream = orangeIceCreamFactory.createSmallIceCream();
        orangeBigIceCream.taste();
        orangeSmallIceCream.taste();

    }
}
