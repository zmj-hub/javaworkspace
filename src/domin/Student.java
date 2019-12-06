package domin;

import java.io.Serializable;

public class Student implements Serializable {
    private String name1;
    //    private String name2;
    private String sex;
    private Integer age;

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public Student(String name1, String sex, Integer age) {
        this.name1 = name1;
        this.sex = sex;
        this.age = age;
    }

//    public domin.Student(String name1, String name2, String sex, Integer age) {
//        this.name1 = name1;
//        this.name2 = name2;
//        this.sex = sex;
//        this.age = age;
//    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student() {
    }

//    public domin.Student(String name1, String name2) {
//        this.name1 = name1;
//        this.name2 = name2;
//    }
//
//    public String getName1() {
//        return name1;
//    }
//
//    public void setName1(String name1) {
//        this.name1 = name1;
//    }
//
//    public String getName2() {
//        return name2;
//    }
//
//    public void setName2(String name2) {
//        this.name2 = name2;
//    }
//
//    @Override
//    public String toString() {
//        return "domin.Student{" +
//                "name1='" + name1 + '\'' +
//                ", name2='" + name2 + '\'' +
//                '}';
//    }

    @Override
    public String toString() {
        return "domin.Student{" +
                "name1='" + name1 + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                '}';
    }
}
