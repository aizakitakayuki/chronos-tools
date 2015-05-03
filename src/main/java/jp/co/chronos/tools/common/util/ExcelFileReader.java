/**
 *
 */
package jp.co.chronos.tools.common.util;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import jp.co.chronos.tools.common.constants.GeneratorConstants;
import jp.co.chronos.tools.entity.ExcelDataEntity;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author aizaki
 *
 */
public class ExcelFileReader {

	/** ファイルパス. */
	private String filePath;

	/** シート名. */
	private String sheetName;

	/** Class. */
	private static final Class<ExcelFileReader> CLAZZ = ExcelFileReader.class;

	/**
	 * Private Constructor.
	 *
	 * @param filePath
	 */
	private ExcelFileReader(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Factory.
	 *
	 * @param filePath
	 * @return
	 */
	public static ExcelFileReader create(String filePath) {
		return new ExcelFileReader(filePath);
	}

	/**
	 * ファイルパスを返却する.
	 *
	 * @return filePath
	 */
	public String getFilePath() {
		return filePath;
	}

	/**
	 * ファイルパスを設定する.
	 *
	 * @param filePath
	 * @return
	 */
	public ExcelFileReader filePath(String filePath) {
		this.filePath = filePath;
		return this;
	}

	/**
	 * シート名を返却する.
	 *
	 * @return sheetName
	 */
	public String getSheetName() {
		return sheetName;
	}

	/**
	 *
	 * シート名を設定する.
	 *
	 * @param sheetName
	 * @return
	 */
	public ExcelFileReader sheetName(String sheetName) {
		this.sheetName = sheetName;
		return this;
	}

	/**
	 * 1行目がカラム名となっているシートを読み込む.
	 *
	 * @return
	 */
	public synchronized List<ExcelDataEntity> readAllEntity() {
		List<List<String>> entityData = read();
		// カラム名の行を取得, 全行データのカラム名の行を削除.
		List<String> columnNameList = entityData.get(0);
		entityData.remove(0);
		return createExcelEntityData(columnNameList, entityData);
	}

	/**
	 * ファイルをリスト形式で読み込む.
	 *
	 * @return
	 */
	private List<List<String>> read() {
		List<List<String>> lineDataList = Lists.newArrayList();
		try {
			Workbook workbook = WorkbookFactory.create(CLAZZ.getResourceAsStream(this.filePath));
			Sheet sheet = workbook.getSheet(this.sheetName);
			sheet.forEach(row -> lineDataList.add(readLineData(row)));
		} catch (InvalidFormatException | IOException e) {
			throw new IllegalArgumentException(e);
		}
		return lineDataList;
	}

	/**
	 * ファイルの行データを文字列のリストに変換する.
	 *
	 * @param row
	 * @return
	 */
	private List<String> readLineData(Row row) {
		List<String> lineData = Lists.newArrayList();
		row.forEach(cell -> lineData.add(cellStringValue(cell)));
		return lineData;
	}

	/**
	 * セルの値を文字列として返却する. ただしセルがnullの場合はデフォルト値としてブランクを返却する.
	 *
	 * @param cell
	 * @return
	 */
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

	/**
	 * 行データをExcelDataEntityとしてListで返却する.
	 *
	 * @param columnNameList
	 * @param entityData
	 * @return
	 */
	private List<ExcelDataEntity> createExcelEntityData(List<String> columnNameList, List<List<String>> entityData) {
		List<ExcelDataEntity> excelDataEntityList = Lists.newArrayList();
		for (List<String> lineData : entityData) {
			Map<String, String> bean = Maps.newHashMap();
			for (int i = 0; i < columnNameList.size(); i++) {
				bean.put(columnNameList.get(i), lineData.get(i));
			}
			excelDataEntityList.add(ExcelDataEntity.create(bean));
		}
		return excelDataEntityList;
	}
}
