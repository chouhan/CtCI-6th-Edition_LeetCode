import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

public class ReversePolishNotation {

    private static String[] input = {"2", "1", "+", "3", "*"};

    public static int evalRPN(String[] tokens){
        if(tokens == null || tokens.length == 0){
            return -1;
        }

        int first, second;
        Stack<Integer> myStack = new Stack<Integer>();

        for(String token: tokens){
            switch(token) {
                case "+": {
                    int sum = myStack.pop() + myStack.pop();
                    myStack.push(sum);
                    break;
                }
                case "-": {
                    first = myStack.pop();
                    second = myStack.pop();
                    int sub = second - first;
                    myStack.push(sub);
                    break;
                }
                case "*": {
                    int mul = myStack.pop() * myStack.pop();
                    myStack.push(mul);
                    break;
                }
                case "/": {
                    first = myStack.pop();
                    second = myStack.pop();
                    int div = second/first;
                    myStack.push(div);
                    break;
                }
                default: {
                    myStack.push(Integer.parseInt(token));
                    break;
                }
            }

        }
        return myStack.pop();
    }


    public static void main(String[] args){
        System.out.println(evalRPN(input));
    }

}



