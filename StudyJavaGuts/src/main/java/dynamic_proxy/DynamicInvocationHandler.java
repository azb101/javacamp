package dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        String temp = "";
        for(var obj : args)
            temp += obj.toString() + ";";

        System.out.println(method.getName() + " is invoked: " + temp);

        return 11;
    }
}
