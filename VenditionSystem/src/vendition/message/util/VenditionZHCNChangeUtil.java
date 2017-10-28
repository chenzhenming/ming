package vendition.message.util;

import java.io.UnsupportedEncodingException;

public class VenditionZHCNChangeUtil {
	public String ZHCNChange(String st) {
		String someString = null;
		try {
			someString = new String(st.getBytes("ISO-8859-1"), "GB2312");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return someString;
	}
}
