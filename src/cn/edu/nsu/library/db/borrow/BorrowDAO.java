package cn.edu.nsu.library.db.borrow;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import cn.edu.nsu.library.db.DBmain;

public class BorrowDAO extends DBmain{

	@Override
	public Vector<Vector<String>> getAll() throws ClassNotFoundException,
			SQLException {
		sql = "select * from borrow";
		pst = getPreparedStatement(sql);
		rst = pst.executeQuery();
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
	public Vector<String> getById(String isbn) throws ClassNotFoundException,
			SQLException {
		sql = "SELECT * FROM borrow WHERE ISBN = ?";
		pst = getPreparedStatement(sql);
		pst.setString(1,isbn);
		rst = pst.executeQuery();
		Vector<String> rec = new Vector<String>();
		rec = assemble(rst);
		release();
		return rec;
	}
	
	public Vector<Vector<String>> getBySnum(String snum) throws ClassNotFoundException,
	SQLException {
		sql = "select * from borrow where snum = ?";
		pst = getPreparedStatement(sql);
		pst.setString(1,snum);
		rst = pst.executeQuery();
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
	public void add(Vector<String> record) throws ClassNotFoundException,
			SQLException {
		sql = "insert into borrow(snum,ISBN,btime,rtime) values(?,?,?,?)";
		pst = getPreparedStatement(sql);
		pst.setString(1,record.get(0));
		pst.setString(2,record.get(1));
		pst.setString(3,record.get(2));
		pst.setString(4,record.get(3));
		pst.executeUpdate();
		release();
	}

	@Override
	public void modify(Vector<String> newRecord, String id)
			throws ClassNotFoundException, SQLException {
		sql = "update borrow set snum=?,btime=?,rtime=? where ISBN = ?";
		pst = getPreparedStatement(sql);
		pst.setString(1, newRecord.get(0));
		pst.setString(2, newRecord.get(1));
		pst.setString(3, newRecord.get(2));
		pst.setString(4, id);
		pst.executeUpdate();
		release();
	}

	@Override
	public void delete(String id) throws ClassNotFoundException, SQLException {
		sql = "delete borrow where ISBN=?";
		pst = getPreparedStatement(sql);
		pst.setString(1, id);
		pst.executeUpdate();
		release();
	}

	@Override
	public Vector<String> assemble(ResultSet rst) throws SQLException {
		Vector<String> record =  new Vector<String>();
		
		record.add(rst.getString("snum"));
		record.add(rst.getString("ISBN"));
		record.add(rst.getString("btime"));
		record.add(rst.getString("rtime"));
		
		return record;
	}
	
	public String getTime(){
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.YEAR) + "-" + (now.get(Integer.valueOf(Calendar.MONTH))+1) + "-" + now.get(Calendar.DAY_OF_MONTH);
	}

}
