package SetExer;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest {

    @Test
    public void test1(){
        MyDate m1 = new MyDate(1999, 2, 16);
        Employee e1 = new Employee("Jack", 24, m1);
        MyDate m2 = new MyDate(1967, 4, 11);
        Employee e2 = new Employee("Tom", 56, m2);
        MyDate m3 = new MyDate(1974, 12, 12);
        Employee e3 = new Employee("John", 49, m3);
        MyDate m4 = new MyDate(1999, 5,27);
        Employee e4 = new Employee("Mary", 24, m4);
        MyDate m5 = new MyDate(2003, 7, 15);
        Employee e5 = new Employee("Martin", 20, m5);
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee) o1;
                    Employee e2 = (Employee) o2;
                    int y1 = e1.getBirthDay().getYear();
                    int y2 = e2.getBirthDay().getYear();
                    if(Integer.compare(y1, y2) == 0){
                        int m1 = e1.getBirthDay().getMonth();
                        int m2 = e2.getBirthDay().getMonth();
                        if(Integer.compare(m1, m2) == 0){
                            int d1 = e1.getBirthDay().getDay();
                            int d2 = e2.getBirthDay().getDay();
                            return Integer.compare(d1, d2);
                        }
                        else{
                            return Integer.compare(m1, m2);
                        }
                    }
                    else{
                        return Integer.compare(y1, y2);
                    }
                }
                else{
                    throw new RuntimeException("输入的数据类型不匹配");
                }
            }
        };
        TreeSet set = new TreeSet<>(com);
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);
        System.out.println(set);
    }

}
