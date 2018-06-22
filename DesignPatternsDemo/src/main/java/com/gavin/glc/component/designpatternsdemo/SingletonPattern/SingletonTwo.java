package com.gavin.glc.component.designpatternsdemo.SingletonPattern;

/**
 * Created by Gaoliangchao on 2018/6/22.
 * <p>
 * Description :    单例设计模式————懒汉式
 * 时间换空间
 * 优点：延迟加载，有效的防止的资源的消耗
 * 缺点：线程不安全，第一次加载时速度比较缓慢
 */

public class SingletonTwo {

    //创建本类对象静态引用
    private static SingletonTwo s;

    //私有构造方法
    private SingletonTwo() {}

    //对外提供本类实例的公共访问方式
    public static SingletonTwo getInstance() {
        if (s == null) {
            s = new SingletonTwo();
        }
        return s;
    }
}
