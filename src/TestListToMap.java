import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class TestListToMap {
    public static void main(String[] args) {
        test();
    }

    public static void test() {
        Student student1 = new Student("aa", "a", 12);
        Student student2 = new Student("bb", "b", 22);
        Student student3 = new Student("cc", "b", 42);
        Student student4 = new Student("aa", "a", 22);
        List<Student> studentList = new ArrayList<>();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        Map<String, List<Student>> map = studentList.stream().collect(Collectors.toMap(Student::getName1, s -> {
                    List<Student> list = new ArrayList<>();
                    list.add(s);
                    return list;
                },
                (List<Student> value1, List<Student> value2) -> {
                    value1.addAll(value2);
                    return value1;
                }));
        map.forEach((key, value) -> {
            System.out.println(key + "     " + value.toString());
        });
    }
}
