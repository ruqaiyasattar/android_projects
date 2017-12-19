package httpdemo.dell.example.com.demosqlite.recyclerv;

/**
 * Created by DELL on 11/9/2017.
 */

public class student {
    String name;
    int age;
    String course;
    int id;

    public student(String name, int age, String course, int id) {
        this.name = name;
        this.age = age;
        this.course = course;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", course='" + course + '\'' +
                ", id=" + id +
                '}';
    }
}
