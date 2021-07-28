package cn.lingjian_2;


/**
 * @author lingjian
 * @date 2019/11/4 - 11:06 上午
 */
public class DirectionDemo {
    public static void main(String[] args) {
        Direction d = Direction.EAST;
        System.out.println(d);

        Direction2 d2 = Direction2.EAST;
        System.out.println(d2);
        System.out.println(d2.getName());

        Direction3 d3 = Direction3.NORTH;
        System.out.println(d3);
        System.out.println(d3.getName());
        d3.show();
    }


}
