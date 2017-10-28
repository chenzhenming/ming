package vendition.message.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import vendition.message.db.DBExecute;
import vendition.message.dbexception.DBException;
import vendition.message.vo.VenditionWareMsgVO;

public class VenditionWareDAO {
	public List queryMareMsg(String wareid, String warename) throws DBException {
		// 定义链表,变量;
		List mareList = new ArrayList();
		List paramlist = new ArrayList();
		ResultSet rs = null;
		// 定义SQL语句;
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
			// 连接数据库;
			de = new DBExecute();
			rs = de.executeQuery(sql, paramlist.toArray());
			int i = 1;
			// 把返回值存入链表中;
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
			}// 异常处理;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("查询商品信息失败");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// 返回;
		return mareList;
	}

	public int createWareMsg(VenditionWareMsgVO sumv) throws DBException {
		// 把值存入数组中;
		Object[] ob = new Object[5];
		ob[0] = sumv.getWareid();
		ob[1] = sumv.getWarename();
		ob[2] = sumv.getStandard();
		ob[3] = sumv.getUnit();
		ob[4] = sumv.getRate();
		// 定义SQL语句;
		String sql = "insert into waremessage(wareid,warename,standard,unit,rate) values(?,?,?,?,?)";
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
			throw new DBException("添加学员信息失败");
		}// 返回;
		return cou;
	}

	public boolean removeWareMsg(String[] wareId) throws DBException {
		// 定义变量;
		boolean whereflag = false;
		// 定义SQL语句;
		String sql = "delete from waremessage where wareid in ";
		sql += this.getdelFun(wareId);
		DBExecute de = null;
		try {
			// 连接数据库;
			de = new DBExecute();
			de.executeUpdate(sql);
			whereflag = true;
			// 异常处理;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("删除失败");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// 返回;
		return whereflag;

	}

	// 相同代码块,数组中的值以字符串行式输出;
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
		// 定义链表,变量;

		ResultSet rs = null;
		// 定义SQL语句;
		String sql = "select * from waremessage where wareid = ";
		boolean whereFlag = false;
		sql += "'" + wareid + "'";
		DBExecute de = null;
		VenditionWareMsgVO ev = new VenditionWareMsgVO();
		try {
			// 连接数据库;
			de = new DBExecute();
			rs = de.executeQuery(sql);
			int i = 1;
			// 把返回值存入链表中;
			while (rs.next()) {
				ev.setWareid(rs.getString("wareid"));
				ev.setWarename(rs.getString("warename"));
				ev.setStandard(rs.getString("standard"));
				ev.setUnit(rs.getString("unit"));
				ev.setRate(rs.getString("rate"));
			}// 异常处理;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("查询商品信息失败");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// 返回;
		return ev;
	}

	public boolean upStuMsg(VenditionWareMsgVO sumv) {
		boolean whereflag = false;
		// 把值存入数组中;
		Object[] ob = new Object[5];
		ob[0] = sumv.getWareid();
		ob[1] = sumv.getWarename();
		ob[2] = sumv.getStandard();
		ob[3] = sumv.getUnit();
		ob[4] = sumv.getRate();
		// 生成SQL语句；
		String sql = "Update waremessage set wareid=?,warename=?,standard=?,unit=?,rate=? where wareid= ";
		sql += "'" + sumv.getWareid() + "'";
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

	public VenditionWareMsgVO queryOnlyOneMareMsg(String warename)
			throws DBException {
		// 定义链表,变量;

		ResultSet rs = null;
		// 定义SQL语句;
		String sql = "select * from waremessage where warename = ";
		boolean whereFlag = false;
		sql += "'" + warename + "'";
		DBExecute de = null;
		VenditionWareMsgVO ev = new VenditionWareMsgVO();
		try {
			// 连接数据库;
			de = new DBExecute();
			rs = de.executeQuery(sql);
			int i = 1;
			// 把返回值存入链表中;
			while (rs.next()) {
				ev.setWareid(rs.getString("wareid"));
				ev.setWarename(rs.getString("warename"));
				ev.setStandard(rs.getString("standard"));
				ev.setUnit(rs.getString("unit"));
				ev.setRate(rs.getString("rate"));
			}// 异常处理;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new DBException("查询商品信息失败");
		} finally {
			if (de != null) {
				de.closeDBConection();
			}
		}// 返回;
		return ev;
	}
}
