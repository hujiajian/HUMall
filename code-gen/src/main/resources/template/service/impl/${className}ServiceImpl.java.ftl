<#include "/macro.include"/>
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import ${basepackage}.model.${className};
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import ${basepackage}.dao.${className}Dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
<#include "/java_imports.include">
/**
 * ${table.tableAlias} 服务
 *
 * @author Bigjin
 */
@Service
public class ${className}ServiceImpl implements ${className}Service {

    @Autowired
    private ${className}Dao ${classNameLower}Dao;

    @Override
    public List<${className}> getListByPage(PageBounds pageBounds, Conditions conditions){
        return ${classNameLower}Dao.queryAll(pageBounds);
    }

    @Override
    public void save${className}(${className} ${classNameLower}){
        ${classNameLower}Dao.insert(${classNameLower});
    }

    @Override
    public void update${className}(${className} ${classNameLower}){
        ${classNameLower}Dao.updateByPrimaryKey(${classNameLower});
    }

    @Override
    public void delete${className}(${className} ${classNameLower}){
        ${classNameLower}Dao.delete(${classNameLower});
    }

}
