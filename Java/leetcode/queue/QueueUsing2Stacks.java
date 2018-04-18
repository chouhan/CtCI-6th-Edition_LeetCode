package queue;

import java.util.Collections;
import java.util.Stack;


/*
*
* Implement a Queue using 2 stacks
*
* A Queue is a FIFO - FIRST IN FIRST OUT
*
* Ex: 2,6,2,1,6,9,3
* ---------------->
*
* first in is 3, so first out is 3
*
* Queue Operations
* ----------------
*
* Operation - method with exception/method without exception
* ----------------------------------------------------------
*
* Insert - add/offer
* Remove - remove/poll
* Fetch - element/peek
*
* JAVA QUEUES DON'T HAVE ENQUEUE AND DEQUEUE METHODS, THESE OPERATIONS ARE DONE USING THE FOLLOWING METHODS:
*
* ENQUEUING:
*
*    add(e): throws exception if it fails to insert the object
*    offer(e): returns false if it fails to insert the object
*
* DEQUEUING:
*
*    remove(): throws exception if the queue is empty
*    poll(): returns null if the queue is empty
*
* FETCH - Take a look to the first object in the queue:
*
*    element(): throws exception if the queue is empty
*    peek(): returns null if the queue is empty
*
* */
public class QueueUsing2Stacks {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();
//    private Stack<Integer> print;

    private String print;

    private int front;
    private int rear;


    public QueueUsing2Stacks(){ }

    /*
    *
    * Enqueue (push)
    *
    * */
    public void add(int n){
        if(stack1.empty()){
            front = n;
        }
        stack1.push(n);
        rear = n;
        print = ((Stack<Integer>) stack1.clone()).toString();
    }

    /*
    *
    * Dequeue (remove)
    *
    * */
    public void delete(){
        // If Stack2 is empty, copy all the contents from stack 1 to stack2
        if(stack2.isEmpty()){
            while(!stack1.isEmpty()){
                int m = stack1.pop();
                stack2.push(m);
            }
        }

        // Remove the first element from stack2
        int pop = stack2.pop();
        System.out.println("Popped element " + pop);

        // This below code is used for printing in a sequence order
        Stack temp = (Stack<Integer>) stack2.clone();
        Collections.reverse(temp);
        print = temp.toString();
    }

    /*
    *  IS QUEUE EMPTY?
    *
    * */
    public boolean isEmpty(){
        return stack1.isEmpty() && stack2.isEmpty();
    }

    /*
    * PRINT
    * */
    public void print(){
        /*while(!print.isEmpty()){
            int n = print.pop();
            System.out.print(n + ", ");
        }*/
        System.out.println(print);
    }


    public static void main(String[] args){
        // FIFO Implementation
        QueueUsing2Stacks queueUsing2Stacks = new QueueUsing2Stacks();
        queueUsing2Stacks.add(2); // adding First Element
        queueUsing2Stacks.add(6);
        queueUsing2Stacks.add(2);
        queueUsing2Stacks.add(1);
        queueUsing2Stacks.add(6);
        queueUsing2Stacks.add(9);
        queueUsing2Stacks.add(3); // Adding Last element

        System.out.println("First element " + queueUsing2Stacks.front);
        System.out.println("Last element " + queueUsing2Stacks.rear);

        System.out.println();
        queueUsing2Stacks.print();

        System.out.println();
        queueUsing2Stacks.delete();
        queueUsing2Stacks.print();

        System.out.println();
        queueUsing2Stacks.delete();
        queueUsing2Stacks.print();

        System.out.println("\nNow the first element is " + queueUsing2Stacks.front);
        System.out.println("Now the last element is " + queueUsing2Stacks.rear);

        System.out.println("\n Is Queue Empty? - " + queueUsing2Stacks.isEmpty());

    }

}
