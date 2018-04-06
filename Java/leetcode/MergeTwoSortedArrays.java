public class MergeTwoSortedArrays {
    public static void mergeArrays(int array1[], int array2[]){
        int i = array1.length - 1, j = array2.length - 1, k = array1.length + array2.length - 1;

        while(i >= 0 && j >= 0){
            array1[k--] = array1[i] > array2[j] ? array1[i--] : array2[j--];
        }
        while(j >= 0){
            array1[k--] = array2[j--];
        }
        System.out.println(array1.toString());
    }

    /*public MergeTwoSortedArrays(){
        MergeTwoSortedArrays mergeTwoSortedArrays = new MergeTwoSortedArrays();
        mergeTwoSortedArrays.mergeArrays(new int[]{3, 2, 1, 6}, new int[]{5, 9, 4, 7});
    }*/

    public static void main(String args[]){
        int[] a = new int[]{3, 2, 1, 6};
        int[] b = new int[]{5, 9, 4, 7};
        mergeArrays(a, b);
    }
}
