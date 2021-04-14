<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import lombok.EqualsAndHashCode;
import com.gzhc365.assembly.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 <#include "/java_description.include">
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("${table.sqlName}")
public class ${className} extends BaseEntity{


    <#list table.columns as column>
    <#if column.columnNameLower != "id">
    /**
     * ${column.remarks}
     */
    private ${column.simpleJavaType} ${column.columnNameLower};

    </#if>
    </#list>

}