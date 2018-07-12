package com.gavin.glc.component.designpatternsdemo.FactoryPattern;

/**
 * Created by Gaoliangchao on 2018/6/22.
 * <p>
 * Description :    Car的具体实现类1
 */

public class AudiCar extends Car {
    @Override
    void driver() {
        System.out.println("奥迪准备出发");
    }

    @Override
    void money() {
        System.out.println("20万起售");
    }
}
