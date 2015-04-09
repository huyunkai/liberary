/**
 * 
 */
package cn.edu.nsu.library.db.manage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.edu.nsu.library.db.DBmain;

/**
 * @author ZXF
 *
 */
public class BookManageDAO extends DBmain{

	@Override
	public Vector<Vector<String>> getAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		
		sql = "select * from books";
		pst = getPreparedStatement(sql);
		// 参数绑定
		// 执行sql语句
		rst = pst.executeQuery();
		// 处理查询结果
		Vector<Vector<String>> records = new Vector<Vector<String>>();
		Vector<String> record = null;
		while(rst.next()) {
			
			record = assemble(rst);
			
			records.add(record);
		}
		
		release();
		
		return records;
	
	}
	
	public Vector<Vector<String>> getBookInquire(String str) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		
		sql = "select * from books where b_name like ? ";
		pst = getPreparedStatement(sql);
		pst.setString(1,"%"+str+"%");
		// 参数绑定
		// 执行sql语句
		rst = pst.executeQuery();
		// 处理查询结果
		Vector<Vector<String>> records = new Vector<Vector<String>>();
		Vector<String> record = null;
		while(rst.next()) {
			
			record = assemble(rst);
			
			records.add(record);
		}
		
		release();
		
		return records;
	
	}
	
	@Override
	public Vector<String> getById(String isbn) throws ClassNotFoundException, SQLException {
		
		sql = "select * from books where isbn=?";
		pst = getPreparedStatement(sql);
		// 参数绑定
		pst.setString(1, isbn);
		// 执行sql语句
		rst = pst.executeQuery();
		// 处理查询结果
		Vector<String> record = null;
		while(rst.next()) {
			
			record = assemble(rst);
		}
		
		release();
		
		return record;
	}
	
	public Vector<String> getByUser(String user) throws SQLException, ClassNotFoundException{
		sql = "select * from manager where users=?";
		pst = getPreparedStatement(sql);
		pst.setString(1, user);
		rst = pst.executeQuery();
		

		Vector<String> record = null;
		while (rst.next()) {
			record = assemble2(rst);
		}
		
		release();
		return record;
	}
	
	public int count() throws ClassNotFoundException, SQLException{
		sql = "select number from stack";
		pst = getPreparedStatement(sql);
		rst = pst.executeQuery();
		Vector<String> record = null;
		int X = 0;
		while(rst.next()) {
			
			record = assemble3(rst);
			X+=Integer.valueOf(record.get(0));
		}
		
		release();
		return X;
		
	}
	
	@Override
	public void add(Vector<String> record) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		sql = "insert into books(ISBN,b_name,author,press,price,introduction,cnum) values(?,?,?,?,?,?,?)";
		pst = getPreparedStatement(sql);
		// 参数绑定
		pst.setString(1,record.get(0));
		pst.setString(2,record.get(1));
		pst.setString(3,record.get(2));
		pst.setString(4,record.get(3));
		pst.setString(5,record.get(4));
		pst.setString(6,record.get(5));
		pst.setString(7,record.get(6));
		
		pst.executeUpdate();
		
		release();
	}

	@Override
	public void modify(Vector<String> newRecord,String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		sql = "update books set ISBN=?,b_name=?,author=?,press=?,price=?,introduction=?,cnum=? where ISBN=?";
		pst = getPreparedStatement(sql);
		pst.setString(1, newRecord.get(0));
		pst.setString(2, newRecord.get(1));
		pst.setString(3, newRecord.get(2));
		pst.setString(4, newRecord.get(3));
		pst.setString(5, newRecord.get(4));
		pst.setString(6, newRecord.get(5));
		pst.setString(7, newRecord.get(6));
		pst.setString(8, id);
		pst.executeUpdate();
		release();
	}
	public void modifyPassword(Vector<String> newRecord,String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		sql = "update manager set password=? where users=?";
		pst = getPreparedStatement(sql);
		pst.setString(1, newRecord.get(0));
		pst.setString(2, id);
		pst.executeUpdate();
		release();
	}

	public void delete(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		sql = "delete books where ISBN=?";
		pst = getPreparedStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();
		release();
	}
	/**
	 * 将数据库中的单条记录封装为本地内存的Vector<String>对象
	 * @param rst 数据库中的单条记录
	 * @return 一个本地内存的Vector<String>对象
	 * @throws SQLException
	 */
	public Vector<String> assemble(ResultSet rst) throws SQLException{
		Vector<String> record =  new Vector<String>();
		
		record.add(rst.getString("ISBN"));
		record.add(rst.getString("b_name"));
		record.add(rst.getString("author"));
		record.add(rst.getString("press"));
		record.add(rst.getString("price"));
		record.add(rst.getString("introduction"));
		record.add(rst.getString("cnum"));
		
		return record;
	}
	public Vector<String> assemble2(ResultSet rst) throws SQLException{
		Vector<String> record =  new Vector<String>();
		
		record.add(rst.getString("mID"));
		record.add(rst.getString("users"));
		record.add(rst.getString("password"));
		
		return record;
	}
	public Vector<String> assemble3(ResultSet rst) throws SQLException{
		Vector<String> record =  new Vector<String>();
	
		record.add(rst.getString("number"));
		
		return record;
	}
}
