package util;


import biz.BizException;

public class Utils {

	/**
	 * 	判断传值是否为空 或空字符串
	 * @param value
	 * @param msg
	 * @throws BizException
	 */
	public static void checkNull(Object value, String msg) throws BizException {
		if (value == null) {
			throw new BizException(msg);
		}
		if (value instanceof String) {
			String svalue = (String) value;
			if (svalue.trim().isEmpty()) {
				throw new BizException(msg);
			}
		}
	}

}
