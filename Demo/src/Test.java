import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Test {

    public static void main(String[] args) throws ParseException {

        String input = "11/18/2023";


        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date myDate = dateFormat.parse(input);
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(myDate);
        cal1.add(Calendar.DAY_OF_YEAR, -1);
        Date newDate = cal1.getTime();


        String todayAsString = dateFormat.format(newDate);


        System.out.println(todayAsString);

        System.out.println(2/10);
        System.out.println(25/10);


    }
}
