package me.guopop.demos.proxy_jdk_demo;

/**
 * @author guopop
 * @date 2020/9/29 18:36
 */
public class Target implements TargetInterface {
    @Override
    public void run() {
        System.out.println("running...");
    }
}
