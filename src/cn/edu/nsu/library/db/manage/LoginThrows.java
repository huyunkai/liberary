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
		
			//�ж��Ƿ�¼���˵�¼��������
			if(loginName==null || loginName.equals("")
				|| password==null || password.equals(""))
			{
				result =  "�������¼��������";
					//û¼�룬�����������¼��������
				try {
					throw new NoInputException("�������¼��������");
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
				//¼���ˣ��ж����¼����Ӧ���û��Ƿ����
				if(record != null)
				{
					//���ڣ��ж����������ʹ��û���ע�������Ƿ����
					if(password.equals(record.get(2)))
					{
						//��ȣ����ص�¼�ɹ�
						result = "��¼�ɹ�";
					}
					else
					{
						//���ȣ������������
						result = "�������";
					}
					
					
				}
				else
				{
					//�����ڣ������û�������
					result = "�û�������";
				}
				
				
			}
		
			
		return result;	
	}
}
