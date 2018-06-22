package com.gavin.glc.component.designpatternsdemo.SingletonPattern;

/**
 * Created by Gaoliangchao on 2018/6/22.
 * <p>
 * Description :    单例设计模式————饿汉式
 * 空间换时间
 * 优点：保证在第一次加载时实例被创建，线程安全
 * 缺点：无法延迟加载
 */

public class SingletonOne {

    //创建本类静态实例对象
    private static SingletonOne singletonOne = new SingletonOne();

    //私有构造方法
    private SingletonOne() {
    }

    //对外提供公共的访问实例的方法
    public static SingletonOne getInstance() {
        return singletonOne;
    }
}
