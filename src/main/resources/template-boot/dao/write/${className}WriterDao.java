
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>   

package ${basepackage}.dao.write;

import ${basepackage}.entity.${className};
import java.util.List;

/**
 <#include "/java_description.include">
 */
public interface ${className}WriterDao {

    /**
     * 删除数据
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据
     * @param t
     * @return
     */
    int deleteSelective( ${className} t);

    /**
     * 插入数据
     * @param t
     * @return
     */
    int insertSelective( ${className} t);

    /**
     * 更新数据
     * @param t
     * @return
     */
    int updateByPrimaryKeySelective( ${className} t);

//    /**
//     * 批量插入多个
//     * @param t
//     * @return
//     */
//    int batchInsert(List<${className}> t);


}