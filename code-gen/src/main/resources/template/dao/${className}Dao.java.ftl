<#include "/macro.include"/>
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.dao;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import tk.mybatis.mapper.common.Mapper;
import ${basepackage}.model.${className};
import java.util.List;
<#include "/java_imports.include">
/**
 * ${table.tableAlias} 数据
 *
 * @author hujj
 */
public interface ${className}Dao extends Mapper<${className}> {
     List<${className}> queryAll(PageBounds pageBounds);
}
