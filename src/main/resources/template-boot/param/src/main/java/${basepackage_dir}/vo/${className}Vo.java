<#include "/java_copyright.include">  
<#assign className = table.className>     
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.vo;
import com.gzhc365.${deptFlag}.common.vo.BaseVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 <#include "/java_description.include">
 */
public class ${className}Vo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 5454155825314635342L;  
      
    <#list table.columns as column>
    @ApiModelProperty(value = "${column.remarks}")
    private ${column.simpleJavaType} ${column.columnNameLower};  
    </#list>  


<@generateJavaColumns/>  
 
<#macro generateJavaColumns>  
    <#list table.columns as column>  
    public void set${column.columnName}(${column.simpleJavaType} ${column.columnNameLower}) {  
        this.${column.columnNameLower} = ${column.columnNameLower};  
    }

    public ${column.simpleJavaType} get${column.columnName}() {  
        return this.${column.columnNameLower};  
    }

    </#list>  
</#macro> 
}