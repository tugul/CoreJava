Lambda expression
---
One of the core features introduced in Java 8 to facilitate functional programming. It  provides clear and succinct way to express one method aka functional interface using an expression. It also enhances use of Collection API making it simpler to iterate, filter and process data from collection. Its syntax is as below:<br>
```parameter -> expression body```

Lambda expression can access to static and instance variables, and local variables if they are explicitly final or effectively final (albeit not declared final, value is assigned only once in its scope)


Method reference
---
New feature in Java 8 which makes lambda expression even easier to write. Basically, it is a short syntax containing no parameter declaration or implementation logic which are inferred by compiler. The implementation is defined in somewhere else, so it promotes reusability of code.


Functional interface
---
Functional interface is an interface that has one abstract method. Below is commonly used built-in functional 
interfaces introduced in Java 8. 


Interface | Returns | Method | Argument | Primitive Specialization
 --- | --- | --- | --- | ---
Supplier\<T> | T | get   | .  | BooleanSupplier, IntSupplier, LongSupplier, DoubleSupplier
Consumer\<T> | void | accept | T t | IntConsumer, LongConsumer, DoubleConsumer
BiConsumer\<T, P> | void | accept | T t, P p | 
Predicate\<T> | boolean | test | T t | IntPredicate, LongPredicate, DoublePredicate
BiPredicate\<T, P> | boolean | test |T t, P p | 
Function\<T, R> | R | apply |T t | IntFunction, IntToDoubleFunction, IntToLongFunction, LongFunction, LongToDoubleFunction, LongToIntFunction, DoubleFunction, ToIntFunction, ToDoubleFunction, ToLongFunction
BiFunction\<T,P,R> | R | apply | T t, P p | ToDoubleBiFunction, ToIntBiFunction, ToLongBiFunction
UnaryOperator\<T> | T | apply | T t | IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator
BinaryOperator\<T> | T | apply | T t1, T t2  | IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator

