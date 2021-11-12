package me.guopop.demos.reflect_demo;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author guopop
 * @date 2020/10/16 14:01
 */
public class CallMethod {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Hero hero = new Hero();
        Method m = hero.getClass().getMethod("setName", String.class);
        m.invoke(hero, "hello");
        System.out.println(hero.getName());
    }
}
