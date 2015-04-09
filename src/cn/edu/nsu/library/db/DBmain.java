/**
 * 
 */
package cn.edu.nsu.library.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

/**
 * ���в�����ĸ���
 * @author ������
 *
 */
public abstract class DBmain {
	
	protected String sql = null;
	
	protected Connection con = null;
	protected PreparedStatement pst = null;
	protected ResultSet rst = null;
	//=============================================
	/**
	 * ���ָ��sql����PreparedStatement����
	 * @param sql
	 * @return PreparedStatement����
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	protected PreparedStatement getPreparedStatement (String sql) throws ClassNotFoundException, SQLException{
		// ����jdbc����
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		// ������ݿ�����
		con = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=library", "sa", "123456");
		// ��װSQL���Ϊ��ִ�е�
		pst = con.prepareStatement(sql);
		
		return pst;
	}
	
	public void release () throws SQLException {
		//�ر����ݿ�����
		if(rst != null) {
			rst.close();
		}
		if(pst != null) {
			pst.close();
		}
		if(con != null) {
			con.close();
		}
	}
	
	public abstract Vector<Vector<String>> getAll() throws ClassNotFoundException, SQLException;
	public abstract Vector<String> getById(String isbn)throws ClassNotFoundException, SQLException;
	public abstract void add(Vector<String> record) throws ClassNotFoundException, SQLException;
	public abstract void modify(Vector<String> newRecord,String id) throws ClassNotFoundException, SQLException;
	public abstract void delete(String id) throws ClassNotFoundException, SQLException;
	public abstract Vector<String> assemble(ResultSet rst) throws SQLException;

}
