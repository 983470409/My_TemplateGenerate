<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import javax.validation.constraints.*;
import org.hibernate.validator.constraints.*;
/**
 <#include "/java_description.include">
 */
@Data
@ApiModel(value = "${className}UptVo", description = "${className}UptVo对象")
public class ${className}UptVo  implements Serializable {
    //TODO 添加序列化Id

    <#list table.columns as column>
    <#if column.columnNameLower == "id">
    @ApiModelProperty(value = "${column.remarks}")
    ${column.hibernateValidatorExprssion}
    @NotNull
    private ${column.simpleJavaType} ${column.columnNameLower};
    <#else>
    @ApiModelProperty(value = "${column.remarks}")
    private ${column.simpleJavaType} ${column.columnNameLower};
    </#if>
    </#list>
}