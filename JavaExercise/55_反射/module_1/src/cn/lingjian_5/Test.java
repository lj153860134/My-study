package cn.lingjian_5;

import java.lang.reflect.Proxy;

/**
 * @author lingjian
 * @date 2019/10/31 - 4:09 下午
 */
public class Test {
    public static void main(String[] args) {
        UserDao ud=new UseDaoImpl();
        ud.add();
        ud.delete();
        ud.update();
        ud.find();
        System.out.println("--------");

        //创建动态代理对象
        //对ud对象做一个代理对象
        MyInvocationHandler handler=new MyInvocationHandler(ud);
        UserDao proxy=(UserDao)Proxy.newProxyInstance(ud.getClass().getClassLoader(),
                ud.getClass().getInterfaces(),handler);
        proxy.add();
        proxy.delete();
        proxy.update();
        proxy.find();

        System.out.println("--------");
        System.out.println(ud.getClass());
        System.out.println(UserDao.class);




    }
}
