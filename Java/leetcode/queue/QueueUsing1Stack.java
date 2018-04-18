package queue;


import java.util.Stack;

/*
*
*
* https://stackoverflow.com/questions/12470626/how-can-one-implement-a-queue-with-only-a-stack-implementation
*
* Implementation of a Queue needs at least 2 stacks.
*
* We can use Programs Call Stack as one Stack and one our own implementation of a stack
*
* */
public class QueueUsing1Stack {

    private Stack<Integer> stack = new Stack<>();
    private String print;
    private int front;
    private int rear;

    public QueueUsing1Stack(){}

    /*
    *
    * Add
    *
    *
    * */
    public void add(int n){
        if(stack.isEmpty()){
            front = n;
        }
        stack.push(n);
        rear = n;
        print = (stack.clone()).toString();
    }

    /*
    *
    * Remove
    *
    * */
    public void delete(){
        if(!stack.isEmpty()){
            int m = stack.pop();
            if(!stack.isEmpty()){
                delete();
                stack.push(m);
            }
        }
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



    /*
     *  IS QUEUE EMPTY?
     *
     * */
    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public static void main(String[] args){
        // FIFO Implementation
        QueueUsing1Stack queueUsing1Stack = new QueueUsing1Stack();
        queueUsing1Stack.add(2); // adding First Element
        queueUsing1Stack.add(6);
        queueUsing1Stack.add(2);
        queueUsing1Stack.add(1);
        queueUsing1Stack.add(6);
        queueUsing1Stack.add(9);
        queueUsing1Stack.add(3); // Adding Last element

        System.out.println("First element " + queueUsing1Stack.front);
        System.out.println("Last element " + queueUsing1Stack.rear);

        System.out.println();
        queueUsing1Stack.print();

        System.out.println();
        queueUsing1Stack.delete();
        queueUsing1Stack.print();

        System.out.println();
        queueUsing1Stack.delete();
        queueUsing1Stack.print();

        System.out.println("\nNow the first element is " + queueUsing1Stack.front);
        System.out.println("Now the last element is " + queueUsing1Stack.rear);

        System.out.println("\n Is Queue Empty? - " + queueUsing1Stack.isEmpty());

    }


}
