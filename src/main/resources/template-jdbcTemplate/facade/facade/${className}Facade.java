<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
package ${basepackage}.service;

import ${basepackage}.common.exception.AlarmCenterException;
import ${basepackage}.entity.${className};
import ${basepackage}.vo.${className}Vo;
import com.gzhc365.component.utils.entity.HcContext;
import java.util.List;
import java.util.Map;

/**
 <#include "/java_description.include">
 */
public interface ${className}Facade {

    boolean delete(Integer id, HcContext context) throws AlarmCenterException;

    boolean add(${className} ${classNameLower}, HcContext context) throws AlarmCenterException;

    ${className} getById(Integer id, HcContext context) throws AlarmCenterException;

    boolean update(${className} ${classNameLower}, HcContext context) throws AlarmCenterException;

    Map<String,Object> page(${className}Vo ${classNameLower}Vo, HcContext context) throws AlarmCenterException;

    /**
     * 查询所有数据
     * @param context
     * @return
     * @throws AlarmCenterException
     */
    List<${className}> findAll(HcContext context) throws AlarmCenterException;

}