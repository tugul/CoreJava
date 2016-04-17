package classes.nested;

/**
 * Inner class defined as static in a class
 * - can access to instance members of outer class only through instance of outer class
 * - can access to static members of outer class directly using name of outer class
 * - behaves and interacts with other classes(inc. outer one) like it is top-level class though nested
 * - accessed from outside classes with name of outer class without need for instance of outer class
 * - can have any access modifier like inner class
 * - outer class can directly access to its static members, but to its instance members only through its instance
 */
class OuterClass {
    static String args = " args";
    public String mainGot = " main got ";

    static class StaticNestedClass {
        OuterClass outerObj;
        static StaticNestedClass nestedObj;

        public static void main(String... args) {
            StaticNestedClass me = new StaticNestedClass();
            me.outerObj = new OuterClass();
            System.out.println("Static nested class's" + me.outerObj.mainGot + args.length + OuterClass.args);
        }

        void sayMyName(){
            System.out.println("Static nested class");
        }
    }

    public StaticNestedClass getStaticNestedObj(){
        return StaticNestedClass.nestedObj;
    }
}

public class StaticNestedClassExample {
    public static void main(String[] args) {
        OuterClass.StaticNestedClass staticNestedObj = new OuterClass.StaticNestedClass();
        staticNestedObj.main(args);                 // Static nested class's main got X args

        OuterClass outerObj = new OuterClass();
        outerObj.getStaticNestedObj().main(args);   // Static nested class's main got X args
        outerObj.getStaticNestedObj().sayMyName();  // NullPointerException
    }
}
