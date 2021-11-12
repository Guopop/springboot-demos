package me.guopop.demos.reflect_demo;

/**
 * @author guopop
 * @date 2020/10/16 13:45
 */
public class GetClass {
    public static void main(String[] args) throws ClassNotFoundException {
        // 三种获取类对象的方式
        String className = "me.guopop.demos.reflect_demo.Hero";
        Class<?> class1 = Class.forName(className);
        Class<Hero> class2 = Hero.class;
        Class<? extends Hero> class3 = new Hero().getClass();
        System.out.println(class1 == class2);
        System.out.println(class2 == class3);
    }
}
