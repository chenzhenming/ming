/**
 * 
 * DateTool.java
 * 
 * @author dk
 * @version 2007
 *
 */
package vendition.message.util;

import java.util.Calendar;
import java.util.Date;

/** いろいろなデータ転換するクラスです */
public final class DateTool {

	public DateTool() {
	}

	/**
	 * @param year
	 * 
	 * @param month
	 * 
	 * @param date
	 * 
	 * @return Date
	 */
	public static java.util.Date getDateByTime(int year, int month, int date) {
		/** 値を判断する */
		if (year <= 0 || month <= 0 || date <= 0) {
			/** 戻る */
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, date);
		/** 戻る */
		return calendar.getTime();
	}

	/**
	 * year・String)month(String)date(String)--java.util.Date
	 * 
	 * @param year
	 *            String
	 * @param month
	 *            String
	 * @param date
	 *            String
	 * @return Date
	 */
	public static java.util.Date getDateByTime(String year, String month,
			String date) {
		/** 値を判断する */
		if ((year == null || "".equals(year))
				|| (month == null || "".equals(month))
				|| (date == null || "".equals(date))) {
			/** 戻る */
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1,
					Integer.parseInt(date));
			/** 異常処理 */
		} catch (Exception ex) {
			// uncheck exception
			throw new IllegalArgumentException("error date format");
		}
		/** 戻る */
		return calendar.getTime();
	}

	public static java.sql.Date date2SQLDate(Date date) {
		/** 値を判断する */
		if (date == null) {
			/** 戻る */
			return null;
		}
		/** 戻る */
		return new java.sql.Date(date.getTime());
	}

	public static Date string2Date(String str) {
		/** 変数を定義する */
		String year = str.substring(0, 4);
		String month = str.substring(5, 7);
		String date = str.substring(8, 10);
		/** 戻る */
		return getDateByTime(year, month, date);
	}

	public static java.sql.Date string2SQLDate(String str) {
		/** 戻る */
		return date2SQLDate(string2Date(str));
	}

}
