package com.java.reflect;

import java.lang.reflect.Constructor;

/**
 * 获取Class对象的三种方式
 * 1 Object ——> getClass();
 * 2 任何数据类型（包括基本数据类型）都有一个“静态”的class属性
 * 3 通过Class类的静态方法：forName（String  className）(常用)
 *
 *  通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
 *
 * 1.获取构造方法：
 *      1).批量的方法：
 *          public Constructor[] getConstructors()：所有"公有的"构造方法
            public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)

 *      2).获取单个的方法，并调用：
 *          public Constructor getConstructor(Class... parameterTypes):获取单个的"公有的"构造方法：
 *          public Constructor getDeclaredConstructor(Class... parameterTypes):获取"某个构造方法"可以是私有的，或受保护、默认、公有；
 *
 *          调用构造方法：
 *          Constructor-->newInstance(Object... initargs)
 *
 *  2. 获取成员变量并调用：
 *
 *      1.批量的
 *          1).Field[] getFields():获取所有的"公有字段"
 *          2).Field[] getDeclaredFields():获取所有字段，包括：私有、受保护、默认、公有；
 *      2.获取单个的：
 *          1).public Field getField(String fieldName):获取某个"公有的"字段；
 *          2).public Field getDeclaredField(String fieldName):获取某个字段(可以是私有的)
 *
 *      设置字段的值：
 *          Field --> public void set(Object obj,Object value):
 *                  参数说明：
 *                  1.obj:要设置的字段所在的对象；
 *                  2.value:要为字段设置的值；
 */
public class Fanshe  {

    public static void main(String[] args) throws Exception {

        //通过反射获取对象的三种方式
        //1
        Student stu1 = new Student();
        Class stuclass = stu1.getClass();
        System.out.println(stuclass.getName());

        //2
        Class stuClass2 = Student.class;
        System.out.println(stuclass == stuClass2);  //判断第一种方式获取的Class对象和第二种方式获取的是否是同一个

        //3
        try {
            Class stuClass3 = Class.forName("com.java.reflect.Student"); //注意此字符串必须是真实路径，就是带包名的类路径，包名.类名
            System.out.println(stuClass3 == stuClass2);//判断三种方式是否获取的是同一个Class对象
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        //获取构造方法
        //1.加载Class对象
        Class clazz = Class.forName("com.java.reflect.Student");
        //2.获取所有公有构造方法
        Constructor[] conArray = clazz.getConstructors();
        for (Constructor c : conArray){
            System.out.println(c);
        }
        //3.所有的构造方法(包括：私有、受保护、默认、公有)
        conArray = clazz.getDeclaredConstructors();
        for (Constructor c : conArray){
            System.out.println(c);
        }
        //4.获取公有、无参的构造方法
        Constructor con = clazz.getConstructor(null);
        //1>、因为是无参的构造方法所以类型是一个null,不写也可以：这里需要的是一个参数的类型，切记是类型
        //2>、返回的是描述这个无参构造函数的类对象。
        System.out.println("con = " + con);
         //调用构造方法
        Object obj = con.newInstance();
        //System.out.println("obj = " + obj);
        //Student stu = (Student)obj;

        //5. 获取私有构造方法，并调用
        con = clazz.getDeclaredConstructor(char.class);
        System.out.println(con);
        //调用构造方法
        con.setAccessible(true);
        obj = con.newInstance('男');


        //获取成员变量并调用：
        //1.获取Class对象
        Class stuClass = Class.forName("com.java.reflect.Student");
        //2.获取字段
        System.out.println("************获取所有公有的字段********************");
    }
}
