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

/** ���낢��ȃf�[�^�]������N���X�ł� */
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
		/** �l�𔻒f���� */
		if (year <= 0 || month <= 0 || date <= 0) {
			/** �߂� */
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.set(year, month - 1, date);
		/** �߂� */
		return calendar.getTime();
	}

	/**
	 * year�āEString)month(String)date(String)--java.util.Date
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
		/** �l�𔻒f���� */
		if ((year == null || "".equals(year))
				|| (month == null || "".equals(month))
				|| (date == null || "".equals(date))) {
			/** �߂� */
			return null;
		}
		Calendar calendar = Calendar.getInstance();
		try {
			calendar.set(Integer.parseInt(year), Integer.parseInt(month) - 1,
					Integer.parseInt(date));
			/** �ُ폈�� */
		} catch (Exception ex) {
			// uncheck exception
			throw new IllegalArgumentException("error date format");
		}
		/** �߂� */
		return calendar.getTime();
	}

	public static java.sql.Date date2SQLDate(Date date) {
		/** �l�𔻒f���� */
		if (date == null) {
			/** �߂� */
			return null;
		}
		/** �߂� */
		return new java.sql.Date(date.getTime());
	}

	public static Date string2Date(String str) {
		/** �ϐ����`���� */
		String year = str.substring(0, 4);
		String month = str.substring(5, 7);
		String date = str.substring(8, 10);
		/** �߂� */
		return getDateByTime(year, month, date);
	}

	public static java.sql.Date string2SQLDate(String str) {
		/** �߂� */
		return date2SQLDate(string2Date(str));
	}

}
