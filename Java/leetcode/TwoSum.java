import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[1] = i;
                result[0] = map.get(target - numbers[i]);
                int s = target - numbers[i];
                System.out.println("Pair with given sum " +
                        target + " is (" + s +
                        ", "+numbers[i]+")");
                return result;
            }
            map.put(numbers[i], i);
        }
        return result;
    }

    public static void main(String[] args){
        int A[] = {1, 4, 45, 6, 10, 8};
        int n = 16;
        TwoSum twoSum = new TwoSum();
        System.out.println("Pairs with Indices - " +  Arrays.toString(twoSum.twoSum(A, n)));
    }
}
