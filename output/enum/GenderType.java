package jp.co.chronos.tools.common.type;

import org.apache.commons.lang3.StringUtils;
/**
 * GenderType.<br>
 * Gender区分.
 *
 * @author chronos-tools
 *
 */
public enum GenderType {

	/** Female */
	FEMALE("0", "Female"), //
	/** Male */
	MALE("1", "Male"), //
	/** Corporation */
	CORPORATION("2", "Corporation");

	/** Enumが保持する値. */
	private final String code;

	/** Genderの値 */
	private final String value;

	/**
	 * Constructor.
	 *
	 * @param code
	 */
	private GenderType(final String code, final String value) {
		this.code = code;
		this.value = value;
	}

	/**
	 * Gender区分を返却する.
	 *
	 * @param code
	 *
	 * @return Gender区分
	 */
	public static GenderType getType(final String code) {
		for (GenderType type : values()) {
			if (StringUtils.equals(type.getCode(), code)) {
				return type;
			}
		}
		return null;
	}

	/**
	 * Gender区分の値を返却する.
	 *
	 * @return Gender区分の値
	 */
	public String getCode() {
		return this.code;
	}

	/**
	 * Genderの値を返却する.
	 *
	 * @return Genderの値
	 */
	public String getValue() {
		return this.value;
	}

}