public class LongestPalindromicSubSequence {

    public static int getLPS(String s){
        char[] charArray = s.toCharArray();

        int T[][] = new int[s.length()][s.length()];

        for(int i=0; i < s.length(); i++){
            T[i][i] = 1;
        }

        for(int charLength = 2; charLength <= s.length(); charLength++){

            for(int i = 0; i < s.length() - charLength + 1; i++){

                int j = i + charLength - 1;
                if(charLength == 2 && charArray[i] == charArray[j]){
                    T[i][j] = 2;
                }else if(charArray[i] == charArray[j]){
                    T[i][j] = T[i + 1][j-1] + 2;
                }else{
                    T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
                }
            }
        }

        return T[0][s.length() -1];
    }

    public static void main(String args[]){
        System.out.println(getLPS("abdradba"));
    }
}