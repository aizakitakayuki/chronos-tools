/**
 *
 */
package jp.co.chronos.tools.generator.task;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import jp.co.chronos.tools.common.constants.GeneratorConstants;
import jp.co.chronos.tools.common.util.ExcelFileReader;
import jp.co.chronos.tools.common.util.FreeMarker;
import jp.co.chronos.tools.common.util.ToolUtils;
import jp.co.chronos.tools.entity.EnumEntity;
import jp.co.chronos.tools.entity.ExcelDataEntity;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author aizaki
 *
 */
public abstract class EnumGeneratorBaseTask implements GeneratorTask {

	public abstract String getTemplate();

	public abstract String getOutputFolder();

	public abstract String getFileName(String className);

	public abstract String getTargetFolder();

	public abstract String getPackage();

	public abstract String getOutputExtention();

	@Override
	public void process() throws Exception {
		Map<String, Object> sourceMap = createSourceMap();
		for (Entry<String, Object> data : sourceMap.entrySet()) {
			StringBuilder sb = new StringBuilder(getOutputFolder());
			sb.append("/");
			sb.append(getFileName(data.getKey()));
			sb.append(getOutputExtention());
			Writer out = new OutputStreamWriter(new FileOutputStream(sb.toString()));
			FreeMarker fm = new FreeMarker(out);
			fm.make(data.getValue(), getTemplate());
		}
	}

	public Map<String, Object> createSourceMap() {
		// key:クラス名.
		Map<String, Object> sourceMap = Maps.newHashMap();

		// Enum一覧読み込み.
		List<ExcelDataEntity> entityList = ExcelFileReader.create(GeneratorConstants.ENUM_LIST_FILE_PATH).sheetName(GeneratorConstants.SHEET_NAME_ENUM_LIST).readAllEntity();

		// Template向けEnum情報生成.
		String className = null;
		Map<String, Object> source = null;
		List<Param> paramList = null;
		for (ExcelDataEntity entity : entityList) {
			String tmpClassName = getClassName(entity.getValue(EnumEntity.TYPE_PHYSICAL_NAME));
			if (StringUtils.equals(className, tmpClassName)) {
				// 同じEnum.
				Param param = new EnumParam(//
						entity.getValue(EnumEntity.FIELD_LOGICAL_NAME),//
						entity.getValue(EnumEntity.FIELD_PHYSICAL_NAME),//
						entity.getValue(EnumEntity.CODE),//
						entity.getValue(EnumEntity.VALUE)//
				);
				if (paramList != null) {
					paramList.add(param);
				}
				continue;
			}
			// 異なるEnum.
			source = Maps.newHashMap();
			paramList = Lists.newArrayList();
			className = getClassName(entity.getValue(EnumEntity.TYPE_PHYSICAL_NAME));
			String className_ja = entity.getValue(EnumEntity.TYPE_LOGICAL_NAME);
			Param param = new EnumParam(//
					entity.getValue(EnumEntity.FIELD_LOGICAL_NAME),//
					entity.getValue(EnumEntity.FIELD_PHYSICAL_NAME),//
					entity.getValue(EnumEntity.CODE),//
					entity.getValue(EnumEntity.VALUE)//
			);
			paramList.add(param);
			source.put("packageName", getPackage());
			GeneratorConstants.setDefaultSourceData(source);
			source.put("className", className);
			source.put("className_ja", className_ja);
			source.put("paramList", paramList);
			sourceMap.put(className, source);
		}

		return sourceMap;
	}

	private String getClassName(String className) {
		StringBuilder sb = new StringBuilder(ToolUtils.capitalizeAndRemoveDelimiter(className, '_'));
		sb.append("Type");
		return sb.toString();
	}

	public static class EnumParam implements Param {

		private String field_ja;

		private String field_en;

		private String code;

		private String value;

		public EnumParam(String field_ja, String field_en, String code, String value) {
			this.field_ja = field_ja;
			this.field_en = field_en;
			this.code = code;
			this.value = value;
		}

		/**
		 * field_jaを返却する.
		 *
		 * @return field_ja
		 */
		public String getField_ja() {
			return field_ja;
		}

		/**
		 * field_enを返却する.
		 *
		 * @return field_en
		 */
		public String getField_en() {
			return field_en;
		}

		/**
		 * codeを返却する.
		 *
		 * @return code
		 */
		public String getCode() {
			return code;
		}

		/**
		 * valueを返却する.
		 *
		 * @return value
		 */
		public String getValue() {
			return value;
		}

	}
}
