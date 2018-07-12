package com.gavin.glc.component.designpatternsdemo.FactoryPattern;

/**
 * Created by Gaoliangchao on 2018/6/22.
 * <p>
 * Description :    工厂的具体实现类 实现具体的创建细节
 */

public class CarFactory extends BaseFactory {
    @Override
    Car create(String model) {
        Car car = null;
        if ("honda".equals(model)) {
            car = new HondaCar();
        } else if ("audi".equals(model)) {
            car = new AudiCar();
        }
        return car;
    }
}
