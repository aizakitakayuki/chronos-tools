/**
 *
 */
package jp.co.chronos.tools.entity.enumdefinition;

import jp.co.chronos.tools.entity.Entity;

/**
 * @author aizaki
 *
 */
public class EnumDefinitionEntity implements Entity {

	private String enumId;

	private String logicalEnumName;

	private String physicalEnumName;

	private String dataTypeOfCode;

	private String dataTypeOfValue;

	private String fieldId;

	private String logicalFieldName;

	private String physicalFieldName;

	private String code;

	private String value;

	/**
	 * @return enumId
	 */
	public String getEnumId() {
		return enumId;
	}

	/**
	 *
	 * @param enumId
	 * @return
	 */
	public EnumDefinitionEntity setEnumId(String enumId) {
		this.enumId = enumId;
		return this;
	}

	/**
	 * @return logicalEnumName
	 */
	public String getLogicalEnumName() {
		return logicalEnumName;
	}

	/**
	 *
	 * @param logicalEnumName
	 * @return
	 */
	public EnumDefinitionEntity setLogicalEnumName(String logicalEnumName) {
		this.logicalEnumName = logicalEnumName;
		return this;
	}

	/**
	 * @return physicalEnumName
	 */
	public String getPhysicalEnumName() {
		return physicalEnumName;
	}

	/**
	 *
	 * @param physicalEnumName
	 * @return
	 */
	public EnumDefinitionEntity setPhysicalEnumName(String physicalEnumName) {
		this.physicalEnumName = physicalEnumName;
		return this;
	}

	/**
	 * @return dataTypeOfCode
	 */
	public String getDataTypeOfCode() {
		return dataTypeOfCode;
	}

	/**
	 *
	 * @param dataTypeOfCode
	 * @return
	 */
	public EnumDefinitionEntity setDataTypeOfCode(String dataTypeOfCode) {
		this.dataTypeOfCode = dataTypeOfCode;
		return this;
	}

	/**
	 * @return dataTypeOfValue
	 */
	public String getDataTypeOfValue() {
		return dataTypeOfValue;
	}

	/**
	 *
	 * @param dataTypeOfValue
	 * @return
	 */
	public EnumDefinitionEntity setDataTypeOfValue(String dataTypeOfValue) {
		this.dataTypeOfValue = dataTypeOfValue;
		return this;
	}

	/**
	 * @return fieldId
	 */
	public String getFieldId() {
		return fieldId;
	}

	/**
	 *
	 * @param fieldId
	 * @return
	 */
	public EnumDefinitionEntity setFieldId(String fieldId) {
		this.fieldId = fieldId;
		return this;
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
	public EnumDefinitionEntity setLogicalFieldName(String logicalFieldName) {
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
	public EnumDefinitionEntity setPhysicalFieldName(String physicalFieldName) {
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
	public EnumDefinitionEntity setCode(String code) {
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
	public EnumDefinitionEntity setValue(String value) {
		this.value = value;
		return this;
	}

}
