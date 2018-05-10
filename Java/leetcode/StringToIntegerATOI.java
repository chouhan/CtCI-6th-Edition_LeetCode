
/*
*
* https://leetcode.com/problems/string-to-integer-atoi/description/
*
* Implement atoi which converts a string to an integer.

    The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
    Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as
    possible, and interprets them as a numerical value.

    The string can contain additional characters after those that form the integral number, which are ignored and have no
    effect on the behavior of this function.

    If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either
    str is empty or it contains only whitespace characters, no conversion is performed.

    If no valid conversion could be performed, a zero value is returned.

    Note:

    Only the space character ' ' is considered as whitespace character.
    Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1].
    If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
*
* */
public class StringToIntegerATOI {
    public int myAtoi(String str) {

        str = str.trim();
        if(str == null || str == ""){
            return 0;
        }

        int i = 0;
        StringBuffer sb = new StringBuffer();
        char[] charArray = str.toCharArray();

        boolean isNegativeNumber = hasNegativeSign(charArray[0]);
        if(!isNumber(charArray[0]) && !hasSign(charArray[0])){
            return 0;
        } else {
            if(isNegativeNumber){
                i = 1;
            } else if(hasSign(charArray[0])){
                i = 1;
            } else {

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

                // If the index is not the last character, then multiply the integer with 10 from left to right. So 4 * 10 = 40
                // For 543 - 1st iteration ==> 5 * 10 ==> 50 + 4 = 54 ==> 54 * 10 ==> 540 + 3 ==> 543 (since 3 was not the last last character, 3 was not * by 10)
                if (j != sb.length()-1){
                    ret *= 10;
                }
                // We need to return only in the int max min limit.
                if (ret > Integer.MAX_VALUE) {
                    return isNegativeNumber ? Integer.MAX_VALUE * -1 : Integer.MAX_VALUE;
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

    public boolean hasSign(char sign){
        if(sign == '+'){
            return true;
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
        System.out.println(stringToIntegerATOI.myAtoi("+1"));
    }

    /*
    *
    * 36 ms runtime
    *
    * public int myAtoi(String str) {
        int i = 0, sign = 1, r = 0;
        int n = str.length();
        if (n == 0) return 0;

        while (i < n && str.charAt(i) == ' ') {
            i++;
        }

        if (str.charAt(i) == '+' || str.charAt(i) == '-') {
            sign = str.charAt(i) == '+' ? 1 : -1;
            i++;
        }

        while (i < n) {
            int num = str.charAt(i) - '0';
            if (num < 0 || num > 9) break;

            if (r > Integer.MAX_VALUE / 10 || Integer.MAX_VALUE / 10 == r && Integer.MAX_VALUE % 10 < num) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            r = 10 * r + num;
            i++;

        }

        return sign * r;
    }*/
}
