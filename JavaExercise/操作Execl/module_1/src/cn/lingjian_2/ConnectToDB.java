package cn.lingjian_2;

/**
 * @author lingjian
 * @date 2019/10/24 - 3:55 下午
 */
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectToDB {

    public static void main(String[] args) {
        Connection con;
        DatabaseMetaData meta=null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            System.out.println("加载驱动成功");
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {

            e1.printStackTrace();
            System.out.println("加载驱动失败");
        }



        try {
            String uri = "jdbc:mysql://111.231.205.64:3306/dzsj";
            String user="test";
            String password="test";
            con= DriverManager.getConnection(uri,user,password);
            System.out.println("连接数据库成功");
            meta =  con.getMetaData();
            System.out.println("连接的数据库："+meta.getURL()+"\n"+"Driver:"+meta.getDriverName()+"\n"+"Version："+meta.getDriverVersion());
        } catch (SQLException e) {

            e.printStackTrace();
        }


    }

}

