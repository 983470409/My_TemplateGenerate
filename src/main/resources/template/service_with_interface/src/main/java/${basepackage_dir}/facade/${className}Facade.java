<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.facade;

import com.gzhc365.component.core.facade.BaseFacade;
import com.gzhc365.component.utils.entity.HcContext;
import ${basepackage}.entity.${className};


<#include "/java_imports.include">

/**
<#include "/java_description.include">
 */
public interface ${className}Facade extends BaseFacade<${className}> {

    
}
