package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019/11/4 - 11:08 上午
 */
public enum Direction2 {
    EAST("东"),
    SOUTH("西"),
    WEST("南"),
    NORTH("北");

    private String name;

    private Direction2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
