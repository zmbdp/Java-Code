package fan.she;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectClassDemo {
    /**
     * 修改私有方法
     */
    public static void reflectPrivateMethod() {
        try {
            Class<?> c = Class.forName("fan.she.Student");
            Student student = (Student) c.newInstance();
            Method method = c.getDeclaredMethod("function", String.class);
            method.setAccessible(true);
            method.invoke(student, "我是一个私有方法-> function的参数");
        } catch (ClassNotFoundException |
                 InstantiationException |
                 IllegalAccessException |
                 NoSuchMethodException |
                 InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        reflectPrivateMethod();
    }


    /**
     * 修改私有属性
     */
    public static void reflectPrivateField() {
        try {
            Class<?> c = Class.forName("fan.she.Student");
            Student student = (Student) c.newInstance();
            Field field = c.getDeclaredField("name");
            field.setAccessible(true);
            field.set(student, "aoe");
            System.out.println(student);
        }
        catch (NoSuchFieldException |
                 ClassNotFoundException |
                 IllegalAccessException |
                 InstantiationException e) {

            throw new RuntimeException(e);
        }
    }
    public static void main3(String[] args) {
        reflectPrivateField();
    }


    /**
     * 反射私有的构造方法 屏蔽内容为获得公有的构造方法
     */
    public static void reflectPrivateConstructor() {
        try {
            Class<?> c = Class.forName("fan.she.Student");
            Constructor<?> constructor =  c.getDeclaredConstructor(String.class, int.class);// 先拿到私有方法
            constructor.setAccessible(true);// 设置为true后可修改访问权限
            Student student = (Student) constructor.newInstance("杨菲", 20);
            System.out.println(student);
        } catch (ClassNotFoundException |
                 NoSuchMethodException |
                 InvocationTargetException |
                 InstantiationException |
                 IllegalAccessException e) {

            throw new RuntimeException(e);
        }
    }
    public static void main2(String[] args) {
        reflectPrivateConstructor();
    }


    /**
     * 拿到这个类
     * @throws ClassNotFoundException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public static void reflectNewInstance() throws ClassNotFoundException,
            InstantiationException, IllegalAccessException {

        Class<?> c = Class.forName("fan.she.Student");
        Student student = (Student) c.newInstance();
        System.out.println(student);
    }
    public static void main1(String[] args) {
        try {
            reflectNewInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
