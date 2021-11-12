package me.guopop.demos.reflect_demo;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author guopop
 * @date 2020/10/16 13:48
 */
public class CreateClass {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // new对象
        Hero h1 = new Hero();
        h1.setName("teemo");
        System.out.println(h1);

        // 反射创建对象
        String className = "me.guopop.demos.reflect_demo.Hero";
        Class<?> class1 = Class.forName(className);
        Constructor<?> constructor = class1.getConstructor();
        Hero h2 = (Hero) constructor.newInstance();
        h2.setName("vn");
        System.out.println(h2);
    }
}
