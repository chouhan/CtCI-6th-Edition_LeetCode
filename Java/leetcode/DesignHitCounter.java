// You are building a website and write an algorithm to count the number of visitors for the past 5 min.

// implement this interface
// void newVisitor()
// int countVisitorsLast5mins()

import java.util.HashMap;
import java.util.Map;

interface Visitor{
    String firstName = null;
    String lastName = null;
    int age = -1;
    Long currentTime = 1L;
}

public class DesignHitCounter{

    public Map<Long, Visitor> listOfVisitors = new HashMap<Long, Visitor>();
    public int totalVisitorCount = 0;
    public int lastFiveMins = 5*60*1000; // 300000 milliseconds


    public class NewVisitor implements Visitor{

        private String firstName;
        private String lastName;
        private int age;
        private Long currentTime;
        //private int count = 0;

        NewVisitor(String firstName, String lastName, int age, Long currentTime){
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
            this.currentTime = System.currentTimeMillis();
            //count++;
            //listOfVisitors(this);
        }

        NewVisitor(){}

    }

    public int countVisitorsLast5mins(){
        Long currentTime = System.currentTimeMillis();
        int last5MinsVisitorCount = 0;

        //for(currentTime; lastFiveMins < currentTime; currentTime-- ){

        Long differenceTime = currentTime - lastFiveMins;

        while(differenceTime < currentTime){

            if(listOfVisitors.containsKey(differenceTime)){
                // If found, increment the last5MinsVisitorCount.
                last5MinsVisitorCount++;

                //clear up the HashMap, with lot of visitors being accumulated and decrement the currentTime
                listOfVisitors.remove(differenceTime--);

            }
            // Increment the differenceTime, so as to exit the while loop
            differenceTime++;
        }

        return last5MinsVisitorCount;
    }



    public void newVisitor(){
        // Stream of visitors placing in HashMap
        //for(int i=0; i < (Math.random() * 10 ); i++){

        //}

        /* Store the current time as key and newVistor as object pair in HashMap */

        NewVisitor newVisitor = new NewVisitor("Rakesh", "Chouhan", 32, System.currentTimeMillis());
        if(!listOfVisitors.containsKey(newVisitor.currentTime)){
            listOfVisitors.put(newVisitor.currentTime, newVisitor);
        }else{
            // Update the Old visitor
            NewVisitor visitor = (NewVisitor) listOfVisitors.get(newVisitor.currentTime);
            visitor.currentTime = newVisitor.currentTime + 1;
	        listOfVisitors.put(newVisitor.currentTime,  visitor);
        }

        /* Each time a visitor gets added, increment the visitorCount */
        totalVisitorCount++;
    }

    public static void main(String[] args){
        DesignHitCounter sol = new DesignHitCounter();

        for(int i=0; i < 600000; i++){
            if(i == 300000){
                System.out.println("Number of Visitors in the last 5 mins is " + sol.countVisitorsLast5mins());
            }
            sol.newVisitor();
        }
        System.out.println("\nTotal Visitors is " + sol.totalVisitorCount);
        System.out.println("\nTotal Visitors - Map size is " + sol.listOfVisitors.size());
    }

}