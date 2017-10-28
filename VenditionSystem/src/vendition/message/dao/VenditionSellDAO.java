package vendition.message.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vendition.message.db.DBExecute;
import vendition.message.dbexception.DBException;
import vendition.message.form.VenditionQrySellMsgForm;
import vendition.message.form.VenditionQryStockMsgForm;
import vendition.message.vo.VenditionCreSellVO;
import vendition.message.vo.VenditionCreStockVO;
import vendition.message.vo.VenditionSellVO;
import vendition.message.vo.venditionStockVO;

public class VenditionSellDAO {
	public List queryStockMsg(String wareid, String warename,
			VenditionQrySellMsgForm squf) throws DBException {
		// ��������,����;
		List stockList = new ArrayList();
		ResultSet rs = null;
		// ����SQL���;
		String sql = "select sk.sellid,sk.wareid,wm.warename,wm.standard,wm.unit,wm.rate,";
		sql += "sk.selldate,sk.sellamount,sk.moneysum,sk.operator ";
		sql += "from sell as sk,waremessage as wm ";
		sql += "where sk.wareid = wm.wareid ";
		if (wareid != null && !"".equals(wareid)) {
			sql += "and sk.wareid like ";
			sql += "'" + wareid + "%'";
		}
		if (warename != null && !"".equals(warename)) {
			sql += "and wm.warename like ";
			sql += "'" + warename + "%'";
		}
		if (squf != null) {
			if (squf.getSelldateYear() != null
					&& !"".equals(squf.getSelldateYear())) {
				sql += "and sk.selldate = ";
				sql += "'" + squf.getSelldateYear() + "-"
						+ squf.getSelldateMon() + "-" + squf.getSelldateDay()
						+ "'";
			}
		}
		DBExecute de = null;
		try {
			// �������ݿ�;
			de = new DBExecute();
			rs = de.executeQuery(sql);
			int i = 1;
			// �ѷ���ֵ����������;
			while (rs.next()) {
				VenditionSellVO ev = new VenditionSellVO();
				ev.setSellid(rs.getString("sellid"));
				ev.setWareid(rs.getString("wareid"));
				ev.setWarename(rs.getString("warename"));
				ev.setStandard(rs.getString("standard"));
				ev.setUnit(rs.getString("unit"));
				ev.setRate(rs.getString("rate"));
				ev.setSelldate(rs.getDate("selldate"));
				ev.setSellamount(rs.getString("sellamount"));
				ev.setMoneysum(rs.getString("moneysum"));
				ev.setOperator(rs.getString("operator"));
				stockList.add(ev);
			}// �쳣����;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("��ѯ������Ϣʧ��");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// ����;
		return stockList;
	}

	public List querystockidMsg() throws DBException {
		// ��������,����;
		List stockList = new ArrayList();
		ResultSet rs = null;
		// ����SQL���;
		String sql = "select sellid ";
		sql += "from sell ";
		DBExecute de = null;
		try {
			// �������ݿ�;
			de = new DBExecute();
			rs = de.executeQuery(sql);
			// �ѷ���ֵ����������;
			while (rs.next()) {
				VenditionSellVO ev = new VenditionSellVO();
				ev.setSellid(rs.getString("sellid"));
				stockList.add(ev);
			}// �쳣����;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("��ѯ������Ϣʧ��");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// ����;
		return stockList;
	}

	public int createStockMsg(VenditionCreSellVO sumv) throws DBException {
		// ��ֵ����������;
		Object[] ob = new Object[6];
		ob[0] = new Integer(sumv.getSellid());
		ob[1] = sumv.getWareid();
		ob[2] = sumv.getSelldate();
		ob[3] = new Integer(sumv.getSellamount());
		ob[4] = new Integer(sumv.getMoneysum());
		ob[5] = sumv.getOperator();

		// ����SQL���;
		String sql = "insert into sell(sellid,wareid,selldate,sellamount,moneysum,operator) values(?,?,?,?,?,?)";
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
			throw new DBException("��ӳ�����Ϣʧ��");
		}// ����;
		return cou;
	}

	public int queryStockCouMsg(String sellid) throws DBException {
		// ����SQL���;
		String sql = "select count(*) as cou from sell where sellid= ";
		sql += "'" + sellid + "'";
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
			throw new DBException("��ѯ������Ϣʧ��");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// ����;
		return count;
	}

	public boolean upStockMsg(VenditionCreSellVO sumv) {
		boolean whereflag = false;
		// ��ֵ����������;
		Object[] ob = new Object[6];
		ob[0] = new Integer(sumv.getSellid());
		ob[1] = sumv.getWareid();
		ob[2] = sumv.getSelldate();
		ob[3] = new Integer(sumv.getSellamount());
		ob[4] = new Integer(sumv.getMoneysum());
		ob[5] = sumv.getOperator();
		// ����SQL��䣻
		String sql = "Update stock set sellid=? wareid=?,selldate=?,sellamount=?,moneysum=?,operator=? where sellid= ";
		sql += "'" + sumv.getSellid() + "'";
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
