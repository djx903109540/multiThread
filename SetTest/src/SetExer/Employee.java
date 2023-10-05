package SetExer;

public class Employee implements Comparable{

    //姓名
    private String name;
    //年龄
    private int age;
    //生日
    private MyDate birthDay;

    Employee(){}

    Employee(String name, int age, MyDate md){
        this.name = name;
        this.age = age;
        this.birthDay = md;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public MyDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(MyDate birthDay) {
        this.birthDay = birthDay;
    }

    @Override
    public String toString() {
        String s = "姓名：" + name + "，年龄： " + age + "，生日：" + birthDay;
        return s;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Employee){
            Employee e = (Employee) o;
            return this.name.compareTo(e.name);
        }
        else{
            throw new RuntimeException("输入的数据类型不匹配");
        }
    }
}
