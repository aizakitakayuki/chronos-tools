package ${packageName};

<#if codeDataType = "String">
import org.apache.commons.lang3.StringUtils;
</#if>
/**
 * ${physicalEnumName}.<br>
 * ${logicalEnumName}.
 *
 * @author ${author}
 *
 */
public enum ${physicalEnumName} {

	<#list paramList as param>
	/** ${param.logicalFieldName} */
	${param.physicalFieldName}(<#if codeDataType = "String">"${param.code}"<#else>${param.code}</#if>, "${param.value}")<#if param_has_next>, //<#else>;</#if>
	</#list>

	/** Enumが保持する値. */
	private final <#if codeDataType = "String">String<#else>int</#if> code;

	/** ${logicalEnumName}の値 */
	private final String value;

	/**
	 * Constructor.
	 *
	 * @param code
	 */
	private ${physicalEnumName}(final <#if codeDataType = "String">String<#else>int</#if> code, final String value) {
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
	public static ${physicalEnumName} getType(final <#if codeDataType = "String">String<#else>int</#if> code) {
		for (${physicalEnumName} type : values()) {
			if (<#if codeDataType = "String">StringUtils.equals(type.getCode(), code)<#else>type.getCode() == code</#if>) {
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
	public <#if codeDataType = "String">String<#else>int</#if> getCode() {
		return this.code;
	}

	/**
	 * ${logicalEnumName}の値を返却する.
	 *
	 * @return ${logicalEnumName}の値
	 */
	public String getValue() {
		return this.value;
	}

}