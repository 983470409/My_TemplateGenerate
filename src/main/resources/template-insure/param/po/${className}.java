<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 <#include "/java_model_imports.include">
 */
@Data
@ApiModel(value = "${className}", description = "${className}实体对象")
public class ${className} {

    <#list table.columns as column>
    @ApiModelProperty(value = "${column.remarks}")
    private ${column.simpleJavaType} ${column.columnNameLower};  
    </#list>  
 








}