public class RotateString {

    public static boolean rotateString(String A, String B) {

        if(A.equals(B))
            return true;

        if(A.length() != B.length())
            return false;

        int i= 0;
        while(i < A.length()) {
            String newA = A.substring(1) + A.charAt(0);

            if(newA.equals(B))
                return true;

            i++;
            A = newA;
        }

        return false;
    }

    public static void main(String[] args){
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString("abcde", "fghij"));
    }
}
