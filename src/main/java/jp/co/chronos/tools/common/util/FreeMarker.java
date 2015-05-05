/**
 *
 */
package jp.co.chronos.tools.common.util;

import java.io.File;
import java.io.IOException;
import java.io.Writer;

import jp.co.chronos.tools.common.constants.GeneratorConstants;
import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Utility for File I/O used FreeMarker.
 *
 * @author aizaki
 *
 */
@SuppressWarnings("deprecation")
public class FreeMarker {

	private static final Configuration CONFIGURATION;

	static {
		CONFIGURATION = new Configuration();
		try {
			CONFIGURATION.setTemplateLoader(new FileTemplateLoader(new File(GeneratorConstants.getTemplateDir())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		CONFIGURATION.setDefaultEncoding(GeneratorConstants.getFileEncoding());
	}

	private final Writer writer;

	/**
	 * Constructor.
	 *
	 * @param writer
	 */
	public FreeMarker(Writer writer) {
		this.writer = writer;
	}

	public void make(Object source, String templateName) throws IOException, TemplateException {
		Template template = CONFIGURATION.getTemplate(templateName);
		template.process(source, writer);
	}
}
