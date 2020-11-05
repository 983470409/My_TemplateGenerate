<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import ${basepackage}.request.*;

/**
 <#include "/java_description.include">
 */
@Data
@ApiModel(value = "${className}QueryReq", description = "查询${className}请求对象")
public class ${className}QueryReq extends BaseReq{
    //TODO 添加序列化Id

    <#list table.columns as column>
    @ApiModelProperty(value = "${column.remarks}")
    private ${column.simpleJavaType} ${column.columnNameLower};  
    </#list>  

}