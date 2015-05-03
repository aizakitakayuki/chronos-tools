package ${packageName};

import org.apache.commons.lang.StringUtils;

/**
 * ${className}.<br>
 * ${className_ja}区分.
 * 
 * @author ${author}
 * 
 */
public enum ${className} {

	<#list paramList as param>
	/** ${param.field_ja} */
	${param.field_en}("${param.code}", "${param.value}")<#if param_has_next>, //<#else>;</#if>
	</#list>

	/** Enumが保持する値. */
	private final String code;

	/** ${className_ja}の値 */
	private final String value;

	/**
	 * Constructor.
	 * 
	 * @param code
	 */
	private ${className}(final String code, final String value) {
		this.code = code;
		this.value = value;
	}

	/**
	 * ${className_ja}区分を返却する.
	 * 
	 * @param code
	 * 
	 * @return ${className_ja}区分
	 */
	public static ${className} getType(final String code) {
		for (${className} type : values()) {
			if (StringUtils.equals(type.getValue(), code)) {
				return type;
			}
		}
		return null;
	}

	/**
	 * ${className_ja}区分の値を返却する.
	 * 
	 * @return ${className_ja}区分の値
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * ${className_ja}の値を返却する.
	 * 
	 * @return ${className_ja}の値
	 */
	public String getValue() {
		return this.value;
	}

}