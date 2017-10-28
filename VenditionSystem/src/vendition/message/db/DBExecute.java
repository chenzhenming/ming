package vendition.message.db;

/**
 * 数据库连接的共通方法的类；
 * DBExecute.java
 * @author dk
 * @version 2007
 */
import java.sql.*;

import vendition.message.dbexception.DBException;

public class DBExecute {
	/** 定义静态全局常量 */
	// 数据库驱动；
	private static final String DB_DRIVER = "com.microsoft.jdbc.sqlserver.SQLServerDriver";

	// 数据库地址；
	private static final String DB_URL = "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=jxc;SelectMethod=Cursor";

	// 数据库用户名；
	private static final String DB_USER = "sa";

	// 数据库密码；
	private static final String DB_PASSWORD = "123456";

	private Connection conn = null;

	/** 构造方法执行连接数据库 */
	public DBExecute() throws Exception {
		try {
			Class.forName(DB_DRIVER).newInstance();
			conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		}
		// 异常处理；
		catch (SQLException ex) {
			throw new DBException("数据库连接失败！", ex);
		}
		// 异常处理；
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 执行查询SQl语句(不带参数)
	 * 
	 * @param sql
	 *            String 要执行的SQL语句
	 * @throws DBException
	 * @return ResultSet 查询结果集
	 */
	public ResultSet executeQuery(String sql) throws DBException {
		// print sql for debugging；
		System.out.println(sql);
		// 定义变量；
		Statement stmt = null;
		ResultSet rs = null;
		try {
			// 建立连接；
			stmt = conn.createStatement();
			// 查询；
			rs = stmt.executeQuery(sql);
		} // 异常处理；
		catch (SQLException ex) {
			throw new DBException("数据库不带参数查询失败！", ex);
		}
		// 返回查询结果；
		return rs;
	}

	/**
	 * 执行查询SQl语句(带参数)
	 * 
	 * @param sql
	 *            String 要执行的SQL语句
	 * @throws DBException
	 * @return ResultSet 查询结果集
	 */
	public ResultSet executeQuery(String sql, Object[] paras)
			throws DBException {
		// print sql for debugging；
		System.out.println(sql);
		// 定义变量；
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 建立连接；
			pstmt = conn.prepareStatement(sql);
			// 调用共通方法处理数组；
			this.sameCode(pstmt, paras);
			// 执行；
			rs = pstmt.executeQuery();
		} // 异常处理；
		catch (SQLException ex) {
			throw new DBException("数据库带参数查询失败", ex);
		} // 返回查询结果；
		return rs;
	}

	/**
	 * 执行更新SQl语句(不带参数)
	 * 
	 * @param sql
	 *            String 要执行的SQL语句
	 * @throws DBException
	 * @return int
	 */
	public int executeUpdate(String sql) throws SQLException, DBException {
		// print sql for debugging；
		System.out.println(sql);
		// 定义变量；
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			// 建立连接；
			stmt = conn.createStatement();
			// 执行SQL语句；
			count = stmt.executeUpdate(sql);
		} // 异常处理；
		catch (SQLException ex) {
			throw new DBException("数据库不带参数更新失败！", ex);
		} // 返回执行结果；
		return count;
	}

	/**
	 * 执行更新SQl语句(带参数)
	 * 
	 * @param sql
	 *            String 要执行的SQL语句
	 * @throws DBException
	 * @return int
	 */
	public int executeUpdate(String sql, Object[] param) throws SQLException,
			DBException {
		// print sql for debugging；
		System.out.println(sql);
		// 定义变量；
		int num = 0;
		PreparedStatement pstmt = null;
		try {
			if (param != null) {
				// 建立连接；
				pstmt = conn.prepareStatement(sql);
				// 调用共通方法处理数组；
				this.sameCode(pstmt, param);
				// 执行；
				num = pstmt.executeUpdate();
			}
		} // 异常处理；
		catch (SQLException ex) {
			throw new DBException("数据库带参数更新失败！", ex);
		} // 返回执行结果；
		return num;
	}

	/**
	 * 计算表名为tableName的表中满足属性名为attrName,属性值为attrValue的纪录条数. 该方法需要数据库对count()函数的支持
	 * 
	 * @param attrName
	 *            String 属性名
	 * @param attrValue
	 *            Object 属性值
	 * @param tableName
	 *            String 表名
	 * @throws DBException
	 * @return int 纪录条数
	 */
	public int countAttribute(String attrName, String tableName,
			Object attrValue) throws DBException {
		// 生成SQL语句；
		String sql = "select count(*) as cou from " + tableName + " where "
				+ attrName + "=";
		// 判断attrValue是否为String类型；
		if (attrValue instanceof String) {
			sql += "'" + attrValue + "'";
		} else {
			sql += attrValue;
		}
		// print sql for debugging；
		System.out.println(sql);
		// 定义变量；
		Statement stmt = null;
		ResultSet rs = null;
		int count = 0;
		try {
			// 建立连接；
			stmt = conn.createStatement();
			// 执行SQL语句；
			rs = stmt.executeQuery(sql);
			// 取得查询返回值；
			if (rs.next()) {
				count = rs.getInt("cou");
			}
		} // 异常处理；
		catch (SQLException ex) {
			new DBException("数据库查询记录条数失败！", ex);
		} // 返回执行结果；
		return count;
	}

	/**
	 * 事务开始
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
	 * 事务提交
	 * 
	 * @throws DBException
	 */
	public void transactionCommit() throws DBException {
		try {
			// 事务提交；
			conn.commit();
			conn.setAutoCommit(true);
		} // 异常处理；
		catch (SQLException ex) {
			throw new DBException("error when set transaction commit:"
					+ ex.getMessage(), ex);
		}
	}

	/**
	 * 事务回滚
	 */
	public void transactionRollback() {
		try {
			// 事务回滚；
			conn.rollback();
		} // 异常处理；
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 得到当前数据库事务状态
	 * 
	 * @throws DBException
	 * @return boolean 返回true,表示事务已经提交 返回fasle,表示事务尚没有提交
	 */
	public boolean getTransactionStatus() throws DBException {
		try {
			// 返回结果；
			return conn.getAutoCommit();
		} // 异常处理；
		catch (SQLException ex) {
			throw new DBException("error when get transaction status:"
					+ ex.getMessage(), ex);
		}
	}

	/**
	 * 关闭数据库连接
	 */
	public void closeDBConection() {
		// 判断连接；
		if (conn != null) {
			try {
				// 关闭连接；
				conn.close();
			} // 异常处理；
			catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * 实现Object数组表示的参数列表和SQL语句中的"?"绑定
	 * 
	 * @param pstmt
	 *            PreparedStatement
	 * @param paras
	 *            Object[]
	 * @throws SQLException
	 */
	public void sameCode(PreparedStatement pstmt, Object[] param)
			throws SQLException {
		// 判断数组是否为空；
		if (param != null) {
			// 不为空循环；
			for (int i = 0; i < param.length; i++) {
				// 判断数组键值是否为空；
				if (param[i] == null) {
					pstmt.setNull(i + 1, java.sql.Types.VARCHAR);
				} else {
					pstmt.setObject(i + 1, param[i]);
				}
			}
		}
	}

}
