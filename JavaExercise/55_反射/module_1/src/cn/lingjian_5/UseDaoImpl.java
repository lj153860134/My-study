package cn.lingjian_5;

/**
 * @author lingjian
 * @date 2019/10/31 - 3:19 下午
 */
/*
* 用户操作的实现类
* */
public class UseDaoImpl implements UserDao {
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
