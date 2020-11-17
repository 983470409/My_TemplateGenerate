
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   

package ${basepackage}.dao.read;

import java.util.List;
import ${basepackage}.vo.${className}Vo;
import ${basepackage}.entity.${className};


/**
 <#include "/java_description.include">
 */
public interface ${className}ReaderDao {
    /**
     * 根据主键id获得数据
     * @param id
     * @return
     */
    ${className} selectByPrimaryKey(Long id);

    /**
     * 根据主键id列表获得数据
     * @param ids
     * @return
     */
    List<${className}> selectByPrimaryKeys(List<String> ids);

    /**
     * 通过参数获得数据
     * @param t
     * @return
     */
    List<${className}> get${className}s(${className}ListDto t);

    /**
     * 分页接口获得数据条数
     * @param t
     * @return
     */
    Long listPageCount(${className}PageDto t);


    /**
     * 获得分页数据
     * @param t
     * @return
     */
    List<${className}> listPage(${className}PageDto t);


}