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
import jp.co.chronos.tools.common.util.ExcelReader;
import jp.co.chronos.tools.common.util.FreeMarker;
import jp.co.chronos.tools.entity.enumdefinition.EnumDefinitionEntity;
import jp.co.chronos.tools.entity.enumdefinition.GeneralEntity;
import jp.co.chronos.tools.param.Param;
import jp.co.chronos.tools.param.enumdefinition.EnumParam;

import org.apache.commons.collections4.CollectionUtils;
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
		// key : Physical Enum Name.
		Map<String, Object> sourceMap = Maps.newHashMap();

		ExcelReader excelReader = ExcelReader.create(GeneratorConstants.ENUM_DEFINITION_FILE_PATH);
		List<EnumDefinitionEntity> enumEntityList = excelReader.read(GeneratorConstants.SHEET_NAME_ENUM_DEFINITION).convert(EnumDefinitionEntity.class);
		List<GeneralEntity> generalEntityList = excelReader.read(GeneratorConstants.SHEET_NAME_GENERAL).convert(GeneralEntity.class);

		String physicalEnumName = null;
		Map<String, Object> source = null;
		List<Param> paramList = null;
		for (EnumDefinitionEntity entity : enumEntityList) {
			String tmpClassName = entity.getPhysicalEnumName();
			if (StringUtils.equals(physicalEnumName, tmpClassName)) {
				// Same Enum.
				Param param = EnumParam.getInstance()//
						.setLogicalFieldName(entity.getLogicalFieldName())//
						.setPhysicalFieldName(entity.getPhysicalFieldName())//
						.setCode(entity.getCode())//
						.setValue(entity.getValue());
				if (CollectionUtils.isNotEmpty(paramList)) {
					paramList.add(param);
				}
				continue;
			}
			// Different Enum.
			source = Maps.newHashMap();
			paramList = Lists.newArrayList();
			physicalEnumName = entity.getPhysicalEnumName();
			String logicalEnumName = entity.getLogicalEnumName();
			Param param = EnumParam.getInstance()//
					.setLogicalFieldName(entity.getLogicalFieldName())//
					.setPhysicalFieldName(entity.getPhysicalFieldName())//
					.setCode(entity.getCode())//
					.setValue(entity.getValue());
			paramList.add(param);
			source.put("packageName", generalEntityList.get(0).getPackageName());
			source.put("author", generalEntityList.get(0).getAuthor());
			source.put("physicalEnumName", physicalEnumName);
			source.put("logicalEnumName", logicalEnumName);
			source.put("codeDataType", entity.getCodeDataType());
			source.put("paramList", paramList);
			sourceMap.put(physicalEnumName, source);
		}
		return sourceMap;
	}

}
