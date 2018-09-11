package com.java.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by cdc on 2018/4/3.
 */
public class LoggerHandler implements InvocationHandler {

    private Object target;

    public LoggerHandler(Object target){
        this.target = target;
    }

    @Override  //扩展代码的地方
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("start: before hello world");
        Object result = method.invoke(target,args);
        System.out.println("end: after hello world");
        return result;
    }

    public static void main(String[] args) {
        IHelloWorld helloWorld = new HelloWorld();
        IWelcome welcome = new HelloWorld();
        LoggerHandler loggerHandler = new LoggerHandler(helloWorld);
        //目标类动态代理对象
        IHelloWorld proxy =  (IHelloWorld) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                helloWorld.getClass().getInterfaces(),loggerHandler);
        proxy.sayHello();
    }


    /**
     * 方法说明： newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h)
     *
     * 前面讲过了代理类和目标类实现共同的接口,因此需要将目标类所实现的接口(这里是一个Class数组)传给Proxy,
     * 除此之外还需要传递目标类的类加载器和InvocationHandler实例,类加载器当然是用来加载生成的代理类的class文件,
     * 而这里的InvocationHandler是什么呢?顾名思义,调用处理器,当对代理类调用相应的方法时(这里的方法其实是我们想对目标类调用的),该方法调用会被拦截,并回调InvocationHandler实现类的invoke方法,我们来简单看看invoke方法:
     *
     *invoke(Object proxy, Method method, Object[] args)
     *invoke方法中又包含了三个参数,
     * 第一个是代理对象proxy,
     * 第二个是Method对象,
     * 第三个是一个Object数组,
     * 这里简单介绍下这三个参数:
     * proxy对象大家应该都知道了,即代理对象,上面利用Proxy的静态newProxyInstance方法创建的;
     * method对象,即方法对象,这里的方法对象是什么呢?刚才说到了对代理对象调用方法时会被拦截,而这里的method就是被拦截的方法对象;
     * 最后一个是args,相信大家对这个变量不会陌生,这里表示的是对代理对象调用方法时所传递的参数,参数可能为一个,两个或者多个,
     * 当然也可能没有,因此这里用一个数组表示。
     *
     */
}
