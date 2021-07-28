import com.lingjian.service.IAccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @description: 测试AOP的配合
 * @author: Ling Jian
 * @date: 2020-02-14 15:24
 **/
public class Test {
    public static void main(String[] args) {
        //获取容器
        ApplicationContext ac=new ClassPathXmlApplicationContext("bean.xml");
        //获取对象
        IAccountService as=(IAccountService)ac.getBean("accountService");
        //执行方法
        as.saveAccount();
        as.updateAccount(1);
        System.out.println(as.deleteAccount());

    }
}
