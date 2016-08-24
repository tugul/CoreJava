package collections;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * - Queue 
 * an interface extending Collection interface
 * stores ordered elements in FIFO (first-in first-out)
 * 
 * - Deque
 * an interface extending Queue interface
 * stores ordered elements in a way that elements can be added into both front and back
 * 
 * - LinkedList
 * a concrete class implementing both Deque and List interfaces
 * 
 * - ArrayDeque
 * a concrete class implementing Deque interface
 * double-ended queue and more efficient than LinkedList
 * 
 * boolean 	offer(E e)	- add element to back of queue
 * boolean 	add(E e) 	- add element to back of queue or throws an EXCEPTION (from Collection)
 * void		push(E e)	- add element to front of queue or throws an EXCEPTION (from Deque)
 * 
 * E 		element()	- return front element of queue or throws an EXCEPTION if queue is empty
 * E		peek()		- return front element of queue or null if queue is empty
 * 
 * E 		poll()		- remove/return front element of queue or null if queue is empty
 * E		pop()		- remove/return front element of queue or throws an EXCEPTION if queue is empty (from Deque)
 * E 		remove()	- remove/return front element of queue or throws an EXCEPTION if queue is empty
 * boolean 	remove(E e)	- remove a given element of queue, and throws an EXCEPTION if queue is empty (from Collection)
 * 
 * Note: ArrayDeque is recommended over Stack which is a legacy class. So when using ArrayDeque, 
 * use push/pop/peek for LIFO (stack) and use offer/poll/peek for FIFO (single-ended queue)
 * 
 * ArrayDeque doesn't allow to add null because it has a meaning that poll/peek returns null when queue is empty.
 * 
 */
public class AboutQueue {
	public static void main(String[] args) {
		Deque<Integer> queue = new ArrayDeque<>();
		queue.add(11);
		queue.add(12);
		queue.add(13);
		queue.add(14);
		queue.add(10);
		queue.push(9);
		queue.offer(8);
		
		System.out.println(queue);			// [9, 11, 12, 13, 14, 10, 8]
		
		System.out.println(queue.element());		// 9
		System.out.println(queue.remove(13));		// true
		System.out.println(queue.poll());		// 9
		System.out.println(queue.remove());		// 11
		System.out.println("peeked: " + queue.peek());	// peeked: 12
		System.out.println(queue.element());		// 12
		System.out.println(queue.pop());		// 12
		
		System.out.println(queue);			// [14, 10, 8]
	}
}
/** Output:
[9, 11, 12, 13, 14, 10, 8]
9
true
9
11
peeked: 12
12
12
[14, 10, 8]
 */

