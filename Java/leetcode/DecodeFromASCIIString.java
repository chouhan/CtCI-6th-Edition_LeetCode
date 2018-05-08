import java.util.stream.IntStream;

/*
* decode-all-possibilities-from-a-given-encoded-ascii-string
*
* //	We encode a string, s, by performing the following sequence of actions:
//	Replace each character with its ASCII value representation.
//	Reverse the string.
//
//	For example, the table below shows the conversion from the string "Go VMWare" to the ASCII string "711113286778797114101":
//
//	Character	G	o	V	M	W	a r e
//	ASCII Value	71 111 32 86 77 87 97 114 101
//
//	We then reverse the ASCII string to get the encoded string 101411797877682311117.
//	For reference, the characters in s are ASCII characters within the range 10 - 126 which include special characters.
//	Complete the decode function in the editor below. It has one parameter:
//	encoded	- A reversed ASCII string denoting an encoded string s.
//	The function must decode the encoded string and return the list of ways in which s can be decoded.
*
*
*
* */
public class DecodeFromASCIIString {
    public int decode(String enc, int[] asciiChars) {
        /* Base Cases */
        if (enc.length() < 3) {
            /* PRINTS OUT A POSSIBLE CHAR ARRANGEMENT */
            for (int k = 0; k < asciiChars.length; k++) {
                System.out.printf("(%3d)", asciiChars[k]);
            }
            System.out.printf("\n");
            /* End */

            if (enc.length() == 2)
                return 1;
            if (enc.length() == 1)
                return 0;
            if (enc.length() == 0)
                return 1;
        }

        /* Obtain first two or three digits */
        int ascii2, ascii3;
        ascii2 = Integer.parseInt(enc.substring(0, 2));
        ascii3 = Integer.parseInt(enc.substring(0, 3));

        /* Recursive cases */
        int recurs2 = 0;
        int recurs3 = 0;
        if (ascii2 >= 10 && ascii2 <= 99) {
            int[] asciiChar2 = concat(asciiChars, ascii2);
            recurs2 = decode(enc.substring(2,enc.length()), asciiChar2);
        }
        if (ascii3 >= 100 && ascii3 <= 126) {
            int[] asciiChar3 = concat(asciiChars, ascii3);
            recurs3 = decode(enc.substring(3,enc.length()), asciiChar3);
        }
        return recurs2 + recurs3;
    }

    public int[] concat(int[] asciiChars, int newChar) {
        // Initialize new array with combined size of the two input arrays
        int[] asciiChar1 = new int[asciiChars.length + 1];

        // Keep index counter for concatenated array, increment each time
        // when you put each element into the concatenation
        int index = 0;
        for (int k = 0; k < asciiChars.length; k++) { // First, from str1
            asciiChar1[index] = asciiChars[k];
            index++;
        }
        asciiChar1[index] = newChar;

        return asciiChar1;
    }

    public static void main(String[] args){
        DecodeFromASCIIString decodeFromASCIIString = new DecodeFromASCIIString();
        int[] asciiChars = IntStream.rangeClosed(0, 127).toArray();
        System.out.println(decodeFromASCIIString.decode("HelloWorld", asciiChars));
        System.out.println(decodeFromASCIIString.decode("Rakesh", asciiChars));
    }
}
