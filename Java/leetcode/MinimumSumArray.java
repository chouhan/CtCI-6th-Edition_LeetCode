import java.util.Arrays;

/*
*
* Given an integer array, whenever a duplicate number is found, you may increment it (++).
* Find the minimum sum of the numbers in the array by keep incrementing the duplicates
* until all the numbers are unique.
*
* Complexity of this O(Nlog(N)) + O(1);
*
* */
public class MinimumSumArray {

    public static int minSumArray(int[] arr)
    {
        Arrays.sort(arr);
        int currentMin = arr[0];
        int sum = arr[0];
        int currentElement = arr[0];
        int i = 1, j = 1;
        while (i < arr.length)
        {
            if (arr[i] == currentElement)
            {
                while (true)
                {
                    if (j < arr.length)
                    {
                        if (arr[j] == currentElement)
                        {
                            j++;
                        }
                        else if (arr[j] == currentMin+1)
                        {
                            while (j < arr.length && arr[j] == currentMin + 1)
                            {
                                j++;
                            }
                            currentMin++;
                        }
                        else
                        {
                            break;
                        }
                    }
                    else
                    {
                        currentMin++;
                        break;
                    }
                }
                arr[i] = currentMin;

            }
            else
            {
                currentElement = arr[i];
            }
            sum += arr[i];
            i++;
            if (j < i)
            {
                j = i;
            }
        }
        return sum;
    }

    public static void main(String[] args){
        MinimumSumArray minimumSumArray = new MinimumSumArray();
        int[] a = {1,2,3,3,4,5,5,2,6,7,1,0,3,4};
        System.out.println(minimumSumArray.minSumArray(a));
    }
}
