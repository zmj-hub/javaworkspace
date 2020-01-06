package ProxyPattern;

public class Proxy implements Subject {
    private RealSubject realSubject;

    @Override
    public void Request() {
        if (realSubject == null) {
            realSubject = new RealSubject();
        }
        preRequest();
        realSubject.Request();
        postRequest();
    }

    public void preRequest() {
        System.out.println("预处理");
    }

    public void postRequest() {
        System.out.println("后处理");
    }
}
