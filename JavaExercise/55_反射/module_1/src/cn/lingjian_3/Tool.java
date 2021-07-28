package cn.lingjian_3;

import java.lang.reflect.Field;

/**
 * @author lingjian
 * @date 2019/10/31 - 3:05 下午
 */
public class Tool {
    public void setProperty(Object obj,String propertyName,Object value) throws NoSuchFieldException, IllegalAccessException {
        Class c=obj.getClass();
        Field field=c.getDeclaredField(propertyName);
        field.setAccessible(true);
        field.set(obj,value);

    }
}
