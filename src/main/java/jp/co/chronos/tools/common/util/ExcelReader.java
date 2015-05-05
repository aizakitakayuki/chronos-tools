/**
 *
 */
package jp.co.chronos.tools.common.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jp.co.chronos.tools.common.constants.GeneratorConstants;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.base.CaseFormat;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;

/**
 * @author aizaki
 *
 */
public class ExcelReader {

	private static Gson GSON = new Gson();

	private String filePath;

	private List<Map<String, String>> entities;

	private ExcelReader(String filePath) {
		this.filePath = filePath;
	}

	public static ExcelReader create(String filePath) {
		return new ExcelReader(filePath);
	}

	public ExcelReader read(String sheetName) {
		List<Map<String, String>> entities = Lists.newArrayList();
		try {
			Workbook workbook = WorkbookFactory.create(this.getClass().getResourceAsStream(this.filePath));
			Sheet sheet = workbook.getSheet(sheetName);

			List<String> fieldNams = Lists.newArrayList();
			for (Cell cell : sheet.getRow(0)) {
				fieldNams.add(CaseFormat.LOWER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, cellStringValue(cell)));
			}

			for (int i = 1; i <= sheet.getLastRowNum(); i++) {
				Map<String, String> map = Maps.newHashMap();
				for (int j = 0; j < sheet.getRow(i).getLastCellNum(); j++) {
					map.put(fieldNams.get(j), cellStringValue(sheet.getRow(i).getCell(j)));
				}
				entities.add(map);
			}
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		} finally {
			this.entities = entities;
		}
		return this;
	}

	public <T> List<T> convert(Class<T> type) {
		List<T> convertedEntities = Lists.newArrayList();
		entities.stream().forEach(entity -> convertedEntities.add(GSON.fromJson(GSON.toJson(entity), type)));
		return convertedEntities;
	}

	private String cellStringValue(Cell cell) {
		if (cell == null) {
			return GeneratorConstants.BLANK;
		}

		String stringValue;
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_BLANK:
			stringValue = GeneratorConstants.BLANK;
			break;
		case Cell.CELL_TYPE_BOOLEAN:
			stringValue = Boolean.toString(cell.getBooleanCellValue());
			break;
		case Cell.CELL_TYPE_ERROR:
			stringValue = GeneratorConstants.BLANK;
			break;
		case Cell.CELL_TYPE_FORMULA:
			stringValue = cell.getStringCellValue();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			stringValue = Integer.toString((int) cell.getNumericCellValue());
			break;
		case Cell.CELL_TYPE_STRING:
			stringValue = cell.getStringCellValue();
			break;
		default:
			stringValue = GeneratorConstants.BLANK;
			break;
		}
		return stringValue;
	}
}
