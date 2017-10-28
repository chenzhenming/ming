package vendition.message.dbexception;

/**
 * 数据库可能出现异常的类；
 * DBException.java
 * @author dk
 * @version 2007
 */
/** 数据库异常类 */
public class DBException extends Exception {
	/** 调用父类构造方法 */
	public DBException() {
		super();
	}

	/** 调用父类带参数构造方法 */
	public DBException(String message) {
		super(message);
	}

	/** 调用父类带参数构造方法 */
	public DBException(String message, Throwable cause) {
		super(message, cause);
	}

	/** 调用父类带参数构造方法 */
	public DBException(Throwable cause) {
		super(cause);
	}

}
