<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import com.gzhc365.${deptFlag}.common.PageParam;
import com.gzhc365.${deptFlag}.common.PageBean;
import java.util.List;
import ${basepackage}.vo.${className}Vo;
import ${basepackage}.entity.${className};
/**
 <#include "/java_description.include">
 */
public interface ${className}Service  {

    /**
     * 获取数据
     * @param ${classNameLower}Vo
     * @return
     */
    List<${className}> get${className}sBy(${className}Vo ${classNameLower}Vo);

    /**
     * 通过主键id获得数据
     * @param id
     * @return
     */
    ${className} getById(long id);

    /**
     * 分页获取数据
     * @param ${classNameLower}Vo
     * @return
     */
    PageBean<${className}> listPage(${className}Vo ${classNameLower}Vo);

    /**
     * 新增对象
     * @param ${classNameLower}
     * @return
     */
    ${className} save(${className}Vo ${classNameLower}Vo) ;

    /**
     * 更新对象
     * @param ${classNameLower}
     * @return
     */
    ${className} update(${className}Vo ${classNameLower}Vo);

    /**
     * 通过Vo获得单个对象
     * @param ${classNameLower}Vo
     * @return
     */
    ${className} get${className}By(${className}Vo ${classNameLower}Vo );


    
}
