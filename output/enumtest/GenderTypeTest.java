package jp.co.chronos.tools.common.type;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * GenderTypeTest.<br>
 * Testing for Gender.
 *
 * @author chronos-tools
 */
public class GenderTypeTest {

	@Test
	public void test() {
		assertThat(GenderType.getType("0"), is(GenderType.FEMALE));
		assertThat(GenderType.getType("1"), is(GenderType.MALE));
		assertThat(GenderType.getType("2"), is(GenderType.CORPORATION));
		assertThat(GenderType.getType("nullValue"), is(nullValue()));
		assertThat(GenderType.FEMALE.getValue(), is("Female"));
		assertThat(GenderType.MALE.getValue(), is("Male"));
		assertThat(GenderType.CORPORATION.getValue(), is("Corporation"));
	}
}
