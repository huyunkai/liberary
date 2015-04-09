/**
 * 
 */
package cn.edu.nsu.library.db;

/**
 * @author Clover
 *
 */
public class NoInputException extends Exception
{
	
	//------------------------------------------
	public NoInputException()
	{
		super("没有输入数据！");
	}
	public NoInputException(String message)
	{
		super(message);
	}
	
	
	
}
