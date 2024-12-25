package part_04.functional_programming;

public class Student{
    private String name;

    private int age;

    private double grace;

    public Student() {
    }

    public Student(String name, int age, double grace) {
        this.name = name;
        this.age = age;
        this.grace = grace;
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

    public double getGrace() {
        return grace;
    }

    public void setGrace(double grace) {
        this.grace = grace;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grace=" + grace +
                '}';
    }

//    @Override
//    public int compareTo(Student o) {
//        if(this.getGrace() > o.getGrace()){
//            return 1;
//        } else if(this.getGrace() == o.getGrace()){
//            return 0;
//        }
//        return -1;
//    }
}
