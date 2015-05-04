/**
 *
 */
package jp.co.chronos.tools.entity.enumdefinition;

import jp.co.chronos.tools.entity.Entity;

/**
 * @author aizaki
 *
 */
public class GeneralEntity implements Entity {

	private String author;

	private String packageName;

	private GeneralEntity() {
	}

	public static GeneralEntity getInstance() {
		return new GeneralEntity();
	}

	/**
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 *
	 * @param author
	 * @return
	 */
	public GeneralEntity setAuthor(String author) {
		this.author = author;
		return this;
	}

	/**
	 * @return packageName
	 */
	public String getPackageName() {
		return packageName;
	}

	/**
	 *
	 * @param packageName
	 * @return
	 */
	public GeneralEntity setPackageName(String packageName) {
		this.packageName = packageName;
		return this;
	}
}
