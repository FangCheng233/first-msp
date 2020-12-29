package com.fc.msp.mspalert.process;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @ClassName DecoratorTest
 * @Description TODO
 * @Author fangcheng
 * @Date 2020/9/11 9:59 上午
 * @Version 1.0
 */
public class DecoratorTest {

    public static void main(String[] args) throws Exception{
        Sourceable sourceable = new Source();
        List<String> policy = new ArrayList<>();
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        Integer number = 20;
        policy.add("com.fc.msp.mspalert.process.DecoratorA");
        policy.add("com.fc.msp.mspalert.process.DecoratorB");
        policy.add("com.fc.msp.mspalert.process.DecoratorC");
        policy.add("com.fc.msp.mspalert.process.DecoratorD");
        for (int i = 0; i<policy.size();i++) {
            Class<?> clazz = Class.forName(policy.get(i));
            Constructor constructor = clazz.getConstructor(Sourceable.class);
            sourceable = (Sourceable) constructor.newInstance(sourceable);
        }
        System.out.println(sourceable.execute(number));
    }
}
 class DecoratorA extends Decorator {
    public DecoratorA(Sourceable source){
        super(source);
    }
    @Override
    public boolean execute(Integer value) {
        if(value == 20){ return true; }
        return super.execute(value);
    }
}
class DecoratorB extends Decorator {
    public DecoratorB(Sourceable source){
        super(source);
    }
    @Override
    public boolean execute(Integer value) {
        if (value == 10){ return true; }
        return super.execute(value);
    }
}
class Decorator implements Sourceable {
    private Sourceable source;
    public Decorator(Sourceable source){
        this.source = source;
    }
    @Override
    public boolean execute(Integer value) {
        return source.execute(value);
    }
}
class Source implements Sourceable {
    @Override
    public boolean execute(Integer value) {
        boolean defVal = true;
        return defVal;
    }
}
interface Sourceable {
    public boolean execute(Integer a);
}
class DecoratorC extends Decorator {
    public DecoratorC(Sourceable source){
        super(source);
    }
    @Override
    public boolean execute(Integer value) {
        if (value == 5){ return true; }
        return super.execute(value);
    }
}
class DecoratorD extends Decorator {
    public DecoratorD(Sourceable source){
        super(source);
    }
    @Override
    public boolean execute(Integer value) {
        if (value == 1){ return true; }
        return super.execute(value);
    }
}
