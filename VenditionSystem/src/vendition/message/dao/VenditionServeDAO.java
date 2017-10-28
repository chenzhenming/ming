package vendition.message.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vendition.message.db.DBExecute;
import vendition.message.dbexception.DBException;
import vendition.message.vo.VenditionServeVO;
import vendition.message.vo.VenditionWareMsgVO;

public class VenditionServeDAO {
	public List queryServeMsg(String serveid) throws DBException {
		// ��������,����;
		List serveList = new ArrayList();
		List paramlist = new ArrayList();
		ResultSet rs = null;
		// ����SQL���;
		String sql = "select * from serveman ";
		boolean whereFlag = false;
		if (serveid != null && !"".equals(serveid)) {
			paramlist.add("%" + serveid + "%");
			sql += "where serveid like ? ";
			whereFlag = true;
		}
		DBExecute de = null;
		try {
			// �������ݿ�;
			de = new DBExecute();
			rs = de.executeQuery(sql, paramlist.toArray());
			int i = 1;
			// �ѷ���ֵ����������;
			while (rs.next()) {
				VenditionServeVO ev = new VenditionServeVO();
				ev.setMark(i);
				ev.setServeid(rs.getString("serveid"));
				ev.setServename(rs.getString("servename"));
				ev.setAddress(rs.getString("address"));
				ev.setLinkman(rs.getString("linkman"));
				ev.setPhone(rs.getString("phone"));
				ev.setBank(rs.getString("bank"));
				ev.setAccounts(rs.getString("accounts"));
				i++;
				serveList.add(ev);
			}// �쳣����;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("��ѯ��Ʒ��Ϣʧ��");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// ����;
		return serveList;
	}

	public int createServeMsg(VenditionServeVO sumv) throws DBException {
		// ��ֵ����������;
		Object[] ob = new Object[7];
		ob[0] = sumv.getServeid();
		ob[1] = sumv.getServename();
		ob[2] = sumv.getAddress();
		ob[3] = sumv.getLinkman();
		ob[4] = sumv.getPhone();
		ob[5] = sumv.getBank();
		ob[6] = sumv.getAccounts();
		// ����SQL���;
		String sql = "insert into serveman(serveid,servename,address,linkman,phone,bank,accounts) values(?,?,?,?,?,?,?)";
		int cou = 0;
		DBExecute de = null;
		try {
			// �������ݿ�;
			de = new DBExecute();
			cou = de.executeUpdate(sql, ob);
			// �쳣����;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DBException("���ѧԱ��Ϣʧ��");
		}// ����;
		return cou;
	}

	public boolean removeServeMsg(String[] serveId) throws DBException {
		// �������;
		boolean whereflag = false;
		// ����SQL���;
		String sql = "delete from serveman where serveid in ";
		sql += this.getdelFun(serveId);
		DBExecute de = null;
		try {
			// �������ݿ�;
			de = new DBExecute();
			de.executeUpdate(sql);
			whereflag = true;
			// �쳣����;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("ɾ��ʧ��");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// ����;
		return whereflag;

	}

	// ��ͬ�����,�����е�ֵ���ַ�����ʽ���;
	private String getdelFun(String[] userIds) {
		StringBuffer sbf = new StringBuffer();
		sbf.append("(");
		for (int i = 0; i < userIds.length - 1; i++) {
			sbf.append("'");
			sbf.append(userIds[i]);
			sbf.append("', ");
		}
		sbf.append("'");
		sbf.append(userIds[userIds.length - 1]);
		sbf.append("')");
		return sbf.toString();
	}

	public VenditionServeVO queryOnlyServeMsg(String serveid)
			throws DBException {
		// ��������,����;
		List serveList = new ArrayList();
		ResultSet rs = null;
		// ����SQL���;
		String sql = "select * from serveman where serveid = ";
		sql += "'" + serveid + "'";
		VenditionServeVO ev = new VenditionServeVO();
		DBExecute de = null;
		try {
			// �������ݿ�;
			de = new DBExecute();
			rs = de.executeQuery(sql);
			int i = 1;
			// �ѷ���ֵ����������;
			while (rs.next()) {
				ev.setServeid(rs.getString("serveid"));
				ev.setServename(rs.getString("servename"));
				ev.setAddress(rs.getString("address"));
				ev.setLinkman(rs.getString("linkman"));
				ev.setPhone(rs.getString("phone"));
				ev.setBank(rs.getString("bank"));
				ev.setAccounts(rs.getString("accounts"));
			}// �쳣����;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("��ѯ��Ʒ��Ϣʧ��");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// ����;
		return ev;
	}

	public boolean upServeMsg(VenditionServeVO sumv) {
		boolean whereflag = false;
		// ��ֵ����������;
		Object[] ob = new Object[7];
		ob[0] = sumv.getServeid();
		ob[1] = sumv.getServename();
		ob[2] = sumv.getAddress();
		ob[3] = sumv.getLinkman();
		ob[4] = sumv.getPhone();
		ob[5] = sumv.getBank();
		ob[6] = sumv.getAccounts();
		// ����SQL��䣻
		String sql = "Update serveman set serveid=?,servename=?,address=?,linkman=?,phone=?,bank=?,accounts=? where serveid= ";
		sql += "'" + sumv.getServeid() + "'";
		DBExecute de = null;
		try {// �������ݿ⣻
			de = new DBExecute();
			de.executeUpdate(sql, ob);
			whereflag = true;
			// �쳣����
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// ����
		return whereflag;
	}
}
