import domin.Student;

public class Main {

    public static void main(String[] args) {
//        HashMap hashMap=new HashMap();
//        domin.Student student=new domin.Student("123","643543");
//        System.out.println(student.toString());
//        ObjectOutputStream outputStream;
//        ObjectInputStream inputStream;
//        String path="C://zmj//123.txt";
//        try {
//            outputStream =new  ObjectOutputStream(new FileOutputStream(path));
//            outputStream.writeObject(student);
//            inputStream=new ObjectInputStream(new FileInputStream(path));
//            domin.Student student1= (domin.Student) inputStream.readObject();
//           System.out.println(student1.toString());
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        String string1="1,2,6,7,32,15,9";
//        String[] strings= string1.split(",");
//        Arrays.stream(strings).forEach(s -> System.out.print(s+" "));
//        System.out.println(strings);
        int a=1;
        int b=2;
//        fun(a,b);
        String s1="123";
        String s2="234";
        fun(s1,s2);
        System.out.println(s1);
        System.out.println(s2);
        Student student1=new Student();
        Student student2=new Student();
    }
    public static void fun(String s1,String s2){
        s1=s2;
        System.out.println(s1);
        System.out.println(s2);
    }

}
