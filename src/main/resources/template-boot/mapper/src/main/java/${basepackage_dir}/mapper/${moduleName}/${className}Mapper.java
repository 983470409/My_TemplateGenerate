
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   

package ${basepackage}.mapper.${moduleName};

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ${basepackage}.domain.${moduleName}.${className};
import ${basepackage}.dto.${moduleName}.${className}Dto;


/**
 <#include "/java_description.include">
 */
@Mapper
public interface ${className}Mapper {
    /**
     * 根据主键id获得数据
     * @param id
     * @return
     */
    ${className} selectByPrimaryKey(String id);

    /**
     * 根据主键id列表获得数据
     * @param ids
     * @return
     */
    List<${className}> selectByPrimaryKeys(List<String> ids);

    /**
     * 通过参数获得数据
     * @param ${classNameLower}Dto
     * @return
     */
    List<${className}> list(${className}Dto ${classNameLower}Dto);

    /**
     * 获得单个数据
     * @param ${classNameLower}Dto
     * @return
     */
    ${className} getBy(${className}Dto ${classNameLower}Dto);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 删除数据
     * @param ${classNameLower}Dto
     * @return
     */
    int deleteSelective(${className}Dto ${classNameLower}Dto);

    /**
     * 根据id列表量删除
     * @param idList
     * @return
     */
    int batchDelete(List<String> idList);

    /**
     * 插入数据
     * @param ${classNameLower}
     * @return
     */
    int insertSelective(${className} ${classNameLower});

    /**
     * 更新数据
     * @param ${classNameLower}
     * @return
     */
    int updateByPrimaryKeySelective(${className} ${classNameLower});

    /**
     * 全量更新数据
     * @param ${classNameLower}
     * @return
     */
    int updateByPrimaryKey(${className} ${classNameLower});

    /**
     * 批量插入多个
     * @param ${classNameLower}List
     * @return
     */
    int batchInsert(List<${className}> ${classNameLower}List);

}