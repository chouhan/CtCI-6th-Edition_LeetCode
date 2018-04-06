import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] strArray = str.split(" ");
        char[] patternArray = pattern.toCharArray();

        if(strArray.length != patternArray.length){
            return false;
        }

        Map<String, Integer> bucket = new HashMap<String, Integer>();

        for(int i=0; i < strArray.length; i++){
            if(!Objects.equals(bucket.put(Character.toString(patternArray[i]), i), (bucket.put(strArray[i], i)))){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("abba", "dog cat cat dog"));
    }
}
