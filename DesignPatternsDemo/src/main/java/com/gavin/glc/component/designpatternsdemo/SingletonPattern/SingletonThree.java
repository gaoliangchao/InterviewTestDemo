package com.gavin.glc.component.designpatternsdemo.SingletonPattern;

/**
 * Created by Gaoliangchao on 2018/6/22.
 * <p>
 * Description : DCL(Double Check Lock) 双重锁单例模式
 * 优点：进一步优化了懒汉模式 修复了线程不安全的问题
 * 缺点：在极端情况下还是会有线程不安全的问题
 */

public class SingletonThree {

    private static SingletonThree s;

    private SingletonThree() {}

    public static SingletonThree getInstance() {

        if (s == null) {
            synchronized (SingletonThree.class) {
                if (s == null) {
                    s = new SingletonThree();
                }
            }
        }
        return s;
    }
}
