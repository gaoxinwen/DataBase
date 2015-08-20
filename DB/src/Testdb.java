
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Testdb {

	public static void main(String[] args) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL数据库引擎
		String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Informationdb";// 数据源注意IP地址和端口号，数据库名字！！！
		try {
			Class.forName(JDriver);// 加载数据库引擎，返回给定字符串名的类
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("加载数据库引擎失败");
			System.exit(0);
		}
		System.out.println("数据库驱动成功");
		try {
			String user = "gaoxinwen";// 你自己创建的用户名字和密码！！！！！！！！！！！！
			String password ="100637";
			Connection con = DriverManager.getConnection(connectDB, user,
					password);// 连接数据库对象
			System.out.println("连接数据库成功");
			Statement stmt = con.createStatement();// 创建SQL命令对象
			// 创建表
			System.out.println("查询");
			System.out.println("开始读取数据");
			ResultSet rs = stmt.executeQuery("SELECT * FROM ZV曲线$");// 返回SQL语句查询结果集(集合)
			// 循环输出每一条记录
			while (rs.next()) {
				// 输出每个字段
				System.out.println(rs.getString("序号") + "\t"
						+ rs.getString("水位m") +"\t" + rs.getString("库容/万m3"));
			}
			System.out.println("读取完毕");
			// 关闭连接
			stmt.close();// 关闭命令对象连接
			con.close();// 关闭数据库连接
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("数据库连接错误");
			System.exit(0);
		}
	}

}
