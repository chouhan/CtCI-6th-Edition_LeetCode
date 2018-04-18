package sorting;

public class Sorting {

    private int[] theArray = new int[50];

    private int arraySize = 10;

    /*
     *
     * Generate Random Array
     *
     * */
    public void generateRandomArray() {
        for (int i = 0; i < arraySize; i++) {
            theArray[i] = (int) (Math.random() * 10) + 10;
        }
    }

    /*
     *
     * Print Array
     *
     * */
    public void printArray() {
        System.out.println("----------");
        for (int i = 0; i < arraySize; i++) {
            System.out.print("| " + i + " |");
            System.out.println(theArray[i] + " |");
            System.out.println("----------");
        }
    }

    /*
     *
     * Print Horizontal Array
     *
     * */
    public void printHorizontalArray(int i, int j) {
        for (int n = 0; n < 51; n++) System.out.print("-");

        System.out.println();

        for (int n = 0; n < arraySize; n++) {
            System.out.print("| " + n + "  ");
        }

        System.out.println("|");

        for (int n = 0; n < 51; n++)
            System.out.print("-");

        System.out.println();

        for (int n = 0; n < arraySize; n++) {
            System.out.print("| " + theArray[n] + " ");
        }

        System.out.println("|");

        for (int n = 0; n < 51; n++)
            System.out.print("-");

        System.out.println();

        // END OF FIRST PART


        // ADDED FOR BUBBLE SORT
        if (j != -1) {
            // ADD THE +2 TO FIX SPACING
            for (int k = 0; k < ((j * 5) + 2); k++)
                System.out.print(" ");

            System.out.print(j);

        }

        // THEN ADD THIS CODE
        if (i != -1) {
            // ADD THE -1 TO FIX SPACING
            for (int l = 0; l < (5 * (i - j) - 1); l++)
                System.out.print(" ");

            System.out.print(i);
        }
        System.out.println();
    }

    /*
     *
     * Get value at index
     *
     * */
    public int getValueAtIndex(int index) {
        if (index < arraySize)
            return theArray[index];

        return 0;
    }

    /*
     *
     * Check if the Array Contains a given value
     *
     * */
    public boolean doesArrayContainThisValue(int value) {
        for (int i = 0; i < arraySize; i++) {
            if (value == theArray[i]) {
                return true;
            }
        }
        return false;
    }

    /*
     *
     * Delete the array element at the given index
     *
     * */
    public void deleteIndex(int index) {
        if (index < arraySize) {
            for (int i = index; i < arraySize - 1; i++) {
                theArray[i] = theArray[i + 1];
            }
            arraySize--;
        }
    }

    /*
     *
     * Insert a value at a given index.
     *
     * Replaces the value at that index, if value already present
     *
     * */
    public void insertValueAtIndex(int value, int index) {
        if (arraySize < 50 && index < arraySize) {
            theArray[index] = value;
        }
    }

    /*
     *
     * Insert a value.
     *
     * Value gets added at a position higher than the arraySize
     *
     * */
    public void insertValue(int value) {
        if (arraySize < 50) {
            theArray[arraySize] = value;
            arraySize++;
        }
    }


    /*
     *
     * Linear Search
     *
     * Time Complexity: O(N^2)
     * Space Complexity: O(M) -- where M is the arraySize
     *
     * */

    public String linearSearchForValue(int value) {
        String indexWithValue = "";
        boolean found = false;
        for(int i= 0; i < arraySize; i++){
            if(theArray[i] == value){
                found = true;
                indexWithValue += i + " ";
            }
            printHorizontalArray(i, -1);
        }

        if(!found){
            indexWithValue = "None";
        }
        System.out.println("The value was found in the following: " + indexWithValue);
        System.out.println();

        return indexWithValue;
    }

    /*
    *
    * BUBBLE SORT (ALSO KNOWN AS SINKING SORT)
    *
    *  - Sort smallest to largest or vice versa
    *  - Swaps indexes next to each other. It does a Pair Wise sort
    *
    *
    * Time Complexity: O(N^2)
    * Space Complexity: O(N)
    *
    * */
    public void bubbleSort(){
        for(int i = arraySize -1; i > 1; i--){
            for(int j = 0; j < i; j++){
                // Use < to change it to Descending order
                if(theArray[j] > theArray[j+1]){
                    swapValues(j, j+1);
                    printHorizontalArray(i, j);
                }
                printHorizontalArray(i, j);
            }
        }
    }

    /*
    *
    * BINARY SEARCH
    *
    *  - It is quicker than linear search. Since the values are all sorted.
    *  - Since the Values are all sorted, once you find the value you are searching for, we can then stop the search.
    *  - It does not work well with duplicate number, because it is going to find the first match.
    *
    *
    * */
    public void binarySearchForValue(int value){
        int lowIndex = 0;
        int highIndex = arraySize -1;

        while(lowIndex <= highIndex){
            int middleIndex = (lowIndex + highIndex)/2;

            if(theArray[middleIndex] < value){
                lowIndex = middleIndex + 1;
            } else if(theArray[middleIndex] > value) {
                highIndex = middleIndex -1;
            } else {
                System.out.println("Found a match for " + value + " at Index " + middleIndex);
                // Exit the while loop.
                lowIndex = highIndex + 1;
            }

            printHorizontalArray(middleIndex, -1);
        }
    }

    /*
    *
    * SELECTION SORT
    *
    * - Save a number in a minimum spot, as it finds it and then repeat searching through the entire array
    *   each time to slowly put the whole entire array in order.
    *
    * - Start from index 0 and compares it with the rest of the numbers in the list.
    *   If it finds the number less than the number at current index, it swaps those 2 numbers.
    *   Then, it continues to move on to the next index, and compares it with the rest of the numbers in the list.
    *   This process continues for each index.
    *
    *   Summary:
    *
    *   - Get the element at index starting at 0.
    *   - Compare with rest of the numbers in list
    *   - If less than the current number, swap those 2 numbers.
    *   - If the lesser number not found in the loop, then move to next index and continue with next iteration.
    *   - Continue this iterations until the end of the for loops.
    *
    *
    *
    * */
    public  void selectionSort(){
        for(int x=0; x < arraySize; x++){
            int minimum = x;
            for(int y = x; y < arraySize; y++){
                // Change to < for descending sort
                if(theArray[minimum] > theArray[y]){
                    minimum = y;
                }
            }
            swapValues(x, minimum);
            printHorizontalArray(x, -1);
        }
    }

    /*
    *
    * INSERTION SORT
    *
    * */
    public void insertionSort(){
        for(int i =1; i < arraySize; i++){
            int j = i;
            int toInsert = theArray[i];
            while(j > 0 && theArray[j-1] > toInsert){
                theArray[j] = theArray[j-1];
                j--;
            }
            theArray[j] = toInsert;
            printHorizontalArray(i, j);
            System.out.println("\n Array[i] = " + theArray[i] + " Array[j] = " + theArray[j] + " toInsert = " + toInsert);
        }
    }

    /*
    *
    * QUICK SORT
    *
    * */
    public void quickSort(){

    }


    /*
    * Swap 2 values
    *
    * */
    public void swapValues(int indexOne, int indexTwo){
        int temp = theArray[indexOne];
        theArray[indexOne] = theArray[indexTwo];
        theArray[indexTwo] = temp;
    }


    public static void main(String[] args){
        Sorting sorting = new Sorting();
        sorting.generateRandomArray();
//        sorting.printHorizontalArray(-1,-1);

//        System.out.println("Linear Search");
//        System.out.println(sorting.linearSearchForValue(10));

//        System.out.println("Bubble Sort");
//        sorting.bubbleSort();
//        System.out.println();

        // THE INPUT ARRAY FOR THE BINARY SEARCH NEEDS TO BE SORTED. SO, WE NEED TO EXECUTE BUBBLE SORT FIRST.
        System.out.println("THE INPUT ARRAY FOR THE BINARY SEARCH NEEDS TO BE SORTED. SO, WE NEED TO EXECUTE BUBBLE SORT FIRST.");
        System.out.println("Binary Search for 11");
        sorting.binarySearchForValue(11);
        System.out.println();

//        System.out.println("SELECTION SORT");
//        sorting.selectionSort();

        System.out.println("INSERTION SORT");
        sorting.insertionSort();

    }


}
