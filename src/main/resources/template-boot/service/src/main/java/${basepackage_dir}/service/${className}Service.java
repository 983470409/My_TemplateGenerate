<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import com.gzhc365.ehis.core.service.BaseService;
<#include "/java_imports.include">

/**
 <#include "/java_description.include">
 */
public interface ${className}Service  {
	
	
    public List<${className}> get${className}sBy(${className} ${classNameLower});


    public ${className} getById(long id);
    
    
    public PageBean<${className}> listPage(PageParam pageParam);
    
    
    public ${className} save(${className} ${classNameLower}) ;
    
    
    public ${className} update(final ${className} t) throws Exception;
    
    
    
    public ${className} get${className}By(${className} ${classNameLower} ) throws Exception ;


    
}
