Concurrent Collections
---
Read/write access are synchronized so that data consistency is kept during multi-thread execution.


Concurrent collection classes
---
ConcurrentHashMap - 
ConcurrentLinkedDeque
ConcurrentLinkedQueue

ConcurrentSkipListMap
ConcurrentSkipListSet

CopyOnWriteArrayList
CopyOnWriteArraySet

LinkedBlockingDeque
LinkedBlockingQueue

**Blocking queues**
They are just like regular queues except for its additional methods which wait specified amount of time 
to complete read/write to collection. For example, BlockingQueue has:
  offer(E e, long timeout, TimeUnit) - add item waiting for specified time, returns false if timeout elapsed  
  poll(long timeout, TimeUnit) - take/remove item from queue waiting for specified time, returns null if time elapsed
they throw ___InterruptedException___ if the thread is interrupted while waiting

***BlockingDeque***
offerFirst(E e, long timeout, TimeUnit)
offerLast(E e, long timeout, TimeUnit)
pollFirst(long timeout, TimeUnit)
pollLast(long timeout, TimeUnit)

Parallel stream
---
Although the 1 and 2 argument reduce() support parallel processing, it is recommended to use the 3-argument version of reduce() when working with parallel streams.
We have to define Identity, Accumulator or Combiner for 3argument reduce. Then using parallel stream will result consistent and ordered output.
It is same for 3 argument version of collect() method.

