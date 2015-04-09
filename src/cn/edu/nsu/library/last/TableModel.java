/**
 * 
 */
package cn.edu.nsu.library.last;

import java.util.Vector;

import javax.swing.table.AbstractTableModel;

/**
 * @author ����
 *
 */
public class TableModel extends AbstractTableModel
{
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	private Vector<Vector<String>> tableDataList = new Vector<Vector<String>>();

	private  String[] columnNames = null;

	@SuppressWarnings("unchecked")
	public   Class[] columnClasses = null;
	
	boolean[] canEdit = null;
	
	
	public TableModel(String[] columnNames,Class[] columnClasses,boolean[] canEdit,Vector<Vector<String>> tableDataList) 
	{
		
		this.columnNames = columnNames;
		this.columnClasses = columnClasses;
		this.canEdit = canEdit;
		this.tableDataList = tableDataList;
		
	}
	
	
	/**
	 * ��ñ���������
	 */
	public int getColumnCount()
	{
		return columnNames.length;
	}

	/**
	 * ��ñ���������
	 */
	public int getRowCount()
	{
		return tableDataList.size();
	}

	/**
	 * ��ñ��ָ����Ԫ���ֵ
	 * 
	 * @param row
	 *            ��
	 * @param column
	 *            ��
	 */
	public Object getValueAt(int row, int column)
	{
		Object value = null;

		// ���ָ����Ԫ��ǿ�
		if (!tableDataList.isEmpty())
		{
			value = tableDataList.elementAt(row).elementAt(column);
		}

		return value;
	}

	/**
	 * ���ָ���е�����
	 * 
	 * @param column
	 *            ָ������
	 */
	public String getColumnName(int column)
	{
		return columnNames[column];
	}

	/**
	 * ���ָ�����ж���
	 * 
	 * @param column
	 *            ָ������
	 */
	@SuppressWarnings("unchecked")
	public Class getColumnClass(int column)
	{
		return columnClasses[column];
	}

	/**
	 * ��ÿɱ༭�ĵ�Ԫ��
	 * 
	 * @param row
	 *            ��
	 * @param column
	 *            ��
	 */
	public boolean isCellEditable(int row, int column)
	{
		return canEdit[column];
	}

	/**
	 * ���ñ��ָ����Ԫ���ֵ
	 * 
	 * @param ֵ
	 * @param row
	 *            ��
	 * @param column
	 *            ��
	 */
	@SuppressWarnings("unchecked")
	public void setValueAt(Object value, int row, int column)
	{
		tableDataList.elementAt(row).setElementAt((String)value, column);
		fireTableDataChanged();
	}
	
	//============================================================================
	/**
	 * ��ʾ���µ�����������
	 * @return
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public void showNewRows(Vector<Vector<String>> newRecords)
	{
		tableDataList = newRecords;
		
		fireTableDataChanged();
	}
	/**
	 * ���ָ��������
	 * @param row
	 * @return
	 */
	public Vector<String> getRow(int row)
	{
		if(!tableDataList.isEmpty())
		{
			return tableDataList.elementAt(row);
		}
		return null;
	}
	/**
	 * �ڱ��ĩβ��������
	 * 
	 * @param rowCouont
	 *            ��Ҫ�������������
	 * @throws URISyntaxException 
	 * @throws IOException 
	 */
	public void insertRow(Vector<String> record,int newRowCount)
	{
		
		tableDataList.add(record);
		int rowCount = getRowCount();
		fireTableRowsInserted(rowCount - newRowCount, rowCount - 1);
	}
	
	
}

