package ${packageName};

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;

/**
 * ${physicalEnumName}Test.<br>
 * Testing for ${logicalEnumName}.
 *
 * @author ${author}
 */
public class ${physicalEnumName}Test {

	@Test
	public void test() {
	<#list paramList as param>
		assertThat(${physicalEnumName}.getType(<#if codeDataType = "String">"${param.code}"<#else>${param.code}</#if>), is(${physicalEnumName}.${param.physicalFieldName}));
	</#list>
	<#if codeDataType = "String">
		assertThat(${physicalEnumName}.getType("nullValue"), is(nullValue()));
	<#else>
		assertThat(${physicalEnumName}.getType(2147483647), is(nullValue()));
	</#if>
	<#list paramList as param>
		assertThat(${physicalEnumName}.${param.physicalFieldName}.getValue(), is("${param.value}"));
	</#list>
	}
}
