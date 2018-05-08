
/**
 *
 * https://stackoverflow.com/questions/5263187/print-an-integer-in-binary-format-in-java
 *
 * Converts an integer to a 32-bit binary string
 * @param //number
 *      The number to convert
 * @param //groupSize
 *      The number of bits in a group
 * @return
 *      The 32-bit long bit string
 *
 *
 *      https://www.rapidtables.com/convert/number/how-decimal-to-binary.html
 *
 *      Conversion steps:
            Divide the number by 2.
            Get the integer quotient for the next iteration.
            Get the remainder for the binary digit.
            Repeat the steps until the quotient is equal to 0.
 */
public class IntegerToBinary {

    public String intToString(int number, int groupSize){
        StringBuilder sb = new StringBuilder();

        for(int i =31; i>= 0; i--){
            int mask = 1 << i;
            String signBit = (number & mask) != 0 ? "1" : "0";
            sb.append(signBit);

            if(i % groupSize == 0){
                sb.append(" ");
            }
        }
        sb.replace(sb.length() -1, sb.length(), "");

        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(new IntegerToBinary().intToString(5463, 4));
    }

}
