package my.com.cmg.iwp.util;

public class HTMLUtil {

	/**
	 * if string is null or empty or spaces only, substitute with html code
	 * &nbsp;
	 * 
	 * @param s
	 * @return
	 */
	public static String nbsp(String s) {
		return (s == null || s.trim().length() == 0) ? "&nbsp;" : s;
	}

	public static String hideNull(String s) {
		return s == null ? "" : s;
	}

	public static String escapeQuote(String s) {
		if (s != null) {
			return s.replaceAll("'", "\\\\'");
		}
		return "";
	}

	public static String escapeHTMLQuote(String s) {
		if (s != null) {
			return s.replaceAll("\"", "&quot;");
		}
		return "";
	}
}