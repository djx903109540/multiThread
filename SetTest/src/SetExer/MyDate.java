package SetExer;

public class MyDate {

    //年
    private int year;
    //月
    private int month;
    //日
    private int day;

    MyDate(){}

    MyDate(int y, int m, int d){
        this.year = y;
        this.month = m;
        this.day = d;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    @Override
    public String toString() {
        String s = year + "年" + month + "月" + day + "日";
        return s;
    }
}
