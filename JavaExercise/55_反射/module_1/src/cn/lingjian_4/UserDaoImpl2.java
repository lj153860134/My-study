package cn.lingjian_4;

/**
 * @author lingjian
 * @date 2019/10/31 - 3:31 下午
 */
public class UserDaoImpl2 implements UserDao{
    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void update() {
        System.out.println("update");
    }

    @Override
    public void find() {
        System.out.println("find");
    }
}
