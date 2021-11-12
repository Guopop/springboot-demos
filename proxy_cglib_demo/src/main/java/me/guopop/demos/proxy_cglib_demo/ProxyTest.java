package me.guopop.demos.proxy_cglib_demo;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * @author guopop
 * @date 2020/9/29 19:07
 */
public class ProxyTest {
    public static void main(String[] args) {
        final Target target = new Target();

        final Advice advice = new Advice();

        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(Target.class);

        enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
            advice.before();
            Object invoke = method.invoke(target, objects);
            advice.after();
            return invoke;
        });

        Target proxy = (Target) enhancer.create();

        proxy.run();
    }
}
