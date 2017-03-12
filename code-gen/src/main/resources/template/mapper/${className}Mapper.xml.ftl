<#include "/macro.include"/>
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${basepackage}.dao.${className}Dao">

    <resultMap id="${className}Map" type="${basepackage}.model.${className}">
<#list table.columns as column>
    <#if column.pk>
        <id property="${column.columnNameLower}" column="${column.sqlName}"/>
    </#if>
    <#if !column.pk>
        <result property="${column.columnNameLower}" column="${column.sqlName}"/>
    </#if>
</#list>
    </resultMap>

    <sql id="BaseColumn">
    <#assign first = true>
        <#list table.columns as column><#if !first>,</#if>`${column.sqlName}`<#assign first = false></#list>
    </sql>

    <select id="queryAll" resultMap="${className}Map">
        SELECT *
        FROM table
    </select>
</mapper>