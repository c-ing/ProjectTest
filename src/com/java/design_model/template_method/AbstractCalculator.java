package com.java.design_model.template_method;

/**
 * Created by cdc on 2018/6/22.
 */
public abstract class AbstractCalculator {

    /**主方法，实现对本类其它方法的调用*/
    public final int calculate(String exp,String opt){
        System.out.println("抽象类的calcula被调用");
        int array[] = split(exp,opt);
        return calculate(array[0],array[1]);
    }

    /** 被子类重写的方法*/
    abstract public int calculate(int num1, int num2);

    public int[] split(String exp, String opt) {
        System.out.println("抽象类的split被调用");
        String array[] = exp.split(opt);
        int arrayInt[] = new int[2];
        arrayInt[0] = Integer.parseInt(array[0]);
        arrayInt[1] = Integer.parseInt(array[1]);
        return arrayInt;
    }

}
