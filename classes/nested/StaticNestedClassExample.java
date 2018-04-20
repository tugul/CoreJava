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
class OuterClassEx{
    private static String args = " args";
    private String mainGot = " main got ";

    protected static class StaticNestedClass  {
        protected OuterClassEx outerObj;
        static StaticNestedClass nestedObj;

        public static void main(String... args) {
            StaticNestedClass me = new StaticNestedClass();
            me.outerObj = new OuterClassEx();
            System.out.println("Static nested class's" + me.outerObj.mainGot + args.length + OuterClassEx.args);
            me.sayMyName();
        }

        void sayMyName(){
            System.out.println("I received arguments through " + new OuterClassEx().mainGot);
        }
    }

    public StaticNestedClass getStaticNestedObj(){
        // Here no object is instantiated, only accessing to static member in static nested class
        return StaticNestedClass.nestedObj;
    }
}

public class StaticNestedClassExample {
	static class Testing{
	}
	
	void tester(){
		Testing tt = new Testing();
	}
	
    public static void main(String[] args) {
        OuterClassEx.StaticNestedClass staticNestedObj = new OuterClassEx.StaticNestedClass();
        staticNestedObj.main(args);                 // Static nested class's main got X args

        OuterClassEx outerObj = new OuterClassEx();
        OuterClassEx.StaticNestedClass nestedObj = outerObj.getStaticNestedObj();
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
