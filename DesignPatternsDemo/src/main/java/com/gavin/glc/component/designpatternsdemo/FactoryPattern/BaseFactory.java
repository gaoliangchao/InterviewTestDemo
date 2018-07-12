package com.gavin.glc.component.designpatternsdemo.FactoryPattern;

/**
 * Created by Gaoliangchao on 2018/6/22.
 * <p>
 * Description :    抽象工厂类
 */

public abstract class BaseFactory {

    abstract Car create(String model);
}
