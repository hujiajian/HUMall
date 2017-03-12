<#include "/macro.include"/>
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import ${basepackage}.model.${className};
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;
<#include "/java_imports.include">
/**
 * ${table.tableAlias} 服务层
 *
 * @author hujj
 */
public interface ${className}Service {

   List<${className}> getListByPage(PageBounds pageBounds);

   void save${className}(${className} ${classNameLower});

   void update${className}(${className} ${classNameLower});

   void delete${className}(${className} ${classNameLower});
}
