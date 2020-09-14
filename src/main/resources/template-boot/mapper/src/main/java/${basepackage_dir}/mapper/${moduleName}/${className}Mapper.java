
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   

package ${basepackage}.mapper.${moduleName};

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import ${basepackage}.domain.${moduleName}.${className};


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

//    /**
//     * 获得分页数据
//     * @param record
//     * @return
//     */
//    List<${className}> listPage(${className} record);

//    /**
//     * 分页接口获得数据条数
//     * @param record
//     * @return
//     */
//    Long listPageCount(${className} record);

    /**
     * 通过参数获得数据
     * @param record
     * @return
     */
    List<${className}> list(${className} record);

    /**
     * 获得单个数据
     * @param record
     * @return
     */
    ${className} getBy(${className} record);

    /**
     * 根据id删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(String id);

    /**
     * 删除数据
     * @param record
     * @return
     */
    int deleteSelective(${className} record);

    /**
     * 根据id列表量删除
     * @param idList
     * @return
     */
    int batchDelete(List<String> idList);

    /**
     * 插入数据
     * @param record
     * @return
     */
    int insertSelective(${className} record);

    /**
     * 更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(${className} record);

    /**
     * 全量更新数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(${className} record);

    /**
     * 批量插入多个
     * @param recordList
     * @return
     */
    int batchInsert(List<${className}> recordList);

}