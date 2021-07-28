package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019/11/4 - 11:13 上午
 */
public enum  Direction3 {
    EAST("东"){
        @Override
        public void show() {
            System.out.println("东");
        }
    },
    SOUTH("西"){
        @Override
        public void show() {
            System.out.println("西");

        }
    },
    WEST("南"){
        @Override
        public void show() {
            System.out.println("南");

        }
    },
    NORTH("北"){
        @Override
        public void show() {
            System.out.println("北");

        }
    };

    private String name;

    private Direction3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract void show();
}
