package jp.co.chronos.tools.common.type;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * CountryTypeTest.<br>
 * Testing for Country.
 *
 * @author chronos-tools
 */
public class CountryTypeTest {

	@Test
	public void test() {
		assertThat(CountryType.getType(0), is(CountryType.USA));
		assertThat(CountryType.getType(1), is(CountryType.JAPAN));
		assertThat(CountryType.getType(2), is(CountryType.CHINA));
		assertThat(CountryType.getType(2147483647), is(nullValue()));
		assertThat(CountryType.USA.getValue(), is("USA"));
		assertThat(CountryType.JAPAN.getValue(), is("Japan"));
		assertThat(CountryType.CHINA.getValue(), is("China"));
	}
}
