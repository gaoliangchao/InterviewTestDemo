package com.gavin.glc.component.designpatternsdemo.AbstractFactoryPattern.engine;

/**
 * Created by Gaoliangchao on 2018/6/22.
 * <p>
 * Description :    进口引擎的实现类
 */

public class SUVEngine implements IEngine {
    @Override
    public void engine() {
        System.out.println("进口引擎");
    }
}
