package com.gavin.glc.component.designpatternsdemo.SingletonPattern;

/**
 * Created by Gaoliangchao on 2018/6/22.
 * <p>
 * Description :    单例设计模式————静态内部类
 * 优点：在需要的时候才进行初始化，延迟加载，防止消耗不必要的资源，线程安全
 */

public class SingletonFour {

    private SingletonFour() {
    }

    public static SingletonFour getInstance() {
        return SingletonHolder.s;
    }

    private static class SingletonHolder {
        private static final SingletonFour s = new SingletonFour();
    }
}
