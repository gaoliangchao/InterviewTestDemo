package com.gavin.glc.component.designpatternsdemo.AbstractFactoryPattern.tire;

/**
 * Created by Gaoliangchao on 2018/6/22.
 * <p>
 * Description :    普通轮胎的实现类
 */

public class NormalTire implements ITire {
    @Override
    public void tire() {
        System.out.println("普通轮胎");
    }
}
