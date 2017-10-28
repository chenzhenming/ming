package vendition.message.dao;

import java.sql.ResultSet;

import vendition.message.db.DBExecute;
import vendition.message.dbexception.DBException;

public class VenditionLoginDAO {
	// 查询管理员信息;
	public int queryUserMsg(String userId, String password) throws DBException {
		// 定义SQL语句;
		String sql = "select count(*) as cou from userMsg where username= ";
		sql += "'" + userId + "'";
		sql += " and password= ";
		sql += "'" + password + "'";
		int count = 0;
		ResultSet rs = null;
		DBExecute de = null;
		try {
			// 连接数据库;
			de = new DBExecute();
			rs = de.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("cou");
			}// 异常处理;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("查询管理员信息失败");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// 返回;
		return count;
	}

}
