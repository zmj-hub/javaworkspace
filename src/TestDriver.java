import java.util.*;
import java.util.stream.Collectors;

public class TestDriver {
    public static void main(String[] args) {
//        Map map = new HashMap();
/*
        domin.Student student1 = new domin.Student("aa","a",12);
        domin.Student student2 = new domin.Student("bb","b",22);
        domin.Student student3 = new domin.Student("cc","b",42);
        domin.Student student4 = new domin.Student("dd","a",22);
        List<domin.Student> studentList = new ArrayList<>();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        String name=studentList.stream().map(domin.Student::getName1).collect(Collectors.joining());
        System.out.println(name);*/

//        Optional<domin.Student> optional = studentList.stream(temp -> temp.getSex()).findAny();

//        System.out.println(optional.get());

        Scanner scanner = new Scanner(System.in);
//        int i=scanner.nextInt();
  /*      int a=1;
        int b =2;
        assert a>b;
        System.out.println("qqqq");*/
//        System.out.println(Math.random()*9+1);

        HashMap hashMap=new HashMap();

        List<String> list1 = Arrays.asList("文学","小说","历史","言情","科幻","悬疑");

        List<String> list2 = Arrays.asList("文学","小说","历史","言情","科幻","悬疑");

        //方案一：使用String.join()函数，给函数传递一个分隔符合一个迭代器，一个StringJoiner对象会帮助我们完成所有的事情
        String string1 = String.join("-",list1);

        System.out.println(string1);

        //方案二：采用流的方式来写
        String string2 = list2.stream().collect(Collectors.joining("-"));

        System.out.println(string2);

        List<String> list3=new ArrayList<>(list1);

        list3.addAll(list2);
        String string3 = String.join(",",list3);
        System.out.println(string3);
    }
}
