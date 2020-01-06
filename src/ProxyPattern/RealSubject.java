package ProxyPattern;

public class RealSubject implements Subject {
    @Override
    public void Request() {
        System.out.println("真实的处理！！！！");
    }
}
