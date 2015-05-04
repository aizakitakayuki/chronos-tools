/**
 *
 */
package jp.co.chronos.tools.param.enumdefinition;

import jp.co.chronos.tools.param.Param;

/**
 * @author aizaki
 *
 */
public class EnumParam implements Param {

	private String logicalFieldName;

	private String physicalFieldName;

	private String code;

	private String value;

	private EnumParam() {
	}

	public static EnumParam getInstance() {
		return new EnumParam();
	}

	/**
	 * @return logicalFieldName
	 */
	public String getLogicalFieldName() {
		return logicalFieldName;
	}

	/**
	 *
	 * @param logicalFieldName
	 * @return
	 */
	public EnumParam setLogicalFieldName(String logicalFieldName) {
		this.logicalFieldName = logicalFieldName;
		return this;
	}

	/**
	 * @return physicalFieldName
	 */
	public String getPhysicalFieldName() {
		return physicalFieldName;
	}

	/**
	 *
	 * @param physicalFieldName
	 * @return
	 */
	public EnumParam setPhysicalFieldName(String physicalFieldName) {
		this.physicalFieldName = physicalFieldName;
		return this;
	}

	/**
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 *
	 * @param code
	 * @return
	 */
	public EnumParam setCode(String code) {
		this.code = code;
		return this;
	}

	/**
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 *
	 * @param value
	 * @return
	 */
	public EnumParam setValue(String value) {
		this.value = value;
		return this;
	}

}
