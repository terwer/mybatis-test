package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author terwer
 * @Description
 * @create 2021-11-30 23:18
 */
public class Main {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            // 1、加载数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            // 2、获取数据库链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mybatis?characterEncoding=utf-8&useSSL=false", "root", "123456");

            // 3、定义sql语句
            String sql = "select * from user where username = ?";
            // 4、获取预处理对象
            preparedStatement = connection.prepareStatement(sql);
            // 5、设置参数
            preparedStatement.setString(1, "hp");
            // 6、拿到查询的数据库结果
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String username = resultSet.getString("username");

                User user = new User();
                user.setId(id);
                user.setUsername(username);

                System.out.println("user = " + user.toString());
            }

            // JDBC问题分析
            // 1、数据库链接信息等存在硬编码  解决：配置文件
            // 2、频繁创建释放数据库链接 解决：连接池(c3p0、druid)

            // 查询过程问题分析
            // 1、sql语句、参数、结果集存在硬编码 解决：配置文件

            // 结果集问题分析
            // 1、需要手动封装结果集 解决：反射进行对象映射、内省

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("释放资源");
        }
    }
}
