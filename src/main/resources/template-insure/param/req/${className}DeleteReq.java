<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.vo;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
import javax.validation.constraints.NotNull;
/**
 <#include "/java_description.include">
 */
@Data
@ApiModel(value = "${className}DeleteReq", description = "删除${className}请求对象")
public class ${className}DeleteReq{
    //TODO 添加序列化Id

    @NotNull(message = "删除${classNameLower}的id不能为空")
    @ApiModelProperty(value = "${classNameLower}的id")
    private Long id;

}