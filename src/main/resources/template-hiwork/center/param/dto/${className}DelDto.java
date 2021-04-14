<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.vo;


import java.io.Serializable;
import java.util.Date;
import lombok.Data;
/**
 <#include "/java_description.include">
 */
@Data
public class ${className}DelDto implements Serializable {
    //TODO 添加序列化Id

    <#list table.columns as column>
    /**
     * ${column.remarks}
     */
    private ${column.simpleJavaType} ${column.columnNameLower};
    </#list>

}