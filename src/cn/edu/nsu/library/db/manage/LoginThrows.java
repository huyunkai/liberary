/**
 * 
 */
package cn.edu.nsu.library.db.manage;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Vector;

import cn.edu.nsu.library.db.*;

/**
 * @author Clover
 *
 */
public class LoginThrows 
{
	private String loginName;
	private String password;
	private HashMap<String, String> systemUserInfos = new HashMap<String, String>();
	//---------------------------------------------
	public LoginThrows(String loginName,String password)
	{
		this.loginName = loginName;
		this.password = password;
		
		/*systemUserInfos.put("admin", "admin");
		systemUserInfos.put("zxh", "zxh");
		systemUserInfos.put("abc", "abc");
		systemUserInfos.put("1", "1");
		systemUserInfos.put("asd", "asd");*/
	}
	
	public String login() throws SQLException, ClassNotFoundException
	{
		String result = null;
		
			//判定是否录入了登录名和密码
			if(loginName==null || loginName.equals("")
				|| password==null || password.equals(""))
			{
				result =  "请输入登录名和密码";
					//没录入，返回请输入登录名和密码
				try {
					throw new NoInputException("请输入登录名和密码");
				} catch (NoInputException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
			else
			{
				BookManageDAO userDao =new BookManageDAO();
				Vector<String> record = userDao.getByUser(loginName);
				System.out.println("" + record);
				try {
					record = userDao.getByUser(loginName);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//录入了，判定与登录名对应的用户是否存在
				if(record != null)
				{
					//存在，判定输入的密码和此用户的注册密码是否相等
					if(password.equals(record.get(2)))
					{
						//相等，返回登录成功
						result = "登录成功";
					}
					else
					{
						//不等，返回密码错误
						result = "密码错误";
					}
					
					
				}
				else
				{
					//不存在，返回用户不存在
					result = "用户不存在";
				}
				
				
			}
		
			
		return result;	
	}
}
