package me.guopop.demos.proxy_jdk_demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author guopop
 * @date 2020/9/29 18:37
 */
public class ProxyTest {
    public static void main(String[] args) {

        final Target target = new Target();

        final Advice advice = new Advice();

        TargetInterface proxyObject = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                (proxy, method, args1) -> {
                    advice.before();
                    Object invoke = method.invoke(target, args1);
                    advice.after();
                    return invoke;
                }
        );

        proxyObject.run();
    }
}
