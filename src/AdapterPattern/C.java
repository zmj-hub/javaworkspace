package AdapterPattern;

public class C extends B implements A {

    @Override
    public void deal() {
        specialDeal();
    }
}
