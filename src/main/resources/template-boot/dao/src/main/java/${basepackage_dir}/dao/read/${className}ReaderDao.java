<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   

package ${basepackage}.dao.read;

import java.util.List;
import java.util.Map;
import ${basepackage}.vo.${className};


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
     * 通过参数获得数据
     * @param t
     * @return
     */
    List<${className}> get${className}s(${className}Vo t);

    /**
     * 分页接口获得数据条数
     * @param paramMap
     * @return
     */
    Long listPageCount(${className}Vo t);

    /**
     * 获得单个数据
     * @param t
     * @return
     */
    ${className} get${className}By(${className}Vo t);

    /**
     * 获得分页数据
     * @param paramMap
     * @return
     */
    List< ${className}> listPage(${className}Vo t);

}