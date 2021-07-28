package cn.lingjian_1;

/**
 * @author lingjian
 * @date 2019/11/4 - 10:27 上午
 */
public class Direction {
    //创建方向
    public static final Direction EAST= new Direction();
    public static final Direction SOUTH= new Direction();
    public static final Direction WEST= new Direction();
    public static final Direction NORTH= new Direction();

    //构造私有 外界无法创建对象
    //不包括反射 反射可以创建对象
    private Direction(){

    }
}
