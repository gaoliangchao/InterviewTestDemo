package com.gavin.glc.component.designpatternsdemo.FactoryPattern;

/**
 * Created by Gaoliangchao on 2018/6/22.
 * <p>
 * Description :    Car的具体实现类2
 */

public class HondaCar extends Car {
    @Override
    void driver() {
        System.out.println("本田准备出发");
    }

    @Override
    void money() {
        System.out.println("十万起售");
    }
}
