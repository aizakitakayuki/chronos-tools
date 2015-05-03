package ${packageName};

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * ${className}Test.<br>
 * ${className_ja}区分テスト.
 *
 * @author ${author}
 */
public class ${className}Test {

	@Test
	public void test() {
	<#list paramList as param>
		assertThat(${className}.getType("${param.code}"), is(${className}.${param.field_en}));
	</#list>
		assertThat(${className}.getType("nullValue"), is(nullValue()));
	<#list paramList as param>
		assertThat(${className}.${param.field_en}.getValue(), is("${param.code}"));
	</#list>
	}
}
	