package com.gavin.glc.component.designpatternsdemo.AbstractFactoryPattern.tire;

/**
 * Created by Gaoliangchao on 2018/6/22.
 * <p>
 * Description :    进口轮胎实现类
 */

public class SUVTire implements ITire {
    @Override
    public void tire() {
        System.out.println("进口轮胎");
    }
}
