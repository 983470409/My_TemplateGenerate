<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.facade.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.gzhc365.common.utils.Utils;
import com.gzhc365.component.utils.entity.HcContext;
import com.gzhc365.component.utils.entity.PageBean;
import com.gzhc365.component.utils.entity.PageParam;

import ${basepackage}.entity.${className};
import ${basepackage}.service.${className}Service;
import ${basepackage}.facade.${className}Facade;

<#include "/java_imports.include">

/**
<#include "/java_description.include">
 */
@Service
public class ${className}FacadeImpl implements ${className}Facade {

    
    @Autowired
    private ${className}Service ${classNameLower}Service;

    @Override
    public List<${className}> getBy(${className} t, HcContext context) {
        return ${classNameLower}Service.getBy(t,context);
    }

    @Override
    public ${className} getById(long id, HcContext context) {
        return ${classNameLower}Service.getById(id, context);
    }

    @Override
    public ${className} getById(${className} t, HcContext context) {
        return ${classNameLower}Service.getById(t,context);
    }

    @Override
    public boolean save(${className} t, HcContext context) {
        
        return !Utils.isEmpty( ${classNameLower}Service.save(t, context));
    }

    @Override
    public boolean update(${className} t, HcContext context) {
        return !Utils.isEmpty(${classNameLower}Service.update(t, context));
    }

    @Override
    public PageBean<?> listPage(PageParam pageParam, Map<String, Object> paramMap, HcContext context) {
        return ${classNameLower}Service.listPage(pageParam, paramMap, context);
    }
    
}
