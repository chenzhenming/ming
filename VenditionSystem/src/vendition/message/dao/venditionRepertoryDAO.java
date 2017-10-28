package vendition.message.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vendition.message.db.DBExecute;
import vendition.message.dbexception.DBException;
import vendition.message.vo.VenditionCreStockVO;
import vendition.message.vo.VenditionRepertoryVO;
import vendition.message.vo.VenditionWareMsgVO;

public class venditionRepertoryDAO {
	public int queryReperCouMsg(String wareid) throws DBException {
		// 定义SQL语句;
		String sql = "select count(*) as cou from repertory where wareid= ";
		sql += "'" + wareid + "'";
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
			throw new DBException("查询进货信息失败");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// 返回;
		return count;
	}

	public int createReperMsg(VenditionWareMsgVO sumv, int cou)
			throws DBException {
		// 把值存入数组中;
		Object[] ob = new Object[2];
		ob[0] = sumv.getWareid();
		ob[1] = new Integer(cou);
		// 定义SQL语句;
		String sql = "insert into repertory(wareid,storage) values(?,?)";
		int count = 0;
		DBExecute de = null;
		try {
			// 连接数据库;
			de = new DBExecute();
			count = de.executeUpdate(sql, ob);
			// 异常处理;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new DBException("添加进货信息失败");
		}// 返回;
		return count;
	}

	public boolean upStockMsg(VenditionWareMsgVO sumv, int cou) {
		boolean whereflag = false;
		// 把值存入数组中;
		Object[] ob = new Object[3];
		ob[0] = sumv.getWareid();
		ob[1] = new Integer(cou);
		ob[2] = sumv.getWareid();
		// 生成SQL语句；
		String sql = "Update repertory set wareid=?, storage=? where wareid=? ";
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

	public String queryReperCouMsgss(String wareid) throws DBException {
		// 定义SQL语句;
		String sql = "select storage from repertory where wareid= ";
		sql += "'" + wareid + "'";
		String count = null;
		ResultSet rs = null;
		DBExecute de = null;
		try {
			// 连接数据库;
			de = new DBExecute();
			rs = de.executeQuery(sql);
			while (rs.next()) {
				count = rs.getString("storage");
			}// 异常处理;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("查询进货信息失败");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// 返回;
		return count;
	}

	public List queryReperMsg(String wareid, String warename)
			throws DBException {
		// 定义链表,变量;
		List reperList = new ArrayList();
		List paramlist = new ArrayList();
		ResultSet rs = null;
		// 定义SQL语句;
		String sql = "select wm.wareid,wm.warename,wm.unit,wm.rate,re.storage from waremessage wm,repertory re ";
		sql += " where re.wareid = wm.wareid ";
		boolean whereFlag = false;
		if (wareid != null && !"".equals(wareid)) {
			paramlist.add("%" + wareid + "%");
			sql += "and re.wareid like ? ";

		}
		if (warename != null && !"".equals(warename)) {
			paramlist.add("%" + warename + "%");
			sql += "and warename like ? ";
		}

		DBExecute de = null;
		try {
			// 连接数据库;
			de = new DBExecute();
			rs = de.executeQuery(sql, paramlist.toArray());
			int i = 1;
			// 把返回值存入链表中;
			while (rs.next()) {
				VenditionRepertoryVO ev = new VenditionRepertoryVO();
				ev.setMark(i);
				ev.setWareid(rs.getString("wareid"));
				ev.setWarename(rs.getString("warename"));
				ev.setUnit(rs.getString("unit"));
				ev.setRate(rs.getString("rate"));
				ev.setStorage(rs.getInt("storage"));
				i++;
				reperList.add(ev);
			}// 异常处理;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("查询商品信息失败");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// 返回;
		return reperList;
	}
}
