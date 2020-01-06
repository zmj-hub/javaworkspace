package AdapterPattern;

public class D implements A {
    private B b;

    D(B b) {
        this.b = b;
    }

    @Override
    public void deal() {
        b.specialDeal();
    }
}
