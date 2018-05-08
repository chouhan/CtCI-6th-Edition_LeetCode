import java.util.*;

/*
*
* Provide a hash function for variable length strings
*
* */
public class BucketTest {

  static Random gen = new Random(System.currentTimeMillis());
  static int MAX_LENGTH = 64;

  public static void main(String[] args) {

    int[] buckets = new int[10/*Integer.parseInt(args[0])*/];
    List<String> keys = new ArrayList<String>();

    for(int i=0; i < 100000; i++) {
      keys.add(randomString());
    }

    for(String key : keys) {
      int hash = key.hashCode();
      int index = Math.abs(hash % buckets.length);

      buckets[index] = buckets[index] + 1;
    }

    long sum = 0;
    for(int i=0; i < buckets.length; i++) {
      sum += buckets[i];
      System.out.println("Bucket " + i + ": " + buckets[i]);
    }

    double mean = (double)sum / (double)buckets.length;

    System.out.println("Mean: " + mean);

    double variance = 0;
    for(int i=0; i < buckets.length; i++) {
      variance += Math.pow((double)buckets[i] - mean, 2.0);
    }
    double std = Math.sqrt(variance / (double)buckets.length);
    System.out.println("Standard Deviation: " + std);
  }

  public static String randomString() {
    StringBuilder sb = new StringBuilder();
    int len = gen.nextInt(MAX_LENGTH);

    char tmp;
    for(int i=0; i < len; i++) {
      tmp = (char)(gen.nextInt(96) + 32);
      sb.append(tmp);
    }
    return sb.toString();
  }
}