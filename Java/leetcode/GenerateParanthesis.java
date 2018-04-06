import java.util.ArrayList;
import java.util.List;

/*
*
* https://leetcode.com/problems/generate-parentheses/description/
*
* */
public class GenerateParanthesis {

    public static List<String> generateParanthesis(int n){
        List<String> list = new ArrayList<>();
        if(n == 0){
            list.add("");
        }
        // Loop thru each till n
        for(int i =0; i < n; i++)
            // For each left brace, Loop thru & recurse this function
            for(String left: generateParanthesis(i))
                // For each right brace, Loop thru & recurse this function
                for(String right: generateParanthesis(n-1-i))
                    list.add("("+left+ ")" + right);

        return list;
    }

    // Recursion
    public static List<String> generateParens(int count){
      char[] str = new char[count * 2];
      ArrayList<String> list = new ArrayList<String>();
      addParen(list, count, count, str, 0);
      return list;
    }

    public static void addParen(List<String> list, int leftRemaining, int rightRemaining, char[] str, int index){
        if(leftRemaining < 0 || rightRemaining < leftRemaining){
            return;
        }

        if(leftRemaining == 0 && rightRemaining == 0){
            list.add(String.copyValueOf(str));
        } else {
            str[index] = '('; // Add left parenthesis and recurse
            addParen(list, leftRemaining - 1, rightRemaining, str, index + 1);

            str[index] = ')'; // Add right parenthesis and recurse
            addParen(list, leftRemaining, rightRemaining - 1, str, index + 1);
        }
    }

    public static void main(String args[]){
//        System.out.println(generateParanthesis(3));
        System.out.println(generateParens(3));
    }
}
