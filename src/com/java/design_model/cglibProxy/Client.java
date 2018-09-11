package com.java.design_model.cglibProxy;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by cdc on 2018/4/10.
 *
 * 在这里我们需要注意一点：如果委托类被final修饰，那么它不可被继承，即不可被代理；
 * 同样，如果委托类中存在final修饰的方法，那么该方法也不可被代理；
 */
public class Client {

    public static void main(String[] args) {
        //创建一个增强器，用来在运行时生成类
        Enhancer enhancer = new Enhancer();
        //继承被代理类（设置要继承的目标类），所以生成的是个子类
        enhancer.setSuperclass(WelcomeImpl.class);
        //设置回调
        enhancer.setCallback(new WelcomeMethodInterceptor());
        //生成代理对象
        WelcomeImpl welcome = (WelcomeImpl)enhancer.create();
        welcome.sayWelcome();  //在调用代理类中方法时会被我们实现的方法拦截器进行拦截
    }
}
