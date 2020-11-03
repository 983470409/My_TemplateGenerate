<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.vo;

/**
 <#include "/java_model_imports.include">
 */
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 <#include "/java_description.include">
 */
@Data
@ApiModel(value = "${className}UpdateReq", description = "更新${className}请求对象")
public class ${className}UpdateReq  extends BaseReq{
    //TODO 添加序列化Id

    <#list table.columns as column>
    @ApiModelProperty(value = "${column.remarks}")
    private ${column.simpleJavaType} ${column.columnNameLower};  
    </#list>  



}