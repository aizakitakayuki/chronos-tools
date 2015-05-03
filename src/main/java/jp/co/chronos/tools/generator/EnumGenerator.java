/**
 *
 */
package jp.co.chronos.tools.generator;

import java.io.IOException;
import java.util.List;

import jp.co.chronos.tools.generator.task.EnumGeneratorTask;
import jp.co.chronos.tools.generator.task.EnumTestGeneratorTask;
import jp.co.chronos.tools.generator.task.GeneratorTask;

import com.google.common.collect.Lists;

/**
 * @author aizaki
 *
 */
public class EnumGenerator implements Generator {

	/**
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		EnumGenerator enumGenerator = new EnumGenerator();
		try {
			enumGenerator.generate();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("終わり!");
	}

	@Override
	public void generate() throws IOException {
		List<GeneratorTask> generatorList = Lists.newArrayList();
		GeneratorTask enumGeneratorTask = new EnumGeneratorTask();
		GeneratorTask enumTestGeneratorTask = new EnumTestGeneratorTask();
		generatorList.add(enumGeneratorTask);
		generatorList.add(enumTestGeneratorTask);

		try {
			for (GeneratorTask task : generatorList) {
				task.process();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
