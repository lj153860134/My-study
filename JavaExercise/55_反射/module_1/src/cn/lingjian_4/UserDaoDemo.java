package cn.lingjian_4;

/**
 * @author lingjian
 * @date 2019/10/31 - 3:21 下午
 */
public class UserDaoDemo {
    public static void main(String[] args) {
        //基本的用户操作
        UserDao ud=new UseDaoImpl();
        ud.add();
        ud.delete();
        ud.update();
        ud.find();
        System.out.println("--------");

        //在每个操作执行前：应该看是否有权限进行这样的操作
        //在操作的时候应该留下记录

    }
}
