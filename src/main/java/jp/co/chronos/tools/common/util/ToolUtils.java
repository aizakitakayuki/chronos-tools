/**
 *
 */
package jp.co.chronos.tools.common.util;

import org.apache.commons.lang3.text.WordUtils;

/**
 * @author aizaki
 *
 */
public class ToolUtils {

	/**
	 * Constructor.
	 */
	private ToolUtils() {
	}

	/**
	 * 文字列の先頭を大文字, 他を小文字に変換し, デリミタを削除します.
	 *
	 * @param value
	 *            文字列
	 * @param delimiter
	 *            デリミタ
	 * @return 先頭が大文字に変換された文字列
	 */
	public static String capitalizeAndRemoveDelimiter(String value, char delimiter) {
		if (value == null) {
			return null;
		}
		int length = value.length();
		if (length == 0) {
			return value;
		}
		String column = WordUtils.capitalizeFully(value, new char[] { delimiter });
		return column.replaceAll(String.valueOf(delimiter), "");
	}

}
