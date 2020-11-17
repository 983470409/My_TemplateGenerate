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
    ${className} save(${className} ${classNameLower});

    /**
     * 更新对象
     * @param ${classNameLower}
     * @return
     */
    ${className} update(${className} ${classNameLower});

    /**
     * 删除
     * @param ${classNameLower}
     * @return
     */
    ${className} delete(${className} ${classNameLower});

    /**
     * 删除
     * @param ${classNameLower}
     * @return
     */
    int deleteById(Long id);

}
