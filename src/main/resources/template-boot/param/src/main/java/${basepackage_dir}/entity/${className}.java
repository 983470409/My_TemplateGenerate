<#include "/java_copyright.include">  
<#assign className = table.className>     
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.param;
 
import java.util.Date;
import com.gzhc365.ehis.core.vo.BaseFacadeParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 <#include "/java_description.include">
 */
@ApiModel(value = "${className}", description = "${className}入参对象")
public class ${className} extends BaseFacadeParam {
    private static final long serialVersionUID = 5454155825314635342L;  
      
    <#list table.columns as column>
    @ApiModelProperty(value = "${column.remarks}")
    private ${column.simpleJavaType} ${column.columnNameLower};  
    </#list>  
 
<@generateJavaColumns/> 



public static  ${className}Param new${className}Param () {
	return new ${className}Param ();
}

 
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