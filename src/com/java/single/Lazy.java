package com.java.single;

import java.io.*;

/**
 * Created by cdc on 2018/4/11.
 *
 * 第一、把自己的构造方法设置为private的，不让别人new你的实例；
 * 第二、提供一个static方法给别人获取你的实例，你在这个方法里面返回你自己创建的实例就行”。
 * “懒汉式”， 可能是因为在需要的时候才创建吧， 显得很“懒”。
 */
public class Lazy implements Serializable{

    private static final long serialVersionUID = - 1420014050236876007L;

    private static Lazy lazy;
    private Lazy(){};

    public static Lazy getInstance(){
        if (lazy == null){
            lazy = new Lazy();
        }
        return lazy;
    }

    // 在反序列化的时候会判断如果实现了serializable
    // 或者 externalizable接口的类中又包含readResolve()方法的话，
    // 会直接调用readResolve()方法来获取实例。
    //所以可以防止黑客的序列化破坏
    private Object readResolve(){
        return lazy;
    }

    public static void main(String[] args) {
        try {
            //黑客破坏：反射
            Lazy l1 = Lazy.class.newInstance();
            Lazy l2 = Lazy.class.newInstance();
            System.out.println(l1);
            System.out.println(l2);
            System.out.println("黑客破坏-反射：" + (l1 == l2));

            //黑客破坏：序列化和反序列化
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("s"));
            oos.writeObject(Lazy.getInstance());
            File file = new File("s");
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            ObjectInputStream ois2 = new ObjectInputStream(new FileInputStream(file));
            Lazy lazy1 = (Lazy) ois.readObject();
            Lazy  lazy2 = (Lazy)ois2.readObject();
            System.out.println(lazy1);
            System.out.println(lazy2);
            System.out.println("黑客破坏-序列化和反序列化: " + (lazy1 == lazy2));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
