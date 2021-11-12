package me.guopop.demos.proxy_jdk_demo;

/**
 * @author guopop
 * @date 2020/9/29 18:36
 */
public class Advice {

    public void before() {
        System.out.println("before advice ...");
    }

    public void after() {
        System.out.println("after advice ...");
    }
}
