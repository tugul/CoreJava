Functional interface is an interface that has one abstract method. Below is commonly used built-in functional 
interfaces introduced in Java 8. 


Functional Interface | Return Type | Functional Method | Argument | Primitive Specialization
 --- | --- | --- | --- | ---
Supplier\<T> | T | get   | -  | BooleanSupplier, IntSupplier, LongSupplier, DoubleSupplier
Consumer\<T> | void | accept | T t | IntConsumer, LongConsumer, DoubleConsumer
BiConsumer\<T, P> | void | accept | T t, P p | 
Predicate\<T> | boolean | test | T t | IntPredicate, LongPredicate, DoublePredicate
BiPredicate\<T, P> | boolean | test |T t, P p | 
Function\<T, R> | R | apply |T t | IntFunction, IntToDoubleFunction, IntToLongFunction, LongFunction, LongToDoubleFunction, LongToIntFunction, DoubleFunction, ToIntFunction, ToDoubleFunction, ToLongFunction
BiFunction\<T,P,R> | R | apply | T t, P p | ToDoubleBiFunction, ToIntBiFunction, ToLongBiFunction
UnaryOperator\<T> | T | apply | T t | IntUnaryOperator, LongUnaryOperator, DoubleUnaryOperator
BinaryOperator\<T> | T | apply | T t1, T t2  | IntBinaryOperator, LongBinaryOperator, DoubleBinaryOperator

