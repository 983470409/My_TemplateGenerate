
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>

<#macro url name>${r"${"}${name}${r"-URL:}"}</#macro>
package ${basepackage}.facade;

import org.springframework.cloud.openfeign.FeignClient;
import ${basepackage}.api.${className}Api;
import ${basepackage}.facade.fallback.${className}FacadeFallback;
/**
 <#include "/java_description.include">
 */
@FeignClient(value = "${application}", url="<@url "${application}"/>", fallbackFactory = ${className}FacadeFallback.class)
public interface ${className}Facade extends ${className}Api{

}
