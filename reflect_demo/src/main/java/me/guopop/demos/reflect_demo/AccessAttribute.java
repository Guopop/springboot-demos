package me.guopop.demos.reflect_demo;

import java.lang.reflect.Field;

/**
 * @author guopop
 * @date 2020/10/16 13:57
 */
public class AccessAttribute {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Hero h = new Hero();
        h.setName("vn");

        Class<? extends Hero> aClass = h.getClass();
        Field name = aClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(h, "teemo");
        System.out.println(h);
    }
}
