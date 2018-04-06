import java.util.Iterator;
import java.util.Vector;

/*
* The Vector class implements a growable array of objects.
* Like an array, it contains components that can be accessed using an integer index.
* However, the size of a Vector can grow or shrink as needed to accommodate adding and removing items after the Vector has been created.
* Each vector tries to optimize storage management by maintaining a capacity and a capacityIncrement.
* The capacity is always at least as large as the vector size; it is usually larger because as components are added to the vector,
* the vector's storage increases in chunks the size of capacityIncrement.
*
* An application can increase the capacity of a vector before inserting a large number of components;
* this reduces the amount of incremental reallocation.
*
* The iterators returned by this class's iterator and listIterator methods are fail-fast:
* if the vector is structurally modified at any time after the iterator is created,
* in any way except through the iterator's own remove or add methods,
* the iterator will throw a ConcurrentModificationException.
*
* Thus, in the face of concurrent modification, the iterator fails quickly and cleanly,
* rather than risking arbitrary, non-deterministic behavior at an undetermined time in the future.
*
* The Enumerations returned by the elements method are not fail-fast.
*
* Note that the fail-fast behavior of an iterator cannot be guaranteed as it is, generally speaking,
* impossible to make any hard guarantees in the presence of unsynchronized concurrent modification. Fail-fast iterators
* throw ConcurrentModificationException on a best-effort basis.
*
* Therefore, it would be wrong to write a program that depended on this exception for its correctness:
* the fail-fast behavior of iterators should be used only to detect bugs.
*
*  Bullet Points:
*
*  - Vectors are same as ArrayList
*  - Vectors grow dynamically, doubling the size (twice the size of initial capacity).
*  - Increases by 100%, when size grows
*  - Vectors are thread safe
*  - All methods in Vector are synchronized
*  - Since it is synchronized, it is slower than ArrayList
*
* */
public class MyVector {
    public  static void main(String[] args){

        Vector<Integer> v = new Vector<Integer>();

        // Initial Vector Capacity
        System.out.println("Initial Capacity is " + v.capacity());

        // Should return true
        System.out.println("Vector just got initialized and it is empty - " + v.isEmpty());

        // Add integers to Vector

        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        v.add(5);
        v.add(6);
        v.add(7);
        v.add(8);
        v.add(9);
        v.add(10);
        v.add(11);
        v.add(12);
        v.add(13);
        v.add(14);
        v.add(15);


        System.out.println("Size is " + v.size());
        System.out.println("Capacity now is " + v.capacity());

        System.out.println("Index at 0 - " + v.get(0));

        // Remove item at 5
        System.out.println("Integer is being removed at index 5 - " + v.get(5));
        v.remove(5);
        System.out.println("Size now is " + v.size());

        // What is at index 5
        System.out.println("Now What is at index 5 - " + v.get(5));

        // Iterating on Vector
        Iterator<Integer> it = v.iterator();
        while(it.hasNext()) {
            System.out.println("Looping using iterators - " + it.next());
        }

        // Looping using for each
        for( int i : v) {
            System.out.println("Loop using i - " + i);
        }


        // Vector with fixed capacity

        Vector<Integer> v1 = new Vector<>(1,0);

        System.out.println("Initial Capacity of v1 - " + v1.capacity());

        v1.add(1);

        System.out.println("Now Capacity of v1 - " + v1.capacity());
        System.out.println("Size of v1 is " + v1.size());

        v1.add(2);
        System.out.println("Size of v1 now is " + v1.size());

        v1.ensureCapacity(2);
        System.out.println("again - Now Capacity of v1 - " + v1.capacity());
    }
}
