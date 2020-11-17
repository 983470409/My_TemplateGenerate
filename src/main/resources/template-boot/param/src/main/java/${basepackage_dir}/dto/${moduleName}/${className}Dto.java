<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.dto.${moduleName};

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;

/**
 <#include "/java_description.include">
 */
@Data
@ApiModel(value = "${className}Dto", description = "${className}业务传输对象")
public class ${className}Dto {

    <#list table.columns as column>
    @ApiModelProperty(value = "${column.remarks}")
    private ${column.simpleJavaType} ${column.columnNameLower};
    </#list>
    @ApiModelProperty(value = "查询开始时间")
    private Date startDate;
    @ApiModelProperty(value = "查询结束时间")
    private Date endDate;
}