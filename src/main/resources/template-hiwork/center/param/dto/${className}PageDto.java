<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.vo;

//import com.gzhc365.${deptFlag}.common.vo.BaseVo;
import com.gzhc365.ehis.core.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.*;
/**
 <#include "/java_description.include">
 */
@Getter
@Setter
@Builder(toBuilder = true)
@ApiModel(value = "${className}PageDto", description = "${className}分页的dto对象")
public class ${className}PageDto extends BaseVo implements Serializable {
    //TODO 添加序列化Id

    <#list table.columns as column>
    @ApiModelProperty(value = "${column.remarks}")
    private ${column.simpleJavaType} ${column.columnNameLower};  
    </#list>
}