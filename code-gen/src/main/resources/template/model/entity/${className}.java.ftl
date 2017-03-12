<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.model.entity;

import java.io.Serializable;
import java.util.Date;

<#include "/java_imports.include">
/**
 * ${table.tableAlias}
 *
 * @author hujj
 */
public class ${className} implements Serializable{

	private static final long serialVersionUID = 5454123425314635342L;

	<#list table.columns as column>

	/**
	 * ${column.columnAlias}
	 */
	private ${column.javaType?replace("java.lang.","")?replace("java.util.","")} ${column.columnNameLower};
	</#list>
}
