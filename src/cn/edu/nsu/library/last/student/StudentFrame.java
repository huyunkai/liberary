/*
 * StudentFrame.java
 *
 * Created on __DATE__, __TIME__
 */

package cn.edu.nsu.library.last.student;

/**
 *
 * @author  __USER__
 */
public class StudentFrame extends javax.swing.JFrame {

	/** Creates new form StudentFrame */
	public StudentFrame() {
		initComponents();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	//GEN-BEGIN:initComponents
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {
		java.awt.GridBagConstraints gridBagConstraints;

		jPanel1 = new javax.swing.JPanel();
		jLabel_title = new javax.swing.JLabel();
		jLabel_subhead = new javax.swing.JLabel();
		jLabel_logo = new javax.swing.JLabel();
		jButton_bookInquire = new javax.swing.JButton();
		jButton_borrowInquire = new javax.swing.JButton();
		jButton_modifyPassword = new javax.swing.JButton();
		jButton_return = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		getContentPane().setLayout(new java.awt.GridBagLayout());

		jPanel1.setLayout(new java.awt.GridBagLayout());

		jLabel_title.setFont(new java.awt.Font("����", 3, 24));
		jLabel_title.setForeground(new java.awt.Color(51, 51, 255));
		jLabel_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel_title.setText("\u56fe\u4e66\u7ba1\u7406\u7cfb\u7edf");
		jLabel_title.setBorder(javax.swing.BorderFactory.createLineBorder(
				new java.awt.Color(0, 153, 255), 3));
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.ipadx = 300;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
		jPanel1.add(jLabel_title, gridBagConstraints);

		jLabel_subhead.setFont(new java.awt.Font("��Բ", 3, 14));
		jLabel_subhead.setForeground(new java.awt.Color(0, 0, 255));
		jLabel_subhead.setText("\u8bfb\u8005\u7ba1\u7406\u754c\u9762");
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.gridwidth = 2;
		gridBagConstraints.ipadx = 10;
		gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 0);
		jPanel1.add(jLabel_subhead, gridBagConstraints);

		jLabel_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource(
				"/Image/neusoft.png"))); // NOI18N
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridheight = 3;
		gridBagConstraints.insets = new java.awt.Insets(20, 20, 20, 20);
		jPanel1.add(jLabel_logo, gridBagConstraints);

		jButton_bookInquire.setText("\u56fe\u4e66\u67e5\u8be2");
		jButton_bookInquire.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 153), 3));
		jButton_bookInquire.setContentAreaFilled(false);
		jButton_bookInquire
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButton_bookInquireActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.ipadx = 40;
		gridBagConstraints.ipady = 20;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(40, 20, 40, 0);
		jPanel1.add(jButton_bookInquire, gridBagConstraints);

		jButton_borrowInquire.setText("\u501f\u9605\u67e5\u8be2");
		jButton_borrowInquire.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 153), 3));
		jButton_borrowInquire.setContentAreaFilled(false);
		jButton_borrowInquire
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButton_borrowInquireActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 3;
		gridBagConstraints.ipadx = 40;
		gridBagConstraints.ipady = 20;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(40, 20, 40, 0);
		jPanel1.add(jButton_borrowInquire, gridBagConstraints);

		jButton_modifyPassword.setText("\u4fee\u6539\u5bc6\u7801");
		jButton_modifyPassword.setBorder(javax.swing.BorderFactory
				.createLineBorder(new java.awt.Color(0, 0, 153), 3));
		jButton_modifyPassword.setBorderPainted(false);
		jButton_modifyPassword.setContentAreaFilled(false);
		jButton_modifyPassword
				.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						jButton_modifyPasswordActionPerformed(evt);
					}
				});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new java.awt.Insets(0, 70, 0, 0);
		jPanel1.add(jButton_modifyPassword, gridBagConstraints);

		jButton_return.setText("\u8fd4\u56de");
		jButton_return.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton_returnActionPerformed(evt);
			}
		});
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 4;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
		jPanel1.add(jButton_return, gridBagConstraints);

		getContentPane().add(jPanel1, new java.awt.GridBagConstraints());

		pack();
	}// </editor-fold>
	//GEN-END:initComponents

	private void jButton_borrowInquireActionPerformed(
			java.awt.event.ActionEvent evt) {
		this.dispose();
		BorrowInquire borrowInquire = new BorrowInquire();
		borrowInquire.setVisible(true);
	}

	private void jButton_bookInquireActionPerformed(
			java.awt.event.ActionEvent evt) {
		this.dispose();
		BookInquire bookInquire = new BookInquire();
		bookInquire.setVisible(true);
	}

	private void jButton_modifyPasswordActionPerformed(
			java.awt.event.ActionEvent evt) {
		this.dispose();
		ModifyPassword modifyPassword = new ModifyPassword();
		modifyPassword.setVisible(true);
	}

	private void jButton_returnActionPerformed(java.awt.event.ActionEvent evt) {
		this.dispose();
		StudentLogin studentLogin = new StudentLogin();
		studentLogin.setVisible(true);
	}

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new StudentFrame().setVisible(true);
			}
		});
	}

	//GEN-BEGIN:variables
	// Variables declaration - do not modify
	private javax.swing.JButton jButton_bookInquire;
	private javax.swing.JButton jButton_borrowInquire;
	private javax.swing.JButton jButton_modifyPassword;
	private javax.swing.JButton jButton_return;
	private javax.swing.JLabel jLabel_logo;
	private javax.swing.JLabel jLabel_subhead;
	private javax.swing.JLabel jLabel_title;
	private javax.swing.JPanel jPanel1;
	// End of variables declaration//GEN-END:variables

}