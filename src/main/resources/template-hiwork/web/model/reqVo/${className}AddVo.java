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
import javax.validation.constraints.NotBlank;

/**
 <#include "/java_description.include">
 */
@Data
@ApiModel(value = "${className}AddVo", description = "${className}新增接口vo对象")
public class ${className}AddVo implements Serializable {
    //TODO 添加序列化Id

    <#list table.columns as column>
    @ApiModelProperty(value = "${column.remarks}")
    <#if column.hibernateValidatorExprssion != "">
    ${column.hibernateValidatorExprssion}
    </#if>
    private ${column.simpleJavaType} ${column.columnNameLower};  
    </#list>  

}