package vendition.message.dao;

import java.sql.ResultSet;

import vendition.message.db.DBExecute;
import vendition.message.dbexception.DBException;

public class VenditionLoginDAO {
	// ��ѯ����Ա��Ϣ;
	public int queryUserMsg(String userId, String password) throws DBException {
		// ����SQL���;
		String sql = "select count(*) as cou from userMsg where username= ";
		sql += "'" + userId + "'";
		sql += " and password= ";
		sql += "'" + password + "'";
		int count = 0;
		ResultSet rs = null;
		DBExecute de = null;
		try {
			// �������ݿ�;
			de = new DBExecute();
			rs = de.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("cou");
			}// �쳣����;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("��ѯ����Ա��Ϣʧ��");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// ����;
		return count;
	}

}
