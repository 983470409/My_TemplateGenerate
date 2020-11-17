<#assign className = table.className>
<#assign classNameLower = className?uncap_first> 
package ${basepackage}.service;

import com.gzhc365.${deptFlag}.common.vo.PageBean;
import java.util.List;
import ${basepackage}.dto.*;
import ${basepackage}.entity.${className};
/**
 <#include "/java_description.include">
 */
public interface ${className}Service  {

    /**
     * 获取数据
     * @param ${classNameLower}ListDto
     * @return
     */
    List<${className}> get${className}sBy(${className}ListDto ${classNameLower}ListDto);

    /**
     * 通过主键id获得数据
     * @param id
     * @return
     */
    ${className} getById(long id);

    /**
     * 分页获取数据
     * @param ${classNameLower}PageDto
     * @return
     */
    PageBean<${className}> listPage(${className}PageDto ${classNameLower}PageDto);

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
    int update(${className} ${classNameLower});

    /**
     * 删除
     * @param ${classNameLower}
     * @return
     */
    int delete(${className} ${classNameLower});

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteById(Long id);

    /**
     * 根据主键id列表获得数据
     * @param ids
     * @return
     */
    List<${className}> selectByPrimaryKeys(List<String> ids);

    /**
     * 根据主键id列表删除数据
     * @param ids
     * @return
     */
    int deleteByIds(List<String> ids);

}
