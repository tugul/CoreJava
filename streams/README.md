Stream
---
Java 8 Stream API is a big step towards functional programming and leverages multi-core processors which are ubiquitous nowadays. Stream represents a series of objects sourced from collection and support data processing queries, SQL like operations. 

There are generic interface **Stream\<T>** and three specific interfaces for primitives, **DoubleStream**, **IntStream** and **LongStream**

Difference between **Stream\<Integer>** and **IntStream** is that:
**IntStream** is for primitives (int, short, byte and char)
**Stream\<Integer>** is for Integer wrapper class

![Image of Yaktocat](streams.png)

Methods to convert between different Streams

Source | To create Stream | To create DoubleStream | To create IntStream | To create LongStream
--- | --- |--- |--- |---
**Stream** | map | mapToDouble | mapToInt | mapToLong
**DoubleStream** | mapToObj | map | mapToInt | mapToLong
**IntStream** | mapToObj | mapToDouble | map | mapToLong
**LongStream** | mapToObj | mapToDouble | mapToInt | map
 
Those **map*** methods take a single parameter Function, respectively. 

Source | To create Stream | To create DoubleStream | To create IntStream | To create LongStream
--- | --- |--- |--- |---
**Stream** | Function | ToDoubleFunction | ToIntFunction | ToLongFunction
**DoubleStream** | DoubleFunction | DoubleUnaryOperator | DoubleToIntFunction | DoubleToLongFunction
**IntStream** | IntFunction | IntToDoubleFunction | IntUnaryOperator | IntToLongFunction
**LongStream** | LongFunction | LongToDoubleFunction | LongToIntFunction | LongUnaryOperator

Parallel stream
---
It is a stream that can process results simultaneously by using multiple threads. Although performance increase can be achieved, it can change the result unexpectedly if not used carefully.
