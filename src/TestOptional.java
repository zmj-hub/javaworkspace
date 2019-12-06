import domin.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import	java.util.Iterator;

public class TestOptional {
    public static void main(String[] args) {
        Student student = new Student();
        student.setName1("张三");
        student.setAge(22);
        student.setSex("男");
        test(student);
    }

    public static void test(Student student) {
        /*Optional optional1 = Optional.empty();
        System.out.println(optional1.get());
        Optional optional2 = Optional.of("qqq");
        System.out.println(optional2.get());
        Optional optional3 = Optional.ofNullable(null);
        System.out.println(optional3.get());*/
        Optional.ofNullable(student).ifPresent(u -> System.out.println("我是" + u.getName1()));
        Optional.ofNullable(student).filter(u -> u.getAge() > 18).ifPresent(u -> System.out.println("我是" + u.getName1()));
//        Optional.ofNullable(student).map(u->u.getName1()).orElse("aaa");
        Student student1 = new Student("aa","a",12);
        Student student2 = new Student("bb","b",22);
        Student student3 = new Student("cc","b",42);
        Student student4 = new Student("dd","a",22);
        List<Student> studentList = new ArrayList<>();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        Iterator iterator=studentList.iterator();
        while (iterator.hasNext()){
            Student student5=(Student) iterator.next();
            System.out.println("我是"+student5.getName1());
        }

//        studentList.stream().filter(u->u.getAge()>18).map(domin.Student::getName1).forEach(s -> System.out.println(s));

    }
}
