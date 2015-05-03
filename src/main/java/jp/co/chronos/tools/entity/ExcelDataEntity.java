/**
 *
 */
package jp.co.chronos.tools.entity;

import java.util.Map;

import com.google.common.collect.Maps;

/**
 * @author aizaki
 *
 */
public class ExcelDataEntity {

	/** 行データ */
	private Map<String, String> lineData = Maps.newHashMap();

	/**
	 * Constructor.
	 */
	private ExcelDataEntity(Map<String, String> bean) {
		this.lineData = bean;
	}

	/**
	 * Factory.
	 *
	 * @param bean
	 * @return
	 */
	public static ExcelDataEntity create(Map<String, String> bean) {
		return new ExcelDataEntity(bean);
	}

	/**
	 * Key(カラム名)に応じた値を返却する.
	 *
	 * @param key
	 * @return
	 */
	public String getValue(String key) {
		return this.lineData.get(key);
	}

	/**
	 * 行データを返却する.
	 *
	 * @return
	 */
	public Map<String, String> getLineData() {
		return this.lineData;
	}

}
