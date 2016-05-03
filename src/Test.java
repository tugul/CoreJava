import enums.Season;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Test {
    public static void main(Object[] args) {
        System.out.println("Objects");
    }

    public static void main(Integer[] args) {
        System.out.println("Integers");
    }

    public static void main(int[] args) {
        System.out.println("int");
    }

    public static void main(String[] args) {
        // Multiple variable of same type can be declared in one line
        String a ="a", b ="b", c="c";
        int i=0, j=1;

        // Null can be concatenated
        String s = null;
//        s = s + 1;
//        System.out.println(s);
//        String x;
//        String q[] = new String[5];
//        for (String å : q)
//            System.out.println(å.concat(å + 111));

        // ArrayList constructor, subList, addAll()
        List<String> s1 = new ArrayList<>();
        s1.add("a");
        s1.add("b");
        s1.add(1, "c");
        List<String> s2 = new ArrayList<>(s1.subList(1, 1));
        s1.addAll(s2);
        System.out.println(s1);

        // Lambda parameter must be unique in whole containing block

        // If condition requires boolean expression

        // No non-argument constructor in wrapper class
        Integer it = new Integer(4);


        int ad = 3;
        boolean ttt = false;
        while(ttt){
            ad = 4;
        }
        System.out.println(3.5 % 3);

        System.out.println(Integer.MIN_VALUE);
        System.out.println(-Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(-Integer.MAX_VALUE);

        // Wrapper class
        System.out.println(Integer.valueOf(5));
        System.out.println(Integer.valueOf("5"));
        System.out.println(Integer.parseInt("5"));
        System.out.println(new Integer(5).intValue());
        System.out.println(new Integer(5).longValue()); // returns long
        System.out.println(new Long("5").intValue());   // returns int

        System.out.println(Boolean.parseBoolean(""));


        // Every wrapper classes has only 2 constructor
        // 1. takes string in argument
        // 2. takes their primitive value in argument
        // No non-argument or no Wrapper object argumented contstructor
        Short short1 = new Short((short)5);
        Short short2 = new Short("5");

        Boolean bool1 = new Boolean(true);
        Boolean bool2 = new Boolean("false");

        Byte byte1 = new Byte((byte)5);
        Byte byte2 = new Byte("5");

        short k = 97;
        int o = 98;
        float t = o;
        o = (int)t;
        System.out.println((char)k + ", " + (char)o);
        System.out.println((char)k + ", " + (char)t);

        int ik = Integer.MAX_VALUE;
        float f = ik;
        System.out.println(ik);
        System.out.println(f);
        ik = (int)f;         // Int to float requires explicit cast, but precision will be lost
        System.out.println(ik == Integer.MAX_VALUE);

        Byte aaa = new Byte((byte)1);
        Byte aab = new Byte(1);
        Float aac = new Float(1.0);


    }
}
