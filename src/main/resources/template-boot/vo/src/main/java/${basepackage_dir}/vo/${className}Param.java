<#include "/java_copyright.include">  
<#assign className = table.className>     
<#assign classNameLower = className?uncap_first>   
package ${basepackage}.vo;
 
import java.sql.Date;
import com.gzhc365.ehis.core.vo.BaseFacadeParam;
 
public class ${className}Param extends BaseFacadeParam {  
    private static final long serialVersionUID = 5454155825314635342L;  
      
    <#list table.columns as column>  
    /**  
     * ${column.remarks}  
     */ 
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