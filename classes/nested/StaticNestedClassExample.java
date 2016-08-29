package classes.nested;

import java.io.Serializable;

/**
 * - Static nested class
 * Inner class defined as static inside a class
 * can access to instance members of outer class only through instance of outer class
 * can access to static members of outer class directly using name of outer class
 * behaves and interacts with other classes(inc. outer one) like it is top-level class though nested
 * accessed from outside classes with name of outer class without need for instance of outer class
 * can have any access modifier like inner class
 * outer class can directly access to its static members, but to its instance members only through its instance
 */
class OuterClass {
    private static String args = " args";
    private String mainGot = " main got ";

    protected static class StaticNestedClass  {
        protected OuterClass outerObj;
        static StaticNestedClass nestedObj;

        public static void main(String... args) {
            StaticNestedClass me = new StaticNestedClass();
            me.outerObj = new OuterClass();
            System.out.println("Static nested class's" + me.outerObj.mainGot + args.length + OuterClass.args);
            me.sayMyName();
        }

        void sayMyName(){
            System.out.println("I received arguments through " + new OuterClass().mainGot);
        }
    }

    public StaticNestedClass getStaticNestedObj(){
        // Here no object is instantiated, only accessing to static member in static nested class
        return StaticNestedClass.nestedObj;
    }
}

public class StaticNestedClassExample {
    public static void main(String[] args) {
        OuterClass.StaticNestedClass staticNestedObj = new OuterClass.StaticNestedClass();
        staticNestedObj.main(args);                 // Static nested class's main got X args

        OuterClass outerObj = new OuterClass();
        OuterClass.StaticNestedClass nestedObj = outerObj.getStaticNestedObj();
        System.out.println(nestedObj == null);  // true

        outerObj.getStaticNestedObj().main(args);   // Static nested class's main got X args
        outerObj.getStaticNestedObj().sayMyName();  // NullPointerException because instance method can run on null obj
    }
}


/* Output, if you run java -cp src classes.nested.StaticNestedClassExample 1 2 3

Static nested class's main got 3 args
I received arguments through  main got
true
Static nested class's main got 3 args
I received arguments through  main got

*/
