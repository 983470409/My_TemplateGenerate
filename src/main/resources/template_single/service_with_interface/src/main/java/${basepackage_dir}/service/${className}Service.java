<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import com.eteam.common.entity.TeamContext;
import com.eteam.common.service.BaseService;
<#include "/java_imports.include">

/**
<#include "/java_description.include">
 */
public interface ${className}Service extends BaseService<${className}> {

    
}
