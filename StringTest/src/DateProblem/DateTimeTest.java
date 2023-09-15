package DateProblem;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeTest {

    //Date日期类小练习
    @Test
    public void Test1() throws ParseException {
        String startTime = "1990-01-01";
        String endTime = "2020-09-08";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = sdf.parse(startTime);
        Date d2 = sdf.parse(endTime);
        long d = (d2.getTime() - d1.getTime()) / 1000;
        long day = d / (24 * 60 * 60);
        //System.out.println(day);
        long whichDay = (day + 1) % 5;
        if(whichDay <= 3 && whichDay >= 1){
            System.out.println("今天打渔");
        }else {
            System.out.println("今天晒网");
        }
    }
}
