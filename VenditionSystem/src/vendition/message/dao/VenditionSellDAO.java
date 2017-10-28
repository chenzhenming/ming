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
		// 定义链表,变量;
		List stockList = new ArrayList();
		ResultSet rs = null;
		// 定义SQL语句;
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
			// 连接数据库;
			de = new DBExecute();
			rs = de.executeQuery(sql);
			int i = 1;
			// 把返回值存入链表中;
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
			}// 异常处理;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("查询进货信息失败");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// 返回;
		return stockList;
	}

	public List querystockidMsg() throws DBException {
		// 定义链表,变量;
		List stockList = new ArrayList();
		ResultSet rs = null;
		// 定义SQL语句;
		String sql = "select sellid ";
		sql += "from sell ";
		DBExecute de = null;
		try {
			// 连接数据库;
			de = new DBExecute();
			rs = de.executeQuery(sql);
			// 把返回值存入链表中;
			while (rs.next()) {
				VenditionSellVO ev = new VenditionSellVO();
				ev.setSellid(rs.getString("sellid"));
				stockList.add(ev);
			}// 异常处理;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("查询进货信息失败");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// 返回;
		return stockList;
	}

	public int createStockMsg(VenditionCreSellVO sumv) throws DBException {
		// 把值存入数组中;
		Object[] ob = new Object[6];
		ob[0] = new Integer(sumv.getSellid());
		ob[1] = sumv.getWareid();
		ob[2] = sumv.getSelldate();
		ob[3] = new Integer(sumv.getSellamount());
		ob[4] = new Integer(sumv.getMoneysum());
		ob[5] = sumv.getOperator();

		// 定义SQL语句;
		String sql = "insert into sell(sellid,wareid,selldate,sellamount,moneysum,operator) values(?,?,?,?,?,?)";
		int cou = 0;
		DBExecute de = null;
		try {
			// 连接数据库;
			de = new DBExecute();
			cou = de.executeUpdate(sql, ob);
			// 异常处理;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DBException("添加出货信息失败");
		}// 返回;
		return cou;
	}

	public int queryStockCouMsg(String sellid) throws DBException {
		// 定义SQL语句;
		String sql = "select count(*) as cou from sell where sellid= ";
		sql += "'" + sellid + "'";
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
			throw new DBException("查询出货信息失败");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// 返回;
		return count;
	}

	public boolean upStockMsg(VenditionCreSellVO sumv) {
		boolean whereflag = false;
		// 把值存入数组中;
		Object[] ob = new Object[6];
		ob[0] = new Integer(sumv.getSellid());
		ob[1] = sumv.getWareid();
		ob[2] = sumv.getSelldate();
		ob[3] = new Integer(sumv.getSellamount());
		ob[4] = new Integer(sumv.getMoneysum());
		ob[5] = sumv.getOperator();
		// 生成SQL语句；
		String sql = "Update stock set sellid=? wareid=?,selldate=?,sellamount=?,moneysum=?,operator=? where sellid= ";
		sql += "'" + sumv.getSellid() + "'";
		DBExecute de = null;
		try {// 连接数据库；
			de = new DBExecute();
			de.executeUpdate(sql, ob);
			whereflag = true;
			// 异常处理；
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// 返回
		return whereflag;
	}
}
