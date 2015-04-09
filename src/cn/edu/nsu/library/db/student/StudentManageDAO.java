/**
 * 
 */
package cn.edu.nsu.library.db.student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import cn.edu.nsu.library.db.DBmain;

/**
 * @author ZXF
 *
 */
public class StudentManageDAO extends DBmain{

	@Override
	public Vector<Vector<String>> getAll() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		
		sql = "select * from student";
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
	
	public Vector<Vector<String>> getBorrowInquire(String str) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		
		sql = "select * from student where b_name= %?% ";
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
	
	@Override
	public Vector<String> getById(String id) throws ClassNotFoundException, SQLException {
		
		sql = "select * from student where snum=?";
		pst = getPreparedStatement(sql);
		// 参数绑定
		pst.setString(1, id);
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
	
	
	
	public Vector<String> getByUser(String snum) throws SQLException, ClassNotFoundException{
		sql = "select * from student where snum=?";
		pst = getPreparedStatement(sql);
		pst.setString(1, snum);
		rst = pst.executeQuery();
		

		Vector<String> record = null;
		while (rst.next()) {
			record = assemble(rst);
		}
		
		release();
		return record;
	}

	@Override
	public void add(Vector<String> record) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		sql = "insert into student(snum,sname,ssex,department,title,phone,class) values(?,?,?,?,?,?,?)";
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
		sql = "update student set snum=?,sname=?,ssex=?,department=?,title=?,phone=?,class=? where snum=?";
		pst = getPreparedStatement(sql);
		pst.setString(1, newRecord.get(0));
		pst.setString(2, newRecord.get(1));
		pst.setString(3, newRecord.get(2));
		pst.setString(4, newRecord.get(3));
		pst.setString(5, newRecord.get(4));
		pst.setString(6, newRecord.get(5));
		pst.setString(7, newRecord.get(6));
		pst.setString(7, id);
		pst.executeUpdate();
		release();
	}
	
	public void modifyPassword(Vector<String> newRecord,String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		sql = "update student set password=? where snum=?";
		pst = getPreparedStatement(sql);
		pst.setString(1, newRecord.get(0));
		pst.setString(2, id);
		pst.executeUpdate();
		release();
	}
	
	public void delete(String id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		sql = "delete student where snum=?";
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
		
		record.add(rst.getString("snum"));
		record.add(rst.getString("sname"));
		record.add(rst.getString("ssex"));
		record.add(rst.getString("department"));
		record.add(rst.getString("title"));
		record.add(rst.getString("phone"));
		record.add(rst.getString("class"));
		record.add(rst.getString("password"));
		
		return record;
	}
	
}
