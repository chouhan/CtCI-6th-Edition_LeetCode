import java.util.Random;

/*
* Generate Random 7 from Random 5
*
*
* */
public class Random7FromRandom5 {

    private static int min = 0;
    private static int max = 4;

    /*
    *
    * Generate Random 5
    *
    * @returns int - Any random number between 0 and 4
    *
    * */
    public int random5(){
        Random random = new Random();

        int random5 = random.nextInt((max - min) + 1) + min;
        return random5;
    }

    /*
    *
    * Generate Random 7 using Random 5
    *
    * This does not generate random7 with equal probability
    *
    * */
    public int random7(){
        // Sum 2 times of random5
        int random = random5() + random5();
        return random % 7;
    }

    /*
    *
    * Generate Random7 using Random5 with equal probability
    *
    *
    * */
    public int random7WithEqualProbable(){
        int random = 5 * random5() * random5();
        while(true){
            if(random < 21){
                return random % 7;
            }
        }
    }


    public static void main(String[] args){

        Random7FromRandom5 random7FromRandom5 = new Random7FromRandom5();

        System.out.println("Random 5 is " + random7FromRandom5.random5());

        for(int i=0; i<10; i++){
            System.out.println("Random 7 without equal probability is " + random7FromRandom5.random7());
            System.out.println("Random 7 with equal probability is " + random7FromRandom5.random7WithEqualProbable());
        }

    }
}
