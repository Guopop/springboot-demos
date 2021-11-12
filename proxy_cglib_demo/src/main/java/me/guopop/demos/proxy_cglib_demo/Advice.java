package me.guopop.demos.proxy_cglib_demo;

/**
 * @author guopop
 * @date 2020/9/29 19:06
 */
public class Advice extends Target {

    public void before() {
        System.out.println("before advice ...");
    }

    public void after() {
        System.out.println("after advice ...");
    }
}
