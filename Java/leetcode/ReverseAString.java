public class ReverseAString {
    public static String reverseString(String s) {
        // Edge Cases -
        // Wrap it in try catch in case of any errors
        // What if input has a Special character or has special characters or ASCII characters?

        if(null == s || s.length() <=1){
            return s;
        }
        char[] charArray = s.toCharArray();
        char temp;
        int rightIndex = charArray.length - 1;
        for(int i=0; i <= rightIndex - 1; i++){
            temp = charArray[i];
            charArray[i] = charArray[rightIndex];
            charArray[rightIndex--] = temp;
        }

        return new String(charArray);
    }

    public static void main(String[] args){
        System.out.println(reverseString("a."));
    }
}
