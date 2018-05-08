import java.util.Calendar;
import java.util.GregorianCalendar;

/*
*
* Implement live digital clock in console window, hint: use threads and refer MSDN
*
* */
public class DigitalClockOnConsoleWindow {
    public static void main(String[] args) {
        /*Thread th = new Thread(new Runnable()
        {
            public void run()
            {
                while(true)
                {
                    Date date = Calendar.getInstance().getTime();
                    DateFormat formatter = new SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm:ss.SSS a");
                    String today = formatter.format(date);
                    System.out.print("Today : " + today+"\r");
                    try{
                    Thread.sleep(100);}catch(Exception ex){}
                }
            }
        });
        th.start();*/

        new Thread(new Runnable() {

            @Override
            public void run() {

                while (true){

                    Calendar cal = new GregorianCalendar();
                    int hour = cal.get(Calendar.HOUR);
                    int minute = cal.get(Calendar.MINUTE);
                    int seconds = cal.get(Calendar.SECOND);
                    String realTime = Integer.toString(hour) + " : " + Integer.toString(minute) + " : " + Integer.toString(seconds);

                    System.out.println(realTime);

                    try {

                        Thread.sleep(1000);
                    } catch (Exception ex) {
                        ex.getStackTrace();
                    }
                }
            }
        }).start();
    }
}