<#assign className = table.className>
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;
/**
 <#include "/java_description.include">
 */
@Data
@ApiModel(value = "${className}ListDto", description = "${className}查询list的对象")
public class ${className}ListDto  implements Serializable {
    //TODO 添加序列化Id

    <#list table.columns as column>
    @ApiModelProperty(value = "${column.remarks}")
    private ${column.simpleJavaType} ${column.columnNameLower};  
    </#list>

    public ${className}ListDto(){}

    // 构造器
    public ${className}ListDto(Builder b){
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

        public ${className}ListDto build(){
            return new ${className}ListDto(this);
        }
    }

}