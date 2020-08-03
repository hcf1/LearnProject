package draft;

import java.awt.Desktop.Action;

public class Inherit {
    private String[] amount;

    Inherit(String[] amount) {
        this.amount = amount;
        pr(amount);
    }
    void pr(String[] amount) {
        System.out.println(amount[0]);
    } 
    void change() {
        amount[0] = "4545";
    }

    void test() {
        System.out.println(amount);
    }
}

class A {
    private String[] amount = null;

    void A() {
        amount = new String[]{"nu","nu"};
        Inherit inherit = new Inherit(amount);
        System.out.println(amount);
        inherit.change();
        inherit.test();
    }
}

class B {
    public static void main(String[] args) {
        A a = new A();
        a.A();
    }
}
