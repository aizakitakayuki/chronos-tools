/**
 *
 */
package jp.co.chronos.tools.entity.enumdefinition;

import jp.co.chronos.tools.entity.Entity;

/**
 * EnumDefinition Entity.
 *
 * @author aizaki
 *
 */
public class EnumDefinitionEntity implements Entity {

	/** Enum ID */
	private String enumId;

	/** Logical Enum Name */
	private String logicalEnumName;

	/** Physical Enum Name */
	private String physicalEnumName;

	/** Code Data Type */
	private String codeDataType;

	/** Field ID */
	private String fieldId;

	/** Logical Field Name */
	private String logicalFieldName;

	/** Physical Field Name */
	private String physicalFieldName;

	/** Code */
	private String code;

	/** Value */
	private String value;

	/**
	 * Constructor.
	 */
	private EnumDefinitionEntity() {
	}

	/**
	 * Static Factory.
	 *
	 * @return
	 */
	public static EnumDefinitionEntity getInstance() {
		return new EnumDefinitionEntity();
	}

	/**
	 * Getter for Enum ID.
	 *
	 * @return enumId
	 */
	public String getEnumId() {
		return enumId;
	}

	/**
	 * Setter for Enum ID.
	 *
	 * @param enumId
	 * @return
	 */
	public EnumDefinitionEntity setEnumId(String enumId) {
		this.enumId = enumId;
		return this;
	}

	/**
	 * Getter for Logical Enum Name.
	 *
	 * @return logicalEnumName
	 */
	public String getLogicalEnumName() {
		return logicalEnumName;
	}

	/**
	 * Setter for Logical Enum Name.
	 *
	 * @param logicalEnumName
	 * @return
	 */
	public EnumDefinitionEntity setLogicalEnumName(String logicalEnumName) {
		this.logicalEnumName = logicalEnumName;
		return this;
	}

	/**
	 * Getter for Physical Enum Name.
	 *
	 * @return physicalEnumName
	 */
	public String getPhysicalEnumName() {
		return physicalEnumName;
	}

	/**
	 *
	 * Setter for Physical Enum Name.
	 *
	 * @param physicalEnumName
	 * @return
	 */
	public EnumDefinitionEntity setPhysicalEnumName(String physicalEnumName) {
		this.physicalEnumName = physicalEnumName;
		return this;
	}

	/**
	 * Getter for Code Data Type.
	 * 
	 * @return codeDataType
	 */
	public String getCodeDataType() {
		return codeDataType;
	}

	/**
	 * Setter for Code Data Type.
	 *
	 * @param codeDataType
	 * @return
	 */
	public EnumDefinitionEntity setCodeDataType(String codeDataType) {
		this.codeDataType = codeDataType;
		return this;
	}

	/**
	 * Getter for Field ID.
	 *
	 * @return fieldId
	 */
	public String getFieldId() {
		return fieldId;
	}

	/**
	 * Setter for Field ID.
	 *
	 * @param fieldId
	 * @return
	 */
	public EnumDefinitionEntity setFieldId(String fieldId) {
		this.fieldId = fieldId;
		return this;
	}

	/**
	 * Getter for Logical Field Name.
	 *
	 * @return logicalFieldName
	 */
	public String getLogicalFieldName() {
		return logicalFieldName;
	}

	/**
	 * Setter for Logical Field Name.
	 *
	 * @param logicalFieldName
	 * @return
	 */
	public EnumDefinitionEntity setLogicalFieldName(String logicalFieldName) {
		this.logicalFieldName = logicalFieldName;
		return this;
	}

	/**
	 * Getter for Physical Field Name.
	 *
	 * @return physicalFieldName
	 */
	public String getPhysicalFieldName() {
		return physicalFieldName;
	}

	/**
	 * Setter for Physical Field Name.
	 *
	 * @param physicalFieldName
	 * @return
	 */
	public EnumDefinitionEntity setPhysicalFieldName(String physicalFieldName) {
		this.physicalFieldName = physicalFieldName;
		return this;
	}

	/**
	 * Getter for Code.
	 *
	 * @return code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Setter for Code.
	 *
	 * @param code
	 * @return
	 */
	public EnumDefinitionEntity setCode(String code) {
		this.code = code;
		return this;
	}

	/**
	 * Getter for Value.
	 *
	 * @return value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * Setter for Value.
	 *
	 * @param value
	 * @return
	 */
	public EnumDefinitionEntity setValue(String value) {
		this.value = value;
		return this;
	}

}
