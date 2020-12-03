<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.vo;

import com.gzhc365.${deptFlag}.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
/**
 <#include "/java_description.include">
 */
@Data
@ApiModel(value = "${className}GetDto", description = "${className}查询对象")
public class ${className}GetDto extends BaseVo implements Serializable {
    //TODO 添加序列化Id

    <#list table.columns as column>
    @ApiModelProperty(value = "${column.remarks}")
    private ${column.simpleJavaType} ${column.columnNameLower};  
    </#list>

    public ${className}GetDto(){}

    // 构造器
    public ${className}GetDto(Builder b){
        <#list table.columns as column>
        ${column.columnNameLower} = b.${column.columnNameLower};
        </#list>
    }


    public static class Builder {
        <#list table.columns as column>
        private ${column.simpleJavaType} ${column.columnNameLower};
        </#list>

     <#list table.columns as column>

        public Builder set${column.columnName}(${column.simpleJavaType} ${column.columnNameLower}) {
            this.${column.columnNameLower} = ${column.columnNameLower};
            return this;
        }

    </#list>

        public ${className}GetDto build(){
            return new ${className}GetDto(this);
        }
    }

}