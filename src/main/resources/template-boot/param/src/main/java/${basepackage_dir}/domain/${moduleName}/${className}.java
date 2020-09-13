<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.domain.${moduleName};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 <#include "/java_description.include">
 */
@Data
@ApiModel(value = "${className}", description = "${className}实体对象")
public class ${className} implements Serializable {
    //TODO 添加序列化Id

    <#list table.columns as column>
    @ApiModelProperty(value = "${column.remarks}")
    private ${column.simpleJavaType} ${column.columnNameLower};  
    </#list>  
 
<@generateJavaColumns/> 

}