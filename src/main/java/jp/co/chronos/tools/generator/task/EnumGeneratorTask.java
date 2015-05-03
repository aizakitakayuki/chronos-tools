/**
 *
 */
package jp.co.chronos.tools.generator.task;

import jp.co.chronos.tools.common.constants.GeneratorConstants;

/**
 * @author aizaki
 *
 */
public class EnumGeneratorTask extends EnumGeneratorBaseTask {

	private static final String OUTPUT_EXTENSION = ".java";

	private static final String TARGET_FORLDER = "enumsource";

	private static final String OUTPUT_FOLDER = "output/enum";

	private static final String PACKAGE = GeneratorConstants.getRedScorpionPackageName() + ".types.type";

	private static final String TEMPLATE = "enum.ftl";

	@Override
	public String getTemplate() {
		return TEMPLATE;
	}

	@Override
	public String getOutputFolder() {
		return OUTPUT_FOLDER;
	}

	@Override
	public String getFileName(String className) {
		return className;
	}

	@Override
	public String getTargetFolder() {
		return TARGET_FORLDER;
	}

	@Override
	public String getPackage() {
		return PACKAGE;
	}

	@Override
	public String getOutputExtention() {
		return OUTPUT_EXTENSION;
	}

}
