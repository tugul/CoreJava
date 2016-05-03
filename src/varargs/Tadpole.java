package varargs;

import strings.*;
/**
 */
public class Tadpole extends Frog {
    public static void main(String[] args) {
        Tadpole t = new Tadpole();
        System.out.println(t.i);
        t.a();
        t.b();
        Frog f = new Tadpole();
        f.a();                  // DOES NOT COMPILE
        ((Tadpole)f).a();
        f.b();
    }
}
