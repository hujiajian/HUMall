<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

<#include "/java_imports.include">
/**
 * ${table.tableAlias} 实体
 *
 * @author hujj
 */
@Setter
@Getter
@ToString
@Table(name = "${table.sqlName}")
@ApiModel("${table.tableAlias}")
public class ${className} implements Serializable{

	private static final long serialVersionUID = 5454155825314635342L;

	<#list table.columns as column>
	<#if column.pk>
	@Id
	</#if>
	<#if !column.pk>

	/**
	 * ${column.columnAlias}
	 */
	</#if>
    @ApiModelProperty("${column.columnAlias}")
	private ${column.javaType?replace("java.lang.","")?replace("java.util.","")} ${column.columnNameLower};
	</#list>
}
