public class IsomorphicStrings {

    public boolean isIsomorphic(String s, String t){
        int[] m1 = new int[256];
        int[] m2 = new int[256];

        for(int i =0; i < s.length(); i++){
            /*if(i < s.length()-1 && s.charAt(i) == s.charAt(i+1)){
                return false;
            }*/

            if(m1[s.charAt(i)] != m2[t.charAt(i)])
                return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }

    public static void main(String[] args){
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        // "egg", "add" -- return true
        // "foo", "bar" -- return false
        // "paper", "title" -- return true
        // "fos", "bas" -- return true
        // "sos", "sas" -- return true
        // "sss", "sas" -- return false
        System.out.println(isomorphicStrings.isIsomorphic("egg", "add"));
    }
}
