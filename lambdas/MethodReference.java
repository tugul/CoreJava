package lambdas;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * - Method reference
 * New feature in Java 8 which makes lambda expression even easier to write
 * Short syntax containing no parameter declaration or implementation logic which are inferred by compiler
 * The implementation is defined in somewhere else, so it promotes code reuse
 *
 * - Syntax
 * Class name or object reference followed by (::) and method name
 * 
 * - Scenarios
 * 1. ClassName::StaticMethod
 * 2. ObjectReference::InstanceMethod
 * 3. ContainingType::InstanceMethod
 * 4. ClassName::Constructor
 *
 * In a nutshell, if lambda expression's input parameter and return type (in other words, 
 * parameter and return type of functional method of functional interface) matches with 
 * those of any method, that method's reference can replace the lambda expression. 
 * 
 */

interface MyFunctionalInteface {
	public void func(Integer i, String str);
}

public class MethodReference {
	
    static void runConsumer(Consumer<List<Integer>> consumer){
    	List<Integer> numbers = Arrays.asList(3, 1, 12, 5, 4);
    	consumer.accept(numbers);
    	System.out.println(numbers);
    }
	
    static void runPredicate(Predicate<String> predicate){
    	System.out.println(predicate.test("a"));
    	System.out.println(predicate.test(""));
    }
    
    static void runSupplier(Supplier supplier){
    	System.out.println(supplier.get());
    }
    
    static void runFunc(MyFunctionalInteface myFunc){
    	myFunc.func(5, "String");
    }
    
    public MethodReference(List<Integer> list){ }
    public MethodReference(Integer i, String str){ }
    
    public static String getStr() { return "no argument";}
    public static String getStr(Integer i){ return i + " is argument"; }

    public static void main(String[] args) {
        // 1. Calling static method
    	Consumer<List<Integer>> lambdaExp1 = list -> Collections.sort(list);
        Consumer<List<Integer>> methodRef1 = Collections::sort;
        runConsumer(methodRef1);

        // 2. Calling instance method on specific instance
        String strObj = "abc";
        Predicate<String> lambdaExp2 = s -> strObj.startsWith(s);
        Predicate<String> methodRef2 = strObj::startsWith;
        runPredicate(methodRef2);
        
        // 3. Calling instance method on instance to be determined at runtime
        Predicate<String> lambdaExp3 = str -> str.isEmpty();
        Predicate<String> methodRef3 = String::isEmpty;
        runPredicate(methodRef3);	// true
        
        BiPredicate<String, String> lambdaExp31 = (s, prefix) -> s.startsWith(prefix);
        BiPredicate<String, String> methodRef31 = String::startsWith;

        // 4. Calling constructor
        Supplier<LinkedList> lambdaExp4 = () -> new LinkedList();
        Supplier<LinkedList> methodRef4 = LinkedList::new;
        runSupplier(methodRef4);	// []
        runSupplier(HashMap::new);	// {}
        
        runConsumer(MethodReference::new);	// calls MethodReference(List<Integer> list)
        runFunc(MethodReference::new);		// calls MethodReference(Integer i, String str)
        
        // Referring to overloaded methods
        Supplier<String> supplier = MethodReference::getStr;
        Function<Integer, String> function = MethodReference::getStr;
        System.out.println(supplier.get());			// no argument
        System.out.println(function.apply(5));		// 5 is argument
    }
}

/** Output
[1, 3, 4, 5, 12]
true
true
false
true
[]
{}
[3, 1, 12, 5, 4]
no argument
5 is argument
 */

