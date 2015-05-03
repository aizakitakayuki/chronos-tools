/**
 *
 */
package jp.co.chronos.tools.common.constants;

import java.util.Map;

/**
 * RedScorpionGeneratorの定数クラス.
 *
 * @author aizaki
 *
 */
public class GeneratorConstants {

	private static final String AUTHOR = GeneratorConstants.getName();

	/**
	 * Constructor.<br>
	 * インスタンス化禁止.
	 */
	private GeneratorConstants() {
	}

	// ----------- AllGenerator ----------- //
	public static String getGeneratorResourcesPath() {
		return "src/main/resouces";
	}

	public static void setDefaultSourceData(Map<String, Object> source) {
		source.put("author", AUTHOR);
		source.put("redScorpionPackage", getRedScorpionPackageName());
	}

	public static String getRedScorpionPackageName() {
		return "jp.co.redscorpion";
	}

	private static String getName() {
		return "red-scorpion-tools";
	}

	public static String getTemplateDir() {
		return "src/main/resources/templates";
	}

	public static String getFileEncoding() {
		return "UTF-8";
	}

	/** 空文字. */
	public static final String BLANK = "";

	// ----------- DDLGenerator ----------- //
	/** テーブル定義書ファイルパス. */
	public static final String TABLE_DEFINITION_FILE_PATH = "/excel/テーブル定義書.xlsx";

	/** シート名"テーブル一覧". */
	public static final String SHEE_NAME_TABLE_LIST = "テーブル一覧";

	// ----------- EnumGenerator ----------- //
	/** Enum一覧ファイルパス. */
	public static final String ENUM_LIST_FILE_PATH = "/excel/Enum一覧.xlsx";

	/** シート名"Enum一覧". */
	public static final String SHEET_NAME_ENUM_LIST = "Enum一覧";

}
