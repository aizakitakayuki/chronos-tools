package jp.co.chronos.tools.common.type;

/**
 * CountryType.<br>
 * Country区分.
 *
 * @author chronos-tools
 *
 */
public enum CountryType {

	/** USA */
	USA(0, "USA"), //
	/** Japan */
	JAPAN(1, "Japan"), //
	/** China */
	CHINA(2, "China");

	/** Enumが保持する値. */
	private final int code;

	/** Countryの値 */
	private final String value;

	/**
	 * Constructor.
	 *
	 * @param code
	 */
	private CountryType(final int code, final String value) {
		this.code = code;
		this.value = value;
	}

	/**
	 * Country区分を返却する.
	 *
	 * @param code
	 *
	 * @return Country区分
	 */
	public static CountryType getType(final int code) {
		for (CountryType type : values()) {
			if (type.getCode() == code) {
				return type;
			}
		}
		return null;
	}

	/**
	 * Country区分の値を返却する.
	 *
	 * @return Country区分の値
	 */
	public int getCode() {
		return this.code;
	}

	/**
	 * Countryの値を返却する.
	 *
	 * @return Countryの値
	 */
	public String getValue() {
		return this.value;
	}

}