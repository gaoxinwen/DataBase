
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Insert {

	public static void main(String[] args) {
		String JDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";// SQL���ݿ�����
		String connectDB = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=Informationdb";// ����Դע��IP��ַ�Ͷ˿ںţ����ݿ����֣�����
		try {
			Class.forName(JDriver);// �������ݿ����棬���ظ����ַ���������
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
			System.out.println("�������ݿ�����ʧ��");
			System.exit(0);
		}
		System.out.println("���ݿ������ɹ�");
		try {
			String user = "gaoxinwen";// ���Լ��������û����ֺ����룡����������������������
			String password ="100637";
			Connection con = DriverManager.getConnection(connectDB, user,
					password);// �������ݿ����
			System.out.println("�������ݿ�ɹ�");
			Statement stmt = con.createStatement();// ����SQL�������
			// ������
			System.out.println("����");
			System.out.println("��ʼ��������");
			stmt.executeUpdate("insert into ZV����$ values (68,792,1064250)");
			// ѭ�����ÿһ����¼
			
			System.out.println("��ȡ���");
			// �ر�����
			stmt.close();// �ر������������
			con.close();// �ر����ݿ�����
		} catch (SQLException e) {
			e.printStackTrace();
			// System.out.println("���ݿ����Ӵ���");
			System.exit(0);
		}
	}

}
