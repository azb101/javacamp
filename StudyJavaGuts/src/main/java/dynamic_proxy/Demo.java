package dynamic_proxy;

import java.lang.reflect.Proxy;
import java.util.Map;

public class Demo {

    public static void main(String[] args) {
        // proxy via separate class
        Map proxyInstance = (Map) Proxy.newProxyInstance(
                Demo.class.getClassLoader(),
                new Class[] { Map.class },
                new DynamicInvocationHandler()
        );

        proxyInstance.put("a", 5);

        System.out.println("what we have in proxy of map: " + proxyInstance.get("a"));

        // proxy via lambda
        var anotherProxy = (Map)Proxy.newProxyInstance(
                Demo.class.getClassLoader(),
                new Class[] { Map.class },
                (proxy, method, argss) -> {
                    System.out.println("Invokation of anoter proxy: " + method.getName());
                    return 10;
                }
        );

        anotherProxy.put("b", 10);


        CharSequence temp = (CharSequence)Proxy.newProxyInstance(
                Demo.class.getClassLoader(),
                new Class[] { CharSequence.class },
                new MethodTimeTrackingInvocationHandler("Hello world")
        );

        temp.length();
    }

}
