package vendition.message.dbexception;

/**
 * ���ݿ���ܳ����쳣���ࣻ
 * DBException.java
 * @author dk
 * @version 2007
 */
/** ���ݿ��쳣�� */
public class DBException extends Exception {
	/** ���ø��๹�췽�� */
	public DBException() {
		super();
	}

	/** ���ø�����������췽�� */
	public DBException(String message) {
		super(message);
	}

	/** ���ø�����������췽�� */
	public DBException(String message, Throwable cause) {
		super(message, cause);
	}

	/** ���ø�����������췽�� */
	public DBException(Throwable cause) {
		super(cause);
	}

}
