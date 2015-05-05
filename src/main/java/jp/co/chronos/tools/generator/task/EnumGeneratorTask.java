/**
 *
 */
package jp.co.chronos.tools.generator.task;

/**
 * @author aizaki
 *
 */
public class EnumGeneratorTask extends EnumGeneratorBaseTask {

	private static final String TARGET_FORLDER = "enumsource";

	private static final String OUTPUT_FOLDER = "output/enum";

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

}
