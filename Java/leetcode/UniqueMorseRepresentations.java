import java.util.HashMap;
import java.util.Map;

class UniqueMorseRepresentations {
    public int uniqueMorseRepresentations(String[] words) {
        
        if(words.length > 100) {
            return -1;
        }
        
        
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        
        Map<String, String> morseCodeCharMap = new HashMap<String, String>();
        
        char ch = 'a';
        int morseCodeCount = 0;
        while(ch <= 'z'){
            morseCodeCharMap.put(String.valueOf(ch), morseCode[morseCodeCount]);
            ch++;
            morseCodeCount++;
        }
        
        Map<String, String> map = new HashMap<String, String>();
        
        int i = 0;
        String wordLC;
        while(i < words.length){
            if(words[i].length() > 12 || words[i].length() < 1){
                return -1;
            }
            wordLC = words[i].toLowerCase();
            
            // Now split the wordLC into charArray and get each morseCode associated to it.
            
            char[] wordLCCharArray = wordLC.toCharArray();
            String morseCodeForWordLC = "";
            
            for(int j=0; j < wordLCCharArray.length; j++){
                morseCodeForWordLC += morseCodeCharMap.get(String.valueOf(wordLCCharArray[j]));
            }
            
            if(!map.containsValue(morseCodeForWordLC)){
                map.put(wordLC, morseCodeForWordLC);
            }
            i++;
        }

        System.out.println(map.size());
        return map.size();
        
    }

    public static void main(String[] args){
        String[] words = {"gin", "zen", "gig", "msg"};
        UniqueMorseRepresentations uniqueMorseRepresentations = new UniqueMorseRepresentations();
        uniqueMorseRepresentations.uniqueMorseRepresentations(words);
    }
}