<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.vo.${moduleName};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import java.util.Date;

/**
 <#include "/java_description.include">
 */
@Data
@ApiModel(value = "${className}ReqVo", description = "${className}ReqVo对象")
public class ${className}ReqVo implements Serializable {

    <#list table.columns as column>
    @ApiModelProperty(value = "${column.remarks}")
    private ${column.simpleJavaType} ${column.columnNameLower};  
    </#list>  

}