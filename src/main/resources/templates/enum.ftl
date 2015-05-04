package ${packageName};

<#if dataTypeOfCode = "String">
import org.apache.commons.lang3.StringUtils;
</#if>
/**
 * ${physicalEnumName}.<br>
 * ${logicalEnumName}区分.
 *
 * @author ${author}
 *
 */
public enum ${physicalEnumName} {

	<#list paramList as param>
	/** ${param.logicalFieldName} */
	${param.physicalFieldName}(<#if dataTypeOfCode = "String">"${param.code}"<#else>${param.code}</#if>, <#if dataTypeOfValue = "String">"${param.value}"<#else>${param.value}</#if>)<#if param_has_next>, //<#else>;</#if>
	</#list>

	/** Enumが保持する値. */
	private final <#if dataTypeOfCode = "String">String<#else>int</#if> code;

	/** ${logicalEnumName}の値 */
	private final <#if dataTypeOfValue = "String">String<#else>int</#if> value;

	/**
	 * Constructor.
	 *
	 * @param code
	 */
	private ${physicalEnumName}(final <#if dataTypeOfCode = "String">String<#else>int</#if> code, final <#if dataTypeOfValue = "String">String<#else>int</#if> value) {
		this.code = code;
		this.value = value;
	}

	/**
	 * ${logicalEnumName}区分を返却する.
	 *
	 * @param code
	 *
	 * @return ${logicalEnumName}区分
	 */
	public static ${physicalEnumName} getType(final <#if dataTypeOfCode = "String">String<#else>int</#if> code) {
		for (${physicalEnumName} type : values()) {
			if (<#if dataTypeOfCode = "String">StringUtils.equals(type.getValue(), code)<#else>type.getValue() == code</#if>) {
				return type;
			}
		}
		return null;
	}

	/**
	 * ${logicalEnumName}区分の値を返却する.
	 *
	 * @return ${logicalEnumName}区分の値
	 */
	public <#if dataTypeOfCode = "String">String<#else>int</#if> getCode() {
		return this.code;
	}

	/**
	 * ${logicalEnumName}の値を返却する.
	 *
	 * @return ${logicalEnumName}の値
	 */
	public <#if dataTypeOfValue = "String">String<#else>int</#if> getValue() {
		return this.value;
	}

}