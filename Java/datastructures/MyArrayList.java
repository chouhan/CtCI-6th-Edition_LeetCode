import java.util.*;

public class MyArrayList {

    public static void main(String[] args){
        // Using Collections
        // - Collection does not work when adding indexed item. c.add(2); does not work, so you would not get 1,2 3
        Collection<Integer> c = new ArrayList<Integer>();

        c.add(1);
        c.add(3);

        // Cannot add it in sequence using collections
        c.add(2);

        // Loop using Iterators

        Iterator<Integer> it = c.iterator();
        do {
            System.out.println("Do While Loop using iterators on collections - " + it.next());
        } while (it.hasNext());

        // Using List interface
        List<Integer> l = new ArrayList<Integer>();

        l.add(1);
        l.add(3);

        l.add(1, 2);
        l.add(0, 5);

        // Loop List using for each
        for(int i : l){
            System.out.printf("Looping list using for each %d\n", i);
        }

        Collections.sort(l);

        // After Sort
        Iterator<Integer> n = l.iterator();
        while (n.hasNext()){
            System.out.println("After Sort - " + n.next());
        }

        l.forEach(System.out::println);
    }
}
