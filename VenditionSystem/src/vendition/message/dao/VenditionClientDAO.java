package vendition.message.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vendition.message.db.DBExecute;
import vendition.message.dbexception.DBException;
import vendition.message.vo.VenditionClientVO;
import vendition.message.vo.VenditionServeVO;

public class VenditionClientDAO {
	public List queryClientMsg(String clientid) throws DBException {
		// ��������,����;
		List clientList = new ArrayList();
		ResultSet rs = null;
		// ����SQL���;
		String sql = "select * from client ";
		if (clientid != null && !"".equals(clientid)) {
			sql += "where clientid like ";
			sql += "'" + clientid + "%'";
		}
		DBExecute de = null;
		try {
			// �������ݿ�;
			de = new DBExecute();
			rs = de.executeQuery(sql);
			int i = 1;
			// �ѷ���ֵ����������;
			while (rs.next()) {
				VenditionClientVO ev = new VenditionClientVO();
				ev.setMark(i);
				ev.setClientid(rs.getString("clientid"));
				ev.setClientname(rs.getString("clientname"));
				ev.setAddress(rs.getString("address"));
				ev.setLinkman(rs.getString("linkman"));
				ev.setPhone(rs.getString("phone"));
				ev.setBank(rs.getString("bank"));
				ev.setAccounts(rs.getString("accounts"));
				i++;
				clientList.add(ev);
			}// �쳣����;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("��ѯ��Ʒ��Ϣʧ��");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// ����;
		return clientList;
	}

	public int createClientMsg(VenditionClientVO sumv) throws DBException {
		// ��ֵ����������;
		Object[] ob = new Object[7];
		ob[0] = sumv.getClientid();
		ob[1] = sumv.getClientname();
		ob[2] = sumv.getAddress();
		ob[3] = sumv.getLinkman();
		ob[4] = sumv.getPhone();
		ob[5] = sumv.getBank();
		ob[6] = sumv.getAccounts();
		// ����SQL���;
		String sql = "insert into client(clientid,clientname,address,linkman,phone,bank,accounts) values(?,?,?,?,?,?,?)";
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

	public boolean removeClientMsg(String[] clientId) throws DBException {
		// �������;
		boolean whereflag = false;
		// ����SQL���;
		String sql = "delete from client where clientid in ";
		sql += this.getdelFun(clientId);
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

	public VenditionClientVO queryOnlyClientMsg(String clientid)
			throws DBException {
		// ��������,����;
		ResultSet rs = null;
		// ����SQL���;
		String sql = "select * from client ";
		sql += "where clientid = ";
		sql += "'" + clientid + "'";
		DBExecute de = null;
		VenditionClientVO ev = new VenditionClientVO();
		try {
			// �������ݿ�;
			de = new DBExecute();
			rs = de.executeQuery(sql);
			int i = 1;
			// �ѷ���ֵ����������;
			while (rs.next()) {
				ev.setClientid(rs.getString("clientid"));
				ev.setClientname(rs.getString("clientname"));
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

	public boolean upClientMsg(VenditionClientVO sumv) {
		boolean whereflag = false;
		// ��ֵ����������;
		Object[] ob = new Object[7];
		ob[0] = sumv.getClientid();
		ob[1] = sumv.getClientname();
		ob[2] = sumv.getAddress();
		ob[3] = sumv.getLinkman();
		ob[4] = sumv.getPhone();
		ob[5] = sumv.getBank();
		ob[6] = sumv.getAccounts();
		// ����SQL��䣻
		String sql = "Update client set clientid=?,clientname=?,address=?,linkman=?,phone=?,bank=?,accounts=? where clientid= ";
		sql += "'" + sumv.getClientid() + "'";
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
