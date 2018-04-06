public class ReverseInt {
    public static int reverse(int x) {
        if(Integer.toString(x).length() == 1){
            return x;
        }
        if(x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE){
            return 0;
        }
        int input = x > 0 ? x : Math.abs(x);
        boolean isInputPositive = x > 0;
        char[] intArray = Integer.toString(input).toCharArray();
        int rightIndex = intArray.length - 1;
        char temp;
        for(int i=0; i <= rightIndex -1; i++){
            temp = intArray[i];
            intArray[i] = intArray[rightIndex];
            intArray[rightIndex--] = temp;
        }
        // return isInputNegative ? Integer.parseInt(new String(intArray)) : -Integer.parseInt(new String(intArray));

        try{
            // return Integer.parseInt(new String(intArray));
            return isInputPositive ? Integer.parseInt(new String(intArray)) : -Integer.parseInt(new String(intArray));
        } catch(NumberFormatException e){
            if(Long.parseLong(new String(intArray)) > Integer.MAX_VALUE){
                return 0;
            }
            return -1;
        }

    }

    public static void main(String args[]){
        System.out.println(reverse(-214748364));
    }

}
