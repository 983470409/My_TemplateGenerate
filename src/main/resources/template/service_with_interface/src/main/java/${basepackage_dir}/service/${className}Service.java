<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import org.springframework.stereotype.Service;
import com.gzhc365.component.core.service.BaseService;
import com.gzhc365.component.utils.entity.HcContext;
<#include "/java_imports.include">

/**
<#include "/java_description.include">
 */
public interface ${className}Service extends BaseService<${className}> {

    
}
