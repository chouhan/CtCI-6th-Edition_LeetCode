public class GetFirstSecondMaxMinFromArray {

    private int firstMax;
    private int secondMax;
    private int firstMin;
    private int secondMin;

    public void getMinMax(int[] numbers){

        if(numbers.length == 1) {
            System.out.println("Invalid Input");
        }

        // To get first max and second max, initially set the values to MIN value.
        firstMax = secondMax = Integer.MIN_VALUE;

        // To get first min and second min, initially set the values to MAX value.
        firstMin = secondMin = Integer.MAX_VALUE;

        for(int i = 0; i < numbers.length; i++){

            // If number in the array is greater than the firstMax, then update secondMax with firstMax and later update firMax with the number in array
            if(numbers[i] > firstMax) {
                secondMax = firstMax;
                firstMax = numbers[i];
            }
            /* If arr[i] is in between first and second then update second  */
            else if(numbers[i] > secondMax && numbers[i] < firstMax){
                secondMax = numbers[i];
            } else if(numbers[i] < firstMin) {
                secondMin = firstMin;
                firstMin = numbers[i];
            } else if(numbers[i] < secondMin && numbers[i] > firstMin){
                secondMin = numbers[i];
            }
        }

        if(secondMax == Integer.MIN_VALUE){
            System.out.println("There is no secondMax available");
        }
        else if(secondMin == Integer.MAX_VALUE){
            System.out.println("There is no secondMin available");
        } else {
            System.out.println("The first largest is " + firstMax);
            System.out.println("The second largest is " + secondMax);
            System.out.println("The first smallest is " + firstMin);
            System.out.println("The second smallest is " + secondMin);
        }
    }

    public static void main(String[] args){
        int[] numbers = {7,1,4,8,5,12,2,32,0,6};
        GetFirstSecondMaxMinFromArray getFirstSecondMaxMinFromArray = new GetFirstSecondMaxMinFromArray();
        getFirstSecondMaxMinFromArray.getMinMax(numbers);
    }
}
