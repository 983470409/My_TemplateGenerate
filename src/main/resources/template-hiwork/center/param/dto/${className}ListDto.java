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
@ApiModel(value = "${className}ListDto", description = "${className}查询list的对象")
public class ${className}ListDto extends BaseVo implements Serializable {

    <#list table.columns as column>
    @ApiModelProperty(value = "${column.remarks}")
    private ${column.simpleJavaType} ${column.columnNameLower};  
    </#list>



}