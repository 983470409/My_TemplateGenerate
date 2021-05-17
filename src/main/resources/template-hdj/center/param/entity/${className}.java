<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
/**
 <#include "/java_description.include">
 */
@Data
public class ${className}{


    <#list table.columns as column>
    /**
     * ${column.remarks}
     */
    private ${column.simpleJavaType} ${column.columnNameLower};  
    </#list>

}