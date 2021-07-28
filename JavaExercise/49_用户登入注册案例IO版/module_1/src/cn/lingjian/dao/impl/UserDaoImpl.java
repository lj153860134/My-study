package cn.lingjian.dao.impl;

import cn.lingjian.dao.UserDao;
import cn.lingjian.pojo.User;

import java.io.*;

/**
 * @author lingjian
 * @date 2019/10/11 - 2:43 下午
 */
public class UserDaoImpl implements UserDao {
    //为了程序一启动 就有user.txt文件
    //用静态代码块
    private static File file=new File("user.txt");
    static {
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Failed to create file");
//            e.printStackTrace();
        }
    }
    @Override
    public boolean isLogin(String username, String password) {
        boolean flag=false;
        BufferedReader br = null;
        try {
            br=new BufferedReader(new FileReader(file));
            String line=null;
            while((line=br.readLine())!=null){
                String[] dates=line.split("=");
                if(dates[0].equals(username)&&dates[1].equals(password)){
                    flag=true;
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Login failed");
        }finally {
            if(br!=null) {
                try {
                    br.close();
                } catch (IOException e) {
                    System.out.println("Failed to release resources");
//                    e.printStackTrace();
                }
            }
        }
        return flag;

    }


    @Override
    public void register(User user)  {
        /*
        * 为了让注册的数据有一定的规则，我们就定义了一个规则：
        * 用户名=密码
        * */
        BufferedWriter bw=null;
        try {
            //为了保证数据是追加写入，必须加true
            bw=new BufferedWriter(new FileWriter(file,true));
            String info=user.getUsername()+"="+user.getPassword();
            bw.write(info);
            bw.newLine();
            bw.flush();
        } catch (IOException e) {
            System.out.println("Registration Failure");
        }finally {
            if(bw!=null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    System.out.println("Failed to release resources");
//                    e.printStackTrace();
                }
            }
        }

    }
}
