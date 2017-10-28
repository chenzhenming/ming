package vendition.message.db;

/**
 * ���ݿ����ӵĹ�ͨ�������ࣻ
 * DBExecute.java
 * @author dk
 * @version 2007
 */
import java.sql.*;

import vendition.message.dbexception.DBException;

public class DBExecute {
	/** ���徲̬ȫ�ֳ��� */
	// ���ݿ�������
	private static final String DB_DRIVER = "com.microsoft.jdbc.sqlserver.SQLServerDriver";

	// ���ݿ��ַ��
	private static final String DB_URL = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=jxc;SelectMethod=Cursor";

	// ���ݿ��û�����
	private static final String DB_USER = "sa";

	// ���ݿ����룻
	private static final String DB_PASSWORD = "123456";

	private Connection conn = null;

	/** ���췽��ִ���������ݿ� */
	public DBExecute() throws Exception {
		try {
			Class.forName(DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		}
		// �쳣����
		catch (SQLException ex) {
			throw new DBException("���ݿ�����ʧ�ܣ�", ex);
		}
		// �쳣����
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * ִ�в�ѯSQl���(��������)
	 * 
	 * @param sql
	 *            String Ҫִ�е�SQL���
	 * @throws DBException
	 * @return ResultSet ��ѯ�����
	 */
	public ResultSet executeQuery(String sql) throws DBException {
		// print sql for debugging��
		System.out.println(sql);
		// ���������
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// �������ӣ�
			stmt = conn.createStatement();
			// ��ѯ��
			rs = stmt.executeQuery(sql);
		} // �쳣����
		catch (SQLException ex) {
			throw new DBException("���ݿⲻ��������ѯʧ�ܣ�", ex);
		}
		// ���ز�ѯ�����
		return rs;
	}

	/**
	 * ִ�в�ѯSQl���(������)
	 * 
	 * @param sql
	 *            String Ҫִ�е�SQL���
	 * @throws DBException
	 * @return ResultSet ��ѯ�����
	 */
	public ResultSet executeQuery(String sql, Object[] paras)
			throws DBException {
		// print sql for debugging��
		System.out.println(sql);
		// ���������
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// �������ӣ�
			pstmt = conn.prepareStatement(sql);
			// ���ù�ͨ�����������飻
			this.sameCode(pstmt, paras);
			// ִ�У�
			rs = pstmt.executeQuery();
		} // �쳣����
		catch (SQLException ex) {
			throw new DBException("���ݿ��������ѯʧ��", ex);
		} // ���ز�ѯ�����
		return rs;
	}

	/**
	 * ִ�и���SQl���(��������)
	 * 
	 * @param sql
	 *            String Ҫִ�е�SQL���
	 * @throws DBException
	 * @return int
	 */
	public int executeUpdate(String sql) throws SQLException, DBException {
		// print sql for debugging��
		System.out.println(sql);
		// ���������
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			// �������ӣ�
			stmt = conn.createStatement();
			// ִ��SQL��䣻
			count = stmt.executeUpdate(sql);
		} // �쳣����
		catch (SQLException ex) {
			throw new DBException("���ݿⲻ����������ʧ�ܣ�", ex);
		} // ����ִ�н����
		return count;
	}

	/**
	 * ִ�и���SQl���(������)
	 * 
	 * @param sql
	 *            String Ҫִ�е�SQL���
	 * @throws DBException
	 * @return int
	 */
	public int executeUpdate(String sql, Object[] param) throws SQLException,
			DBException {
		// print sql for debugging��
		System.out.println(sql);
		// ���������
		int num = 0;
		PreparedStatement pstmt = null;
		try {
			if (param != null) {
				// �������ӣ�
				pstmt = conn.prepareStatement(sql);
				// ���ù�ͨ�����������飻
				this.sameCode(pstmt, param);
				// ִ�У�
				num = pstmt.executeUpdate();
			}
		} // �쳣����
		catch (SQLException ex) {
			throw new DBException("���ݿ����������ʧ�ܣ�", ex);
		} // ����ִ�н����
		return num;
	}

	/**
	 * �������ΪtableName�ı�������������ΪattrName,����ֵΪattrValue�ļ�¼����. �÷�����Ҫ���ݿ��count()������֧��
	 * 
	 * @param attrName
	 *            String ������
	 * @param attrValue
	 *            Object ����ֵ
	 * @param tableName
	 *            String ����
	 * @throws DBException
	 * @return int ��¼����
	 */
	public int countAttribute(String attrName, String tableName,
			Object attrValue) throws DBException {
		// ����SQL��䣻
		String sql = "select count(*) as cou from " + tableName + " where "
				+ attrName + "=";
		// �ж�attrValue�Ƿ�ΪString���ͣ�
		if (attrValue instanceof String) {
			sql += "'" + attrValue + "'";
		} else {
			sql += attrValue;
		}
		// print sql for debugging��
		System.out.println(sql);
		// ���������
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			// �������ӣ�
			stmt = conn.createStatement();
			// ִ��SQL��䣻
			rs = stmt.executeQuery(sql);
			// ȡ�ò�ѯ����ֵ��
			if (rs.next()) {
				count = rs.getInt("cou");
			}
		} // �쳣����
		catch (SQLException ex) {
			new DBException("���ݿ��ѯ��¼����ʧ�ܣ�", ex);
		} // ����ִ�н����
		return count;
	}

	/**
	 * ����ʼ
	 * 
	 * @throws DBException
	 */
	public void transactionBegin() throws DBException {
		try {
			conn.setAutoCommit(false);
		} catch (SQLException ex) {
			throw new DBException("error when set transaction begin:"
					+ ex.getMessage(), ex);
		}
	}

	/**
	 * �����ύ
	 * 
	 * @throws DBException
	 */
	public void transactionCommit() throws DBException {
		try {
			// �����ύ��
			conn.commit();
			conn.setAutoCommit(true);
		} // �쳣����
		catch (SQLException ex) {
			throw new DBException("error when set transaction commit:"
					+ ex.getMessage(), ex);
		}
	}

	/**
	 * ����ع�
	 */
	public void transactionRollback() {
		try {
			// ����ع���
			conn.rollback();
		} // �쳣����
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * �õ���ǰ���ݿ�����״̬
	 * 
	 * @throws DBException
	 * @return boolean ����true,��ʾ�����Ѿ��ύ ����fasle,��ʾ������û���ύ
	 */
	public boolean getTransactionStatus() throws DBException {
		try {
			// ���ؽ����
			return conn.getAutoCommit();
		} // �쳣����
		catch (SQLException ex) {
			throw new DBException("error when get transaction status:"
					+ ex.getMessage(), ex);
		}
	}

	/**
	 * �ر����ݿ�����
	 */
	public void closeDBConection() {
		// �ж����ӣ�
		if (conn != null) {
			try {
				// �ر����ӣ�
				conn.close();
			} // �쳣����
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * ʵ��Object�����ʾ�Ĳ����б��SQL����е�"?"��
	 * 
	 * @param pstmt
	 *            PreparedStatement
	 * @param paras
	 *            Object[]
	 * @throws SQLException
	 */
	public void sameCode(PreparedStatement pstmt, Object[] param)
			throws SQLException {
		// �ж������Ƿ�Ϊ�գ�
		if (param != null) {
			// ��Ϊ��ѭ����
			for (int i = 0; i < param.length; i++) {
				// �ж������ֵ�Ƿ�Ϊ�գ�
				if (param[i] == null) {
					pstmt.setNull(i + 1, java.sql.Types.VARCHAR);
				} else {
					pstmt.setObject(i + 1, param[i]);
				}
			}
		}
	}

}
