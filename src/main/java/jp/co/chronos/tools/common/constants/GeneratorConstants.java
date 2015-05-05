/**
 *
 */
package jp.co.chronos.tools.common.constants;

/**
 * Constant class.
 *
 * @author aizaki
 *
 */
public class GeneratorConstants {

	private GeneratorConstants() {
	}

	public static String getTemplateDir() {
		return "src/main/resources/templates";
	}

	public static String getFileEncoding() {
		return "UTF-8";
	}

	public static final String BLANK = "";

	public static final String ENUM_OUTPUT_EXTENSION = ".java";

	public static final String ENUM_DEFINITION_FILE_PATH = "/excel/EnumDefinition.xlsx";

	public static final String SHEET_NAME_ENUM_DEFINITION = "Enum Definition";

	public static final String SHEET_NAME_GENERAL = "General";

}
