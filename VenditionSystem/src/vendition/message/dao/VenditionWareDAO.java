package vendition.message.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vendition.message.db.DBExecute;
import vendition.message.dbexception.DBException;
import vendition.message.vo.VenditionWareMsgVO;

public class VenditionWareDAO {
	public List queryMareMsg(String wareid, String warename) throws DBException {
		// ��������,����;
		List mareList = new ArrayList();
		List paramlist = new ArrayList();
		ResultSet rs = null;
		// ����SQL���;
		String sql = "select * from waremessage ";
		boolean whereFlag = false;
		if (wareid != null && !"".equals(wareid)) {
			paramlist.add("%" + wareid + "%");
			sql += "where wareid like ? ";
			whereFlag = true;
		}
		if (warename != null && !"".equals(warename)) {
			paramlist.add("%" + warename + "%");
			if (whereFlag) {
				sql += "and warename like ? ";
			} else {
				sql += "where warename like ? ";
			}
		}
		DBExecute de = null;
		try {
			// �������ݿ�;
			de = new DBExecute();
			rs = de.executeQuery(sql, paramlist.toArray());
			int i = 1;
			// �ѷ���ֵ����������;
			while (rs.next()) {
				VenditionWareMsgVO ev = new VenditionWareMsgVO();
				ev.setMark(i);
				ev.setWareid(rs.getString("wareid"));
				ev.setWarename(rs.getString("warename"));
				ev.setStandard(rs.getString("standard"));
				ev.setUnit(rs.getString("unit"));
				ev.setRate(rs.getString("rate"));
				i++;
				mareList.add(ev);
			}// �쳣����;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("��ѯ��Ʒ��Ϣʧ��");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// ����;
		return mareList;
	}

	public int createWareMsg(VenditionWareMsgVO sumv) throws DBException {
		// ��ֵ����������;
		Object[] ob = new Object[5];
		ob[0] = sumv.getWareid();
		ob[1] = sumv.getWarename();
		ob[2] = sumv.getStandard();
		ob[3] = sumv.getUnit();
		ob[4] = sumv.getRate();
		// ����SQL���;
		String sql = "insert into waremessage(wareid,warename,standard,unit,rate) values(?,?,?,?,?)";
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

	public boolean removeWareMsg(String[] wareId) throws DBException {
		// �������;
		boolean whereflag = false;
		// ����SQL���;
		String sql = "delete from waremessage where wareid in ";
		sql += this.getdelFun(wareId);
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

	public VenditionWareMsgVO queryOnlyMareMsg(String wareid)
			throws DBException {
		// ��������,����;

		ResultSet rs = null;
		// ����SQL���;
		String sql = "select * from waremessage where wareid = ";
		boolean whereFlag = false;
		sql += "'" + wareid + "'";
		DBExecute de = null;
		VenditionWareMsgVO ev = new VenditionWareMsgVO();
		try {
			// �������ݿ�;
			de = new DBExecute();
			rs = de.executeQuery(sql);
			int i = 1;
			// �ѷ���ֵ����������;
			while (rs.next()) {
				ev.setWareid(rs.getString("wareid"));
				ev.setWarename(rs.getString("warename"));
				ev.setStandard(rs.getString("standard"));
				ev.setUnit(rs.getString("unit"));
				ev.setRate(rs.getString("rate"));
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

	public boolean upStuMsg(VenditionWareMsgVO sumv) {
		boolean whereflag = false;
		// ��ֵ����������;
		Object[] ob = new Object[5];
		ob[0] = sumv.getWareid();
		ob[1] = sumv.getWarename();
		ob[2] = sumv.getStandard();
		ob[3] = sumv.getUnit();
		ob[4] = sumv.getRate();
		// ����SQL��䣻
		String sql = "Update waremessage set wareid=?,warename=?,standard=?,unit=?,rate=? where wareid= ";
		sql += "'" + sumv.getWareid() + "'";
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

	public VenditionWareMsgVO queryOnlyOneMareMsg(String warename)
			throws DBException {
		// ��������,����;

		ResultSet rs = null;
		// ����SQL���;
		String sql = "select * from waremessage where warename = ";
		boolean whereFlag = false;
		sql += "'" + warename + "'";
		DBExecute de = null;
		VenditionWareMsgVO ev = new VenditionWareMsgVO();
		try {
			// �������ݿ�;
			de = new DBExecute();
			rs = de.executeQuery(sql);
			int i = 1;
			// �ѷ���ֵ����������;
			while (rs.next()) {
				ev.setWareid(rs.getString("wareid"));
				ev.setWarename(rs.getString("warename"));
				ev.setStandard(rs.getString("standard"));
				ev.setUnit(rs.getString("unit"));
				ev.setRate(rs.getString("rate"));
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
}
