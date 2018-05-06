public class StringToIntegerATOI {
    public int myAtoi(String str) {
        int i = 0;
        int result;
        StringBuffer sb = new StringBuffer();
        char[] charArray = str.toCharArray();
        boolean isNegativeNumber = hasNegativeSign(charArray[0]);
        if(str == null){
            return 0;
        } else if(!isNumber(charArray[0]) && !isNegativeNumber){
            return 0;
        } else {
            if(isNegativeNumber){
                i = 1;
            }
            while(i < charArray.length && isNumber(charArray[i])){
                sb.append(charArray[i]);
                i++;
            }
        }

        if(sb.toString().length() == 0)
            return 0;
        else {
            char[] sbArray = sb.toString().toCharArray();
            Long ret = 0L;
            for(int j = 0; j < sbArray.length; j++){
                // ASCII code for '0' is 48 and '9' is 57. So numbers from 0 till 9 are in sequence.
                // So ASCII for '4' is 52 and '0' is 48. So 52-48 = 4.
                // This converts a character '4' to integer 4.
                ret += (int)(sbArray[j] - '0');

                // If the index is not the last character, then multiply the integer with 10. So 4 * 10 = 40
                if (j != sb.length()-1){
                    ret *= 10;
                }
                // We need to return only in the int max min limit.
                if (ret > Integer.MAX_VALUE) {
                    return isNegativeNumber ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
            }
            return isNegativeNumber ? ret.intValue() * -1 : ret.intValue() * 1;
        }
    }

    public boolean hasNegativeSign(char sign){
        if(sign == '+'){
            return false;
        } else if(sign == '-') {
            return true;
        } else {
            return false;
        }
    }

    public boolean isNumber(char letter){
        if(Character.isDigit(letter)){
            return true;
        }
        return false;
    }

    public static void main(String[] args){
        StringToIntegerATOI stringToIntegerATOI = new StringToIntegerATOI();
        System.out.println(stringToIntegerATOI.myAtoi("-9234824682346"));
    }
}
