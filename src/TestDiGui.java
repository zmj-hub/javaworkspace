import domin.Student;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class TestDiGui {
    public static void main(String[] args) {

//        System.out.println(fun(100));
        Student student = new Student("aa", "男", 22);

        Class<?> clazz = Student.class;
        String clazzName = clazz.getName();//获取类名，包含包名
        System.out.println(clazzName);
        String simpleName = clazz.getSimpleName();//获取类名，不包含包名
        System.out.println(simpleName);

        int mod = clazz.getModifiers();//获取类修饰符
        System.out.println("类修饰符是不是public:" + Modifier.isPublic(mod));
        System.out.println("类修饰符是不是private:" + Modifier.isPrivate(mod));

        Package p = clazz.getPackage();//获取包
        System.out.println("包:" + p.getName());

        Class superClass = clazz.getSuperclass();//获取父类
        System.out.println("父类:" + superClass);

        Class[] interfaces = clazz.getInterfaces();//获取实现接口
        System.out.print("实现的接口：");
        Arrays.stream(interfaces).forEach(s -> System.out.print(s + ","));
        System.out.println();

        Constructor[] cons = clazz.getConstructors();//获取构造方法
        System.out.print("构造方法:");
        Arrays.stream(cons).forEach(s -> System.out.print(s + ","));
        System.out.println();

        Method[] methods = clazz.getMethods();//获取所有方法
        System.out.print("所有方法:");
        Arrays.stream(methods).forEach(s -> System.out.print(s.getName() + ","));
        System.out.println();


//        try {
//            Method setName1= studentClass.getMethod("setName1", String.class);
//            setName1.invoke(student,"我是反射生成的");
//            System.out.println(student.toString());
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        try {
//            Field field=studentClass.getDeclaredField("sex");
//            System.out.println(field.getName());
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
    }

    public static int fun(int i) {
        if (i == 1) {
            return 1;
        } else {
            return i + fun(i - 1);
        }
    }

}
