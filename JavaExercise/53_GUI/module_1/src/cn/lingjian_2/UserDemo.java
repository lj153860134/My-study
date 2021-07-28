package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019/10/23 - 3:54 下午
 */
public class UserDemo {
    public static void main(String[] args) {
        UserDao ud=new UserDaoImpl2();
        ud.add();
    }
}
